package com.example.api;

import com.example.domain.Book;
import com.example.dto.BookDTO;
import com.example.exception.InvalidRequestException;
import com.example.exception.NotFoundException;
import com.example.service.BookService;
import com.example.util.CustomBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kuanchungtu on 2020/2/22
 */

@RestController
@RequestMapping("/api/v1")
public class BookApi {

    @Autowired
    private BookService bookService;

    /**
     * 獲取書單列表
     * @return
     */
    @GetMapping("/books")
    public ResponseEntity<?> listAllBooks(){
        List<Book> books = bookService.findAllBooks();
        if(books.isEmpty()){
            throw new NotFoundException("Book Not Found");
        }
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBook(@PathVariable Long id){
        Book book = bookService.getBook(id);
        if(book == null){
            throw new NotFoundException(String.format("book by id %s not found",id));
        }
        return new ResponseEntity<Object>(book, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<?> saveBook(@Valid @RequestBody  BookDTO bookDTO,
                                      BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidRequestException("Invalid parameter",bindingResult);
        }
        Book book1 = bookService.saveBook(bookDTO.convertToBook());
        return new ResponseEntity<Object>(book1, HttpStatus.CREATED);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id,@Valid @RequestBody BookDTO bookDTO,
                                        BindingResult bindingResult){
        Book currentBook = bookService.getBook(id);
        if(currentBook == null){
            throw new NotFoundException(String.format("book by id %s not found",id));
        }
        if(bindingResult.hasErrors()){
            throw new InvalidRequestException("Invalid parameter",bindingResult);
        }
        bookDTO.convertToBook(currentBook);
        Book book1 = bookService.updateBook(currentBook);
        return new ResponseEntity<Object>(book1, HttpStatus.OK);
    }




    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/books")
    public ResponseEntity<?> deleteBooks(){
        bookService.deleteAllBooks();
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }
}
