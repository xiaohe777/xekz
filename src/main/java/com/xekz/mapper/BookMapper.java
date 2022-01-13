package com.xekz.mapper;

import com.xekz.base.BaseMapper;
import com.xekz.bean.Book;
import com.xekz.bean.CaterBook;

import java.util.List;

public interface BookMapper extends BaseMapper<Book,Integer> {

    Book selectBookById(Integer bookId);

    List<CaterBook> selectAll();
}