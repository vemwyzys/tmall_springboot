package com.menghan.tmall.web;

import com.menghan.tmall.pojo.Category;
import com.menghan.tmall.service.CategoryService;
import com.menghan.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 这个就是专门用来提供 RESTFUL 服务器控制器了
 *
 * @RestController 表示这是一个控制器，并且对每个方法的返回值都会直接转换为 json 数据格式。
 * @Autowired CategoryService categoryService;
 * 自动装配 CategoryService
 * @GetMapping("/categories") public List<Category> list() throws Exception {
 * return categoryService.list();
 * }
 * 对于categories 访问，会获取所有的 Category对象集合，并返回这个集合。 因为是声明为 @RestController， 所以这个集合，又会被自动转换为 JSON数组抛给浏览器。
 */
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /*@GetMapping("/categories")
    public List<Category> list() throws Exception {
        return categoryService.list();
    }*/

    //GET和POST请求传的参数会自动转换赋值到@RequestParam 所注解的变量上
    //@RequestParam（org.springframework.web.bind.annotation.RequestParam）用于将指定的请求参数赋值给方法中的形参。
    @GetMapping(value = "/categories")
    public Page4Navigator<Category> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size)throws Exception{
        start =  start<0?0:start;

        //警告内容是多余的变量，原因是可以直接{return categoryService.list(start, size, 5);}
        Page4Navigator<Category> page = categoryService.list(start, size, 5);
        return page;
    }

}
