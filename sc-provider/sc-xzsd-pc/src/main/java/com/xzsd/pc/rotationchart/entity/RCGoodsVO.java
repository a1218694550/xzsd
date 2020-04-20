package com.xzsd.pc.rotationchart.entity;

public class RCGoodsVO {
    /**
     * 页码
     */
    private int pageNum;
    /**
     * 一页多少数据
     */
    private int pageSize;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品名
     */
    private String goodsName;
    /**
     * 商品状态
     */
    private int goodsStatus;
    /**
     * 分类一级编号
     */
    private String classOneCode;
    /**
     * 一级分类名
     */
    private String classOneName;
    /**
     * 分类二级编号
     */
    private String classSecondCode;
    /**
     * 二级分类名
     */
    private String classSecondName;
    /**
     * 版本
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

    public int getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(int goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

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

    public String getClassSecondCode() {
        return classSecondCode;
    }

    public void setClassSecondCode(String classSecondCode) {
        this.classSecondCode = classSecondCode;
    }

    public String getClassSecondName() {
        return classSecondName;
    }

    public void setClassSecondName(String classSecondName) {
        this.classSecondName = classSecondName;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
