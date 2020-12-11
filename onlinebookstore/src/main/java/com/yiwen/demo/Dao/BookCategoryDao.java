package com.yiwen.demo.Dao;

import com.yiwen.demo.Entities.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryDao extends JpaRepository<BookCategory,Long> {
}
