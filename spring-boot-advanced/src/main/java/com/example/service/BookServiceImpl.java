package com.example.service;

import com.example.dmain.Book;
import com.example.dmain.BookRepository;
import com.example.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kuanchungtu on 2020/2/19
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    /**
     * 獲取一個書單訊息
     * @param id
     * @return
     */
    @Override
    public Book getBookById(Long id){
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            throw new BookNotFoundException("书单信息不存在");
        }
        return book;
    }
}
