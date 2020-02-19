package com.example.dmain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kuanchungtu on 2020/2/18
 */
public interface BookRepository extends JpaRepository<Book, Long> {

}
