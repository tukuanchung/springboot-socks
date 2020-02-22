package com.example.service;

import com.example.domain.Book;

import java.util.List;

/**
 * Created by kuanchungtu on 2020/2/22
 */
public interface BookService {
    List<Book> findAllBooks();
    Book getBook(Long id);
    Book saveBook(Book book);
    Book updateBook(Book book);
    void deleteBook(Long id);
    void deleteAllBooks();
}
