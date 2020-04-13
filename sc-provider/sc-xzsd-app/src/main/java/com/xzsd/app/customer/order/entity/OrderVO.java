package com.xzsd.app.customer.order.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OrderVO {
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 顾客编号
     */
    private String cusCode;
    /**
     * 订单总价
     */
    private String sumPrice;
    /**
     * 订单状态 0:已下单 1:待取货  2:已取货 3:已完成未评价 4:已评价 5:取消
     */
    private String orderState;
    /**
     * 支付时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Date payTime;
    /**
     * 门店编码
     */
    private String storeCode;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 版本号
     */
    private int version;

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

    public String getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(String sumPrice) {
        this.sumPrice = sumPrice;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
