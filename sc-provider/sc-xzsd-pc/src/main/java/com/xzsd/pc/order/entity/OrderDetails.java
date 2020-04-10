package com.xzsd.pc.order.entity;

import java.util.List;

public class OrderDetails {
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 顾客编号
     */
    private String cusCode;
    /**
     * 商品列表
     */
    private List<Goods> goodsList;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCusCode() {
        return cusCode;
    }

    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}
