package com.kctud.service;

import com.kctud.domain.Book;
import com.kctud.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public List findByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }

    public List findByAuthorAndStatus(String author, int status){
        return bookRepository.findByAuthorAndStatus(author, status);
    }

    public List<Book> findByDescriptionEndsWith(String des){
        return bookRepository.findByDescriptionEndsWith(des);
    }

    public List<Book> findByJPQL(int len){
        return bookRepository.findByJPQL(len);
    }

    @Transactional
    public int updateByJPQL(int status, long id){
        return bookRepository.updateByJPQL(status, id);
    }

    @Transactional
    public int deleteByJPQL(long id){
        return bookRepository.deleteByJPQL(id);
    }
}
