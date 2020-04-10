package com.xzsd.app.customer.index.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class HotGoodsInfo {
    private int pageNum;
    private int pageSize;
    /**
     * 热门商品编号
     */
    private String hotGoodsCode;
    /**
     * 排序序号
     */
    private int sortOrdinal;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品名
     */
    private String goodsName;

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

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getHotGoodsCode() {
        return hotGoodsCode;
    }

    public void setHotGoodsCode(String hotGoodsCode) {
        this.hotGoodsCode = hotGoodsCode;
    }

    public int getSortOrdinal() {
        return sortOrdinal;
    }

    public void setSortOrdinal(int sortOrdinal) {
        this.sortOrdinal = sortOrdinal;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
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
