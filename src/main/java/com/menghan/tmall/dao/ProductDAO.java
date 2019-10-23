package com.menghan.tmall.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.menghan.tmall.pojo.Category;
import com.menghan.tmall.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product,Integer> {
    Page<Product> findByCategory(Category category, Pageable pageable);
}