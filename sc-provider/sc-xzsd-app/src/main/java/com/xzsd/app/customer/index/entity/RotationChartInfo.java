package com.xzsd.app.customer.index.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * @author zehong
 */
public class RotationChartInfo {
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

    public String getRotationChartCode() {
        return rotationChartCode;
    }

    public void setRotationChartCode(String rotationChartCode) {
        this.rotationChartCode = rotationChartCode;
    }

    public String getImgUrl() {
        return image;
    }

    public void setImgUrl(String imgUrl) {
        this.image = imgUrl;
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
