package com.kctud.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by kuanchungtu on 2020/2/3
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);

    List<Book> findByAuthorAndStatus(String author, int status);

    List<Book> findByDescriptionEndsWith(String des);
    List<Book> findByDescriptionContains(String des);

//    @Query("select b from Book b where length(b.name) > ?1 ")
    @Query(value="select * from book where length(name) > ?1 ", nativeQuery = true)
    List<Book> findByJPQL(int len);


    @Modifying
    @Query("update Book b set b.status = ?1 where b.id = ?2 ")
    int updateByJPQL(int status, long id);

    @Transactional
    @Modifying
    @Query("delete from Book b where b.id = ?1 ")
    int deleteByJPQL(long id);
}
