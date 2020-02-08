package com.kctud.service;

import com.kctud.domain.Book;
import com.kctud.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
     * 分頁查詢
     * @return
     */
    public Page<Book> findAllByPage(){
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(1, 3, sort);
        return bookRepository.findAll(pageable);
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

    /**
     * 測試Transaction
     * @param id
     * @param status
     * @param uuid
     * @return
     */
    @Transactional
    public int deleteAndUpdate(long id, int status, long uuid){
        int dcount = bookRepository.deleteByJPQL(id);
        int ucount = bookRepository.updateByJPQL(status, uuid);
        return dcount+ucount;
    }
}
