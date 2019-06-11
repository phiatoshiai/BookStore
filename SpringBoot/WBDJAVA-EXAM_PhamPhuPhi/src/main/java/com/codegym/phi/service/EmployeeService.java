package com.codegym.phi.service;

import com.codegym.phi.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
//
   List<Employee> getAllEmployee();
//
   Employee getEmployeeById(int id);
//
//    Page<Employee> getEmployeeByNameContaining(String name, Pageable pageable);

    Page<Employee> getAllEmployee(Pageable pageable);
//
   void saveEmployee(Employee employee);
//
   void deleteEmployee(int id);

   List<Employee> getAllByContaining(String name);



}
