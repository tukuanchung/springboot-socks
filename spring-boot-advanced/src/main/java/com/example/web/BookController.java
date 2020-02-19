package com.example.web;

import com.example.dmain.Book;
import com.example.exception.BookNotFoundException;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kuanchungtu on 2020/2/19
 */
@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 書單詳情
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public String getBook(@PathVariable Long id, Model model){
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "book";
    }
}
