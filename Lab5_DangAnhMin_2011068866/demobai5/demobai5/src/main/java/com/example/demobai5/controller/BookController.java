package com.example.demobai5.controller;

import com.example.demobai5.entity.Book;
import com.example.demobai5.service.BookService;
import com.example.demobai5.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;

import java.util.Iterator;

import java.util.List;
@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String showAllBooks(Model model){
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book/List";
    }
    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "book/add";
    }
//    @PostMapping("/add")
//    public String addBook(@ModelAttribute("book") Book book, BindingResult result,Model model){
//        if(result.hasErrors()){
//            model.addAttribute("categories",categoryService.getAllCategories());
//            return "book/add";
//        }
//
//        bookService.addBook(book);
//        return "redirect:/books";
//    }
        @PostMapping("/add")
        public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult result,Model model){
            // check lỗi
            if(result.hasErrors()){
                model.addAttribute("categories",categoryService.getAllCategories());
                return "book/add";
            }
            bookService.addBook(book);
            return "redirect:/books";
        }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "book/edit";
    }
    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, @ModelAttribute("book") Book book) {
        book.setId(id);
        bookService.updateBook(book);
        return "redirect:/books";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

}