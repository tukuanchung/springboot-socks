package com.kctud.web;

import com.kctud.domain.Book;
import com.kctud.service.BookService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by kuanchungtu on 2020/2/5
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String list(Model model){
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/books/{id}")
    public String detail(@PathVariable long id, Model model){

        Book book = bookService.findOne(id);
        if(book == null){
            book = new Book();
        }

        model.addAttribute("book", book);
        return "book";
    }

    /**
     *  跳轉input提交頁面
     * @return
     */
    @GetMapping("/books/input")
    public String inputPage(Model model){
        model.addAttribute("book", new Book());
        return "input";
    }

    @PostMapping("/books")
    public String post(Book book){
        bookService.save(book);
        return "redirect:/books";
    }

    /**
     * 跳轉到更新頁面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/books/{id}/input")
    public String inputEditPage(@PathVariable long id, Model model){
        Book book = bookService.findOne(id);
        model.addAttribute("book", book);
        return "input";
    }
}
