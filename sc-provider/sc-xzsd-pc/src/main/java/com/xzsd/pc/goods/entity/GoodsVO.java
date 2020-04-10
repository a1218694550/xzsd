package com.xzsd.pc.goods.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class GoodsVO {
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
     * 书号
     */
    private String bookCode;
    /**
     * 一级分类编号
     */
    private String classOneCode;
    /**
     * 一级分类名
     */
    private String classOneName;
    /**
     * 二级分类编号
     */
    private String classSecondCode;
    /**
     * 二级分类名
     */
    private String classSecondName;
    /**
     * 广告词
     */
    private String advWords;
    /**
     * 商品介绍
     */
    private String goodsIntro;
    /**
     * 商品状态
     */
    private int goodsStatus;
    /**
     * 出版社
     */
    private String press;
    /**
     * 作者
     */
    private String author;
    /**
     * 商家名称
     */
    private String merchant;
    /**
     * 商品成本价
     */
    private float price;
    /**
     * 销售价
     */
    private float sellPrice;
    /**
     * 商品图片
     */
    private String image;
    /**
     * 评价星级
     */
    private float starClass;
    /**
     * 库存
     */
    private int stock;
    /**
     * 上架时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Date shelfTime;
    /**
     * 浏览量
     */
    private int browseVolume;
    /**
     * 销售量
     */
    private int salesVolume;
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

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
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

    public String getAdvWords() {
        return advWords;
    }

    public void setAdvWords(String advWords) {
        this.advWords = advWords;
    }

    public String getGoodsIntro() {
        return goodsIntro;
    }

    public void setGoodsIntro(String goodsIntro) {
        this.goodsIntro = goodsIntro;
    }

    public int getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(int goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getStarClass() {
        return starClass;
    }

    public void setStarClass(float starClass) {
        this.starClass = starClass;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getShelfTime() {
        return shelfTime;
    }

    public void setShelfTime(Date shelfTime) {
        this.shelfTime = shelfTime;
    }

    public int getBrowseVolume() {
        return browseVolume;
    }

    public void setBrowseVolume(int browseVolume) {
        this.browseVolume = browseVolume;
    }

    public int getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(int salesVolume) {
        this.salesVolume = salesVolume;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
