package com.xzsd.app.customer.goodsDetail.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class GoodsEvaluateVO {
    /**
     * 评价编号
     */
    private String evaluateCode;
    /**
     * 评价人编号
     */
    private String customerCode;
    /**
     * 评价商品编号
     */
    private String goodsCode;
    /**
     * 评价人
     */
    private String customerName;
    /**
     * 评价星级
     */
    private int evaluateClass;
    /**
     * 评价内容
     */
    private String content;
    /**
     * 评价时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Date time;
    /**
     * 评价图片
     */
    private List<ImageInfo> listImgUrl;

    public String getEvaluateCode() {
        return evaluateCode;
    }

    public void setEvaluateCode(String evaluateCode) {
        this.evaluateCode = evaluateCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getEvaluateClass() {
        return evaluateClass;
    }

    public void setEvaluateClass(int evaluateClass) {
        this.evaluateClass = evaluateClass;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<ImageInfo> getListImgUrl() {
        return listImgUrl;
    }

    public void setListImgUrl(List<ImageInfo> listImgUrl) {
        this.listImgUrl = listImgUrl;
    }
}
