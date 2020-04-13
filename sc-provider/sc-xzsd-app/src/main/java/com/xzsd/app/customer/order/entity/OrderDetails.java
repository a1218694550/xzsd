package com.xzsd.app.customer.order.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class OrderDetails {
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 订单总价
     */
    private float orderSumPrice;
    /**
     * 订单状态 0:已下单 1:待取货  2:已取货 3:已完成未评价 4:已评价 5:取消
     */
    private int orderStatus;
    /**
     * 商品种类数量
     */
    private int classCount;
    /**
     * 顾客编号
     */
    private String customerCode;
    /**
     * 顾客名
     */
    private String customerName;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 订单创建时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Date createTime;
    /**
     * 门店名
     */
    private String storeName;
    /**
     * 取货地址(将省市区详细地址拼接而成)
     */
    private String address;
    /**
     * 商品列表
     */
    private List<Goods> goodsList;
    private int version;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public float getOrderSumPrice() {
        return orderSumPrice;
    }

    public void setOrderSumPrice(float orderSumPrice) {
        this.orderSumPrice = orderSumPrice;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getClassCount() {
        return classCount;
    }

    public void setClassCount(int classCount) {
        this.classCount = classCount;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
