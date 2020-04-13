package com.xzsd.app.customer.order.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class EvaluateImg implements Serializable {
    private String evaImgCode;
    private String evaluateCode;
    private String imgUrl;
    private int sort;
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

    public String getEvaImgCode() {
        return evaImgCode;
    }

    public void setEvaImgCode(String evaImgCode) {
        this.evaImgCode = evaImgCode;
    }

    public String getEvaluateCode() {
        return evaluateCode;
    }

    public void setEvaluateCode(String evaluateCode) {
        this.evaluateCode = evaluateCode;
    }

    public EvaluateImg() {
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
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
