package com.menghan.tmall.service;

import com.menghan.tmall.dao.CategoryDAO;
import com.menghan.tmall.pojo.Category;
import com.menghan.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    //第一版，没有分页功能，功能：获取所有category
    public List<Category> list(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDAO.findAll(sort);
    }

    // 第二版，有分页功能，
    // 使用了util包里的{JPA 默认提供了一个分页类：org.springframework.data.domain.Page}的一个自制封装类，
    // 这个自制的Page4Navigator会多接收一个navigatePages参数。
    public Page4Navigator<Category> list(int start, int size, int navigatePages){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page pageFromJPA = categoryDAO.findAll(pageable);

        //警告原因：把一个Map类型的数据，强制类型转换的时候。
        //简单解决方案：在本类名的前面加上@SuppressWarnings("unchecked")
        //不过我没加，回头处理,并且复习map
        return new Page4Navigator<>(pageFromJPA, navigatePages);
    }

    public void add(Category bean){
        categoryDAO.save(bean);
    }

    public void delete(int id){
        categoryDAO.delete(id);
    }

    public Category get(int id){
        Category category = categoryDAO.findOne(id);
        return category;
    }

    public void update(Category bean){
        categoryDAO.save(bean);
    }
}