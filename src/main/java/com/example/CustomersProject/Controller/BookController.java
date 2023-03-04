package com.example.CustomersProject.Controller;

import com.example.CustomersProject.Domain.Book;
import com.example.CustomersProject.Domain.Customer;
import com.example.CustomersProject.Service.BookService;
import com.example.CustomersProject.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {
    @Autowired
    CustomerService customerService;
    @Autowired
    BookService bookService;


    @GetMapping("/books")
    public String viewMainPage(Model model){
        final List<Book> bookList = bookService.getBooks();
        model.addAttribute("booklist",bookList);
        return "books";

    }
    @GetMapping("/new-book")
    public String showMeCars(Model model){
        Book book = new Book();
        model.addAttribute("book", book);
        return "new-book";

    }
    @PostMapping("/books")
    public String saveBooks(@ModelAttribute ("book") Book book,Model model){
        try {
            bookService.saveBook(book);
        } catch (Exception e) {
           model.addAttribute("message", "could not save the new book entered" + e.getMessage());
           return "error-page";
        }
        return "redirect:/books";
    }
    @DeleteMapping("remove/{id}")
    public String removeBooks(@PathVariable( name = "id") Long bookId){
        Book book = bookService.getBook(bookId);
        book.setId(null);
        bookService.saveBook(book);
        return "redirect:/";
    }
    @GetMapping("/books/assign/{id}")
    public String assignBook(@PathVariable(name = "id") Long id, Model model) {
       Customer customer = customerService.getCustomer(id);
        List<Book> bookList = bookService.findAllAvalibleBooks();

        model.addAttribute("customer", customer);
        model.addAttribute("bookList", bookList);
        return "assign-book";
    }
    @PostMapping("/books/assign")
    public String saveBookAssignment(@RequestParam("customerId") Long customerId, @RequestParam("bookId") Long bookId){
        Book book = bookService.getBook(bookId);
        book.setCustomer(customerService.getCustomer(customerId));
        bookService.saveBook(book);
        return "redirect:/";
    }




}
