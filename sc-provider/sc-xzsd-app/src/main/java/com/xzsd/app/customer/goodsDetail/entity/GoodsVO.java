package com.xzsd.app.customer.goodsDetail.entity;

/**
 * 商品展示类
 * @author zehong
 * @time 2020/4/8
 */
public class GoodsVO {

    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品图片
     */
    private String goodsImg;
    /**
     * 商品名
     */
    private String goodsName;
    /**
     * 商品介绍
     */
    private String goodsIntro;
    /**
     * 商品价格
     */
    private float sellPrice;
    /**
     * 销售量
     */
    private int sumSalesVolume;
    /**
     * 库存
     */
    private int stock;
    /**
     * 送货地
     */
    private String address;
    /**
     * 版本
     */
    private int version;

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsIntro() {
        return goodsIntro;
    }

    public void setGoodsIntro(String goodsIntro) {
        this.goodsIntro = goodsIntro;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getSumSalesVolume() {
        return sumSalesVolume;
    }

    public void setSumSalesVolume(int sumSalesVolume) {
        this.sumSalesVolume = sumSalesVolume;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
