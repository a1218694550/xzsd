package com.xzsd.pc.order.entity;

public class Goods {
    /**
     * 订单详情编号
     */
    private String ordDetailsCode;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品名
     */
    private String goodsName;
    /**
     * 购买数量
     */
    private int buyCount;
    /**
     * 总价
     */
    private float sumPrice;
    /**
     * 售价
     */
    private float sellPrice;
    public String getOrdDetailsCode() {
        return ordDetailsCode;
    }

    public void setOrdDetailsCode(String ordDetailsCode) {
        this.ordDetailsCode = ordDetailsCode;
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

    public int getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
    }

    public float getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(float sumPrice) {
        this.sumPrice = sumPrice;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }
}
