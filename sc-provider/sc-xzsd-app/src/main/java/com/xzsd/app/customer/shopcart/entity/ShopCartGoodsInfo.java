package com.xzsd.app.customer.shopcart.entity;

public class ShopCartGoodsInfo {
    private String userCode;
    private String shopCartCode;
    private String goodsCode;
    private String goodsImg;
    private String goodsName;
    private float sellPrice;
    private int goodsCount;
    private float sumPrice;
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getShopCartCode() {
        return shopCartCode;
    }

    public void setShopCartCode(String shopCartCode) {
        this.shopCartCode = shopCartCode;
    }

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

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public float getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(float sumPrice) {
        this.sumPrice = sumPrice;
    }
}
