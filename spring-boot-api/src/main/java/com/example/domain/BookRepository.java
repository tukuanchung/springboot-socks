package com.example.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kuanchungtu on 2020/2/22
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
