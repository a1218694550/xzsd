package com.xzsd.app.customer.order.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class EvaluateInfo implements Serializable {
    private String evaluateCode;
    private String orderCode;
    private String goodsCode;
    private int evaluateClass;
    private String content;
    private List<EvaluateImg> imgUrlList;
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

    public EvaluateInfo() {
    }

    public String getEvaluateCode() {
        return evaluateCode;
    }

    public void setEvaluateCode(String evaluateCode) {
        this.evaluateCode = evaluateCode;
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

    public List<EvaluateImg> getImgUrlList() {
        return imgUrlList;
    }

    public void setImgUrlList(List<EvaluateImg> imgUrlList) {
        this.imgUrlList = imgUrlList;
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
