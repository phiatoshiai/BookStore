package vn.phi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.phi.entity.Author;
import vn.phi.entity.Book;
import vn.phi.entity.Category;
import vn.phi.service.CategoryService;
import vn.phi.service.Impl.AuthorServiceImpl;
import vn.phi.service.Impl.BookServiceImpl;
import vn.phi.validation.Create;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class MainController {

    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    private AuthorServiceImpl authorService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{pageNum}")
    public String home(@PathVariable("pageNum") int pageNum, Model model) {
        Page<Book> books = bookService.getAllBook(PageRequest.of(pageNum - 1, 10));
        List<Integer> pageList = IntStream.rangeClosed(1, books.getTotalPages()).boxed().collect(Collectors.toList());
        model.addAttribute("bookHome", books);
        model.addAttribute("pageList", pageList);
        return "home";
    }

    /*
    SEARCH BOOK
    SEARCH BOOK
    SEARCH BOOK
     */
    @PostMapping("/search")
    public String searchBookByName(@RequestParam("searchName") String searchName, Model model) {
        Page<Book> books = bookService.getBookByNameContaining(searchName, PageRequest.of(0, 10));
        List<Integer> pageList = IntStream.rangeClosed(1, books.getTotalPages()).boxed().collect(Collectors.toList());
        if (books == null) {
            return "redirect:/1";
        }
        model.addAttribute("searchName", searchName);
        model.addAttribute("bookSearch", books);
        model.addAttribute("pageList", pageList);
        return "searchBookByName";
    }

    /*
    ADD BOOK
    ADD BOOK
    ADD BOOK
     */
    @GetMapping("/addBook")
    public String addNewBook(Model model) {
        Book newBook = new Book();
        List<Author> authors = authorService.getAllAuthor();
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("authorAddBook", authors);
        model.addAttribute("newBook", newBook);
        model.addAttribute("categoryAddBook", categories);
        return "add-new-book";
    }

    @PostMapping("/saveNewBook")
    public String saveNewBook(@Validated({Create.class}) @ModelAttribute("newBook") Book newBook, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Author> authors = authorService.getAllAuthor();
            List<Category> categories = categoryService.getAllCategory();
            model.addAttribute("authorAddBook", authors);
            model.addAttribute("categoryAddBook", categories);
            return "add-new-book";
        }
        bookService.saveBook(newBook);
        return "redirect:/1";
    }

    /*
    ADD AUTHOR
    ADD AUTHOR
    ADD AUTHOR
     */
    @GetMapping("/addAuthor")
    public String addAuthor(Model model){
        Author author = new Author();
        model.addAttribute("newAuthor", author);
        return "add-author";
    }

    @PostMapping("/saveAuthor")
    public String saveAuthor(@Validated @ModelAttribute("newAuthor") Author newAuthor, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "add-author";
        }
        authorService.saveAuthor(newAuthor);
        return "redirect:/1";
    }

    /*
    EDIT BOOK
    EDIT BOOK
    EDIT BOOK
     */
    @GetMapping("/editBook")
    public String editBook(Model model, @RequestParam("id") int id) {
        Book book = bookService.getBookById(id);
        modelAndList(model, book);
        return "editBook";
    }

    @PostMapping("/saveEditBook")
    public String saveEditBook(@Validated({Create.class}) @ModelAttribute("newBook") Book newBook, BindingResult bindingResult, Model model) {
        Book books = bookService.getBookById(newBook.getId());
        if (books.getName().equals(newBook.getName())) {
            bookService.saveBook(newBook);
            return "redirect:/1";
        }

        if (bindingResult.hasErrors()) {
            modelAndList(model,newBook);
            model.addAttribute("message","Đã tồn tại tên sách, vui lòng nhập lại");
            return "editBook";
        } else {
            bookService.saveBook(newBook);
            return "redirect:/1";
        }
    }

    /*
    DELETE BOOK
    DELETE BOOK
    DELETE BOOK
     */

    @GetMapping("/deleteBook")
    public String deleteBook(@RequestParam("id") int id, Model model){
        bookService.deleteBook(id);
        return "redirect:/1";
    }

    public void modelAndList(Model model, Book book) {
        List<Author> authors = authorService.getAllAuthor();
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("authorEdit", authors);
        model.addAttribute("categoryEdit", categories);
        model.addAttribute("book", book);
    }
}
