package com.kctud.web;

import com.kctud.domain.Book;
import com.kctud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kuanchungtu on 2020/2/3
 */
@RestController
@RequestMapping("/api/v1")
public class BookApp {

    @Autowired
    private BookService bookService;

    /**
     * find all books
     * @return
     */

    @GetMapping("/books")
    public List<Book> getAll(){
        return bookService.findAll();
    }

    /**
     * add a book
     * @return
     */
    @PostMapping("/books")
    public Book post(Book book){

//        Book book = new Book();
//        book.setName(name);
//        book.setAuthor(author);
//        book.setDescription(description);
//        book.setStatus(status);
        return bookService.save(book);
    }

    /**
     * Get a book
     * @param id
     * @return
     */
    @GetMapping("/books/{id}")
    public Book findOne(@PathVariable long id){
        return bookService.findOne(id);
    }

    /**
     * update a book
     * @param id
     * @param name
     * @param author
     * @param description
     * @param status
     * @return
     */
    @PutMapping("/books")
    public Book update(@RequestParam long id,
                       @RequestParam String name,
                       @RequestParam String author,
                       @RequestParam String description,
                       @RequestParam int status) {
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setDescription(description);
        book.setStatus(status);
        return bookService.save(book);
    }

    /**
     * delete a book
     * @param id
     */
    @DeleteMapping("/books/{id}")
    public void deleteOne(@PathVariable long id){
        bookService.deleteOne(id);
    }


    @PostMapping("/books/by")
    public List<Book> findByAuthor(@RequestParam String des){
//        return bookService.findByAuthorAndStatus(author, status);
        return bookService.findByDescriptionEndsWith(des);
    }


}
