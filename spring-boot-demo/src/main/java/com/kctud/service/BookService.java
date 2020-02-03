package com.kctud.service;

import com.kctud.domain.Book;
import com.kctud.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by kuanchungtu on 2020/2/3
 */

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    /**
     * find all books
     * @return
     */
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    /**
     * add or upoda a book
     * @param book
     * @return
     */
    public Book save(Book book){
        return bookRepository.save(book);
    }

    /**
     * retrieve a book
     * @param id
     * @return
     */
    public Book findOne(long id){
        Optional<Book> rtn = bookRepository.findById(id);
        return rtn.get();
    }

    /**
     * delete a book
     * @param id
     */
    public void deleteOne(long id){
        bookRepository.deleteById(id);
    }
}
