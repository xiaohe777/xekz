package com.xekz.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xekz.base.BaseQuery;

import java.util.Date;

public class OrderQuery extends BaseQuery {
    private Integer roomId;
    private String roomType;
    private Double roomPrice;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date entryDate;

    @Override
    public String toString() {
        return "OrderQuery{" +
                "roomId=" + roomId +
                ", roomType='" + roomType + '\'' +
                ", roomPrice=" + roomPrice +
                ", entryDate=" + entryDate +
                '}';
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public OrderQuery() {
    }

    public OrderQuery(Integer roomId, String roomType, Double roomPrice) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(Double roomPrice) {
        this.roomPrice = roomPrice;
    }

}
