package com.xzsd.pc.goodsclass.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class GoodsClassOne {
    /**
     * 一级分类编号
     */
    private String classOneCode;
    /**
     * 一级分类名
     */
    private String classOneName;
    /**
     * 备注
     */
    private String comment;
    /**
     * 二级分类列表
     */
    private List<GoodsClassSecond> ificationSecondList;
    /**
     * 删除标记
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

    public String getClassOneCode() {
        return classOneCode;
    }

    public void setClassOneCode(String classOneCode) {
        this.classOneCode = classOneCode;
    }

    public String getClassOneName() {
        return classOneName;
    }

    public void setClassOneName(String classOneName) {
        this.classOneName = classOneName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<GoodsClassSecond> getIficationSecondList() {
        return ificationSecondList;
    }

    public void setIficationSecondList(List<GoodsClassSecond> ificationSecondList) {
        this.ificationSecondList = ificationSecondList;
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
