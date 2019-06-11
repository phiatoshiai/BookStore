package com.codegym.phi.controller;

import com.codegym.phi.entity.Employee;
import com.codegym.phi.service.Impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class MainController {
    private static final String search_pattern = "[a-z]";

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/home")
    public String home(Model model) {
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employeeList", employees);
        return "home";
    }

    @GetMapping("/addEmployee")
    public String addEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("newEmployee", employee);
        return "add-employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@Validated @ModelAttribute("newEmployee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-employee";
        }
        employeeService.saveEmployee(employee);
        return "redirect:/home";
    }

    @GetMapping("/editEmployee")
    public String editEmployee(@RequestParam("id") int id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "edit-employee";
    }

    @PostMapping("/saveEmployeeEdit")
    public String saveEditEmployee(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit-employee";
        }
        employeeService.saveEmployee(employee);
        return "redirect:/home";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("id") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/home";
    }

    @PostMapping("/search")
    public String searchEmployee(@RequestParam("searchName") String searchName, Model model) {
        List<Employee> employees = employeeService.getAllByContaining(searchName);
        model.addAttribute("employeeList", employees);
        return "home";
    }

}
