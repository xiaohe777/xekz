package com.xekz.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CaterBook {
    private Integer bookId;

    private String cateringId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;


    private Integer roomId;



    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }


    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getCateringId() {
        return cateringId;
    }

    public void setCateringId(String cateringId) {
        this.cateringId = cateringId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}