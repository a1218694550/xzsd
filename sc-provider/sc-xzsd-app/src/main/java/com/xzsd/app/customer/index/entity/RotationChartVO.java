package com.xzsd.app.customer.index.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class RotationChartVO {
    /**
     * 轮播图编号
     */
    private String rotationChartCode;
    /**
     * 图片路径
     */
    private String image;
    /**
     * 排序序号
     */
    private int sortOrdinal;
    /**
     * 轮播图状态 1：启用 0：禁用
     */
    private int status;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 有效期起
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Date valPeriodStart;
    /**
     * 有效期止
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Date valPeriodOver;
    /**
     * 版本号
     */
    private int version;

    public String getRotationChartCode() {
        return rotationChartCode;
    }

    public void setRotationChartCode(String rotationChartCode) {
        this.rotationChartCode = rotationChartCode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getSortOrdinal() {
        return sortOrdinal;
    }

    public void setSortOrdinal(int sortOrdinal) {
        this.sortOrdinal = sortOrdinal;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public Date getValPeriodStart() {
        return valPeriodStart;
    }

    public void setValPeriodStart(Date valPeriodStart) {
        this.valPeriodStart = valPeriodStart;
    }

    public Date getValPeriodOver() {
        return valPeriodOver;
    }

    public void setValPeriodOver(Date valPeriodOver) {
        this.valPeriodOver = valPeriodOver;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
