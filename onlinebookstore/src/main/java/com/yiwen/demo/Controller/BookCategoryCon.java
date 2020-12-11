package com.yiwen.demo.Controller;

import com.yiwen.demo.Dao.BookCategoryDao;
import com.yiwen.demo.Entities.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/bookCategory")
@CrossOrigin
public class BookCategoryCon {
    @Autowired
    private BookCategoryDao bookCategoryDao;

    @RequestMapping("/all")
    @ResponseBody
    public List<BookCategory> findAll(){
        List<BookCategory> list = new ArrayList<>();
        list = bookCategoryDao.findAll();
        return list;
    }
}
