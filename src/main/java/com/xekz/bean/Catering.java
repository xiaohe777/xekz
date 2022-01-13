package com.xekz.bean;

import java.math.BigDecimal;

public class Catering {
    private Integer cateringId;

    private String cateringName;

    private BigDecimal cateringPrice;

    private String cateringIntroduction;

    private String cateringImage;

    private Integer isValid;

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }


    public Integer getCateringId() {
        return cateringId;
    }

    public void setCateringId(Integer cateringId) {
        this.cateringId = cateringId;
    }

    public String getCateringName() {
        return cateringName;
    }

    public void setCateringName(String cateringName) {
        this.cateringName = cateringName == null ? null : cateringName.trim();
    }

    public BigDecimal getCateringPrice() {
        return cateringPrice;
    }

    public void setCateringPrice(BigDecimal cateringPrice) {
        this.cateringPrice = cateringPrice;
    }

    public String getCateringIntroduction() {
        return cateringIntroduction;
    }

    public void setCateringIntroduction(String cateringIntroduction) {
        this.cateringIntroduction = cateringIntroduction == null ? null : cateringIntroduction.trim();
    }

    public String getCateringImage() {
        return cateringImage;
    }

    public void setCateringImage(String cateringImage) {
        this.cateringImage = cateringImage == null ? null : cateringImage.trim();
    }
}