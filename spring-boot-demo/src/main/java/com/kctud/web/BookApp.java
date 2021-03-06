package com.kctud.web;

import com.kctud.domain.Book;
import com.kctud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public Page<Book> getAll(@RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "5") int size){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");

//        return bookService.findAll();
        return bookService.findAllByPage(PageRequest.of(page, size, sort));

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
    public int findBy(@RequestParam long id,
                      @RequestParam int status,
                      @RequestParam long uid){
//        return bookService.findByAuthorAndStatus(author, status);
//        return bookService.findByDescriptionEndsWith(des);
//        return bookService.findByJPQL(len);
//        return bookService.updateByJPQL(status,id);
//        return bookService.deleteByJPQL(id);
        return bookService.deleteAndUpdate(id, status, uid);
    }


}
