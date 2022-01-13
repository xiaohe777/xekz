package com.xekz.mapper;

import com.xekz.base.BaseMapper;
import com.xekz.bean.CaterBook;

public interface CaterBookMapper extends BaseMapper<CaterBook,Integer> {
    int countBookCateringNum(Integer bookId);


    int deleteBookCaterByBookId(Integer bookId);

    int addCaterBook(CaterBook caterBook);

    CaterBook selectByBookId(Integer bookId);

    void updateCaterBook(CaterBook caterBook);
}