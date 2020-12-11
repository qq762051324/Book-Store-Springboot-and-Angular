package com.yiwen.demo.Controller;

import com.yiwen.demo.Dao.BookDao;
import com.yiwen.demo.Entities.Book;
import com.yiwen.demo.Entities.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
@CrossOrigin
public class BookCon {
    @Autowired
    private BookDao bookDao;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "Test with success!";
    }

    /**
     * 方法一 通过id查询 这里通过{}传入参数
     * 需要手动一一对应 @PathVariable("name") String name2
     *
     * 方法二 直接用get 通过@RequestParam要求 默认必填
     * 而且里面要求必须有id的数据
     * */
    @GetMapping("/bookId")
    @ResponseBody
    public Book ById(@RequestParam(name = "id")long id){
        Book result = bookDao.findById(id);
        System.out.println(result);
        return result;
    }
    /**
     * 首先创建实例Page 需要在之前查询的时候增加参数 PageRequest() 起始 大小 顺序和参数(顺序的)
     * Pageable pageable = new PageRequest(0,3, Sort.Direction.DESC,"id");
     * */
    @GetMapping("/page")
    @ResponseBody
    public Page<Book> page(@RequestParam int size,@RequestParam int number){
        PageRequest request = PageRequest.of(number,size);
        Page<Book> page = bookDao.findAll(request);
        System.out.println(page);
        return page;
    }

    @GetMapping("/categoryId")
    @ResponseBody
    public Page<Book> ByCategoryId(@RequestParam long id,@RequestParam(required = false,defaultValue = "6") int size,@RequestParam(required = false,defaultValue = "1") int number){
        PageRequest request = PageRequest.of(number,size);
        Page<Book> page = bookDao.findByCategoryId(id,request);
        System.out.println(page);
        System.out.println("size"+size);
        System.out.println("pageNo"+number);
        return page;
    }

    @GetMapping("/bookName")
    @ResponseBody
    public Page<Book> byName(@RequestParam(name = "name") String name,@RequestParam(required = false,defaultValue = "6") int size,@RequestParam(required = false,defaultValue = "1") int number){
        PageRequest request = PageRequest.of(number,size);
        Page<Book> page = bookDao.findBooksByNameLike( "%"+name+"%",request);
        return page;
    }

    @GetMapping("/all")
    @ResponseBody
    public Page<Book> QueryAll(@RequestParam(required = false,defaultValue = "6") int size,@RequestParam(required = false,defaultValue = "1") int number){
        PageRequest request = PageRequest.of(number,size);
        Page<Book> page = bookDao.findAll(request);
        System.out.println(page);
        System.out.println("size"+size);
        System.out.println("pageNo"+number);
        return page;
    }

    @RequestMapping("/add")
    public String add(){
        List<Book> list=new ArrayList<>();
        for(int i =0;i<10;i++){
            BookCategory bookCategory = new BookCategory();
            bookCategory.setId(2);
            Book book=new Book();
            book.setUnitPrice(BigDecimal.valueOf(100));
            book.setCategory(bookCategory);
            book.setName("High energy team"+Integer.toString(i));
            book.setImgUrl("assets/img/boy.png");
            list.add(book);
        }
        bookDao.saveAll(list);
        return null;
    }
}
