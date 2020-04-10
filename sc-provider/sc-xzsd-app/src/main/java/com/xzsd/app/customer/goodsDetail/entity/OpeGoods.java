package com.xzsd.app.customer.goodsDetail.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author zehong
 * @time 2020/4/9
 */
public class OpeGoods {
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 购物车编号
     */
    private String shopCartCode;
    /**
     * 商品编号
     */
    private String goodsCode ;
    /**
     * 商品数量
     */
    private int count;
    /**
     * 总价格
     */
    private float sumPrice;
    /**
     * 评价选择 0默认查询全部评价 1查询好评(4-5星) 2查询中评(2-3星) 3查询差评(1星)
     */
    private int evaluate;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(float sumPrice) {
        this.sumPrice = sumPrice;
    }

    public int getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(int evaluate) {
        this.evaluate = evaluate;
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
