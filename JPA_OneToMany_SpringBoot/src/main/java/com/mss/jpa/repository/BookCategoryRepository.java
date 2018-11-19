package com.mss.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mss.jpa.model.BookCategory;

@Repository
public interface BookCategoryRepository  extends JpaRepository<BookCategory, Integer>{

}
