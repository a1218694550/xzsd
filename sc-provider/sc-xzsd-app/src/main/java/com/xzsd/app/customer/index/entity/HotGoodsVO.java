package com.xzsd.app.customer.index.entity;

public class HotGoodsVO {
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
     * 商品图片
     */
    private String goodsImg;
    /**
     * 商品名
     */
    private String goodsName;
    /**
     * 售价
     */
    private float sellPrice;
    /**
     * 商品介绍
     */
    private String goodsIntro;
    /**
     * 销售量
     */
    private int sumSalesVolume;
    /**
     * 版本号
     */
    private int version;

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

    public String getGoodsIntro() {
        return goodsIntro;
    }

    public void setGoodsIntro(String goodsIntro) {
        this.goodsIntro = goodsIntro;
    }

    public int getSumSalesVolume() {
        return sumSalesVolume;
    }

    public void setSumSalesVolume(int sumSalesVolume) {
        this.sumSalesVolume = sumSalesVolume;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
