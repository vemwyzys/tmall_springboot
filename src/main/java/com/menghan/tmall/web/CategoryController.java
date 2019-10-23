package com.menghan.tmall.web;

import com.menghan.tmall.annotation.LocalLock;
import com.menghan.tmall.pojo.Category;
import com.menghan.tmall.service.CategoryService;
import com.menghan.tmall.util.ImageUtil;
import com.menghan.tmall.util.Page4Navigator;
import org.elasticsearch.common.recycler.Recycler;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * 这个就是专门用来提供 RESTFUL 服务器控制器了
 *
 * @RestController 表示这是一个控制器，并且对每个方法的返回值都会直接转换为 json 数据格式。
 *                  相当于@ResponseBody ＋ @Controller合在一起的作用。
 *                  @responseBody注解的作用是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据或者是XML
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

    @PostMapping(value = "/categories")
    public Object add(Category bean, MultipartFile image, HttpServletRequest request) throws Exception{
        categoryService.add(bean);
        saveOrUpdateImageFile(bean, image, request);
        return bean;
    }

    private void saveOrUpdateImageFile(Category bean, MultipartFile image, HttpServletRequest request) throws IOException {
        File imageFolder= new File(request.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,bean.getId()+".jpg");
        if(!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }

    @DeleteMapping(value = "/categories/{id}")
    public String delete(@PathVariable("id")int id, HttpServletRequest request){
        categoryService.delete(id);
        return null;
    }

    @GetMapping(value = "/categories/{id}")
    public Category get(@PathVariable("id")int id, HttpServletRequest request){
        Category bean = categoryService.get(id);
        return bean;
    }

    //@LocalLock(key = "Category:arg[0]")//防止重复提交,有空指针异常问题
    @PutMapping(value = "/categories/{id}")
    public Object update(MultipartFile image, Category bean, HttpServletRequest request) throws Exception{
//        String name = request.getParameter("name");
//        bean.setName(name);
        //参数顺序不能变(MultipartFile image, Category bean, HttpServletRequest request)
        categoryService.update(bean);
        if(image!=null){
            saveOrUpdateImageFile(bean, image, request);
        }
        return bean;
    }
}
