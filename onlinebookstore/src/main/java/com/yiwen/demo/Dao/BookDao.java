package com.yiwen.demo.Dao;

import com.yiwen.demo.Entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book,Long> {
    Book findById(long id);

    Page<Book> findByCategoryId(long id,Pageable pageable);
    Page<Book> findBooksByNameLike(String name,Pageable pageable);

    Page<Book> findAll(Pageable pageable);
}
