package com.xzsd.app.customer.goodsDetail.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OrderDetails {

    /**
     * 订单详情编号
     */
    private String orderDetailsCode;
    private String orderCode;
    /**
     * 商品编号
     */
    private String goodsCode ;
    /**
     * 商品数量
     */
    private int count;
    /**
     * 商品单价
     */
    private float price;

    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDelete;
    /**
     * 创建者
     */
    private String creater;
    /**
     * 创建时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Date createTime;
    /**
     * 更新者
     */
    private String updater;
    /**
     * 更新时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Date updateTime;
    /**
     * 版本号
     */
    private int version;

    public OrderDetails() {
    }

    public OrderDetails(String orderDetailsCode, String goodsCode, int count, float price) {
        this.orderDetailsCode = orderDetailsCode;
        this.goodsCode = goodsCode;
        this.count = count;
        this.price = price;
    }

    public String getOrderDetailsCode() {
        return orderDetailsCode;
    }

    public void setOrderDetailsCode(String orderDetailsCode) {
        this.orderDetailsCode = orderDetailsCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
