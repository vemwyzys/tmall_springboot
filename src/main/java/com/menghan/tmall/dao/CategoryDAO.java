package com.menghan.tmall.dao;

import com.menghan.tmall.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public interface CategoryDAO extends JpaRepository<Category,Integer> {

}
