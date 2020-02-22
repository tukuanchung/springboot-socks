package com.example.dto;

import com.example.domain.Book;
import com.example.util.CustomBeanUtils;
import org.springframework.beans.BeanUtils;

/**
 * Created by kuanchungtu on 2020/2/22
 */
public class BookDTO {

    private Long id;
    private String author;
    private String description;
    private String name;
    private Integer status;

    public BookDTO(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 轉換傳輸對象
     * @param book
     */
    public void convert(Book book){
        new BookConvert().convert(this, book);
    }


    private class BookConvert implements Convert<BookDTO, Book>{

        @Override
        public Book convert(BookDTO bookDTO, Book book) {
            String[] nullPropertyName = CustomBeanUtils.getNullPropertyNames(bookDTO);
            BeanUtils.copyProperties(bookDTO, book, nullPropertyName);
            return book;
        }

        @Override
        public Book convert(BookDTO bookDTO) {
            return null;
        }
    }
}
