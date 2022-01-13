package com.xekz.controller;

import com.xekz.base.BaseController;
import com.xekz.base.ResultInfo;
import com.xekz.bean.Book;
import com.xekz.bean.CaterBook;
import com.xekz.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("book")
public class BookController extends BaseController {
    @Autowired
    private BookService bookService;

    @RequestMapping("index")
    public String index(){
        return "book/book";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> list(){
        return bookService.selectAll();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


    @RequestMapping("addOrUpdatePage")
    public String addOrUpdatePage(Integer bookId, Model model){
        if (bookId!=null){
            CaterBook caterBook = bookService.selectByBookId(bookId);
            model.addAttribute("caterBook",caterBook);
        }
        return "book/book_update";
    }

    @RequestMapping("save")
    @ResponseBody
    public ResultInfo save(Book book){
        System.out.println();
        bookService.addBook(book);
        return success("订单添加成功");
    }


    @RequestMapping("update")
    @ResponseBody
    public ResultInfo update(Book book){
        bookService.changeBook(book);
        return success("订单修改成功");
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo delete(Integer[] ids){
        bookService.removeUserIds(ids);
        return success("批量删除成功");
    }

    @RequestMapping("addCaterBook")
    @ResponseBody
    public ResultInfo addCaterBook(CaterBook caterBook){
        bookService.addCaterBook(caterBook);
        return success("操作成功");
    }
}
