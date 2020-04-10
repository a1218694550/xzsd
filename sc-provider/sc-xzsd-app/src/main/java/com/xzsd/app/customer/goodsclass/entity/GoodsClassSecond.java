package com.xzsd.app.customer.goodsclass.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xzsd.app.customer.goodsDetail.entity.GoodsVO;

import java.util.Date;
import java.util.List;

public class GoodsClassSecond {
    /**
     * 二级分类编号
     */
    private String classSecondCode;
    /**
     * 二级分类名
     */
    private String classSecondName;
    /**
     * 父级编号
     */
    private String parentCode;
    /**
     * 备注
     */
    private String comment;
    /**
     * 商品列表
     */
    private List<GoodsVO> goodsList;
    /**
     * 版本号
     */
    private int version;

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

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<GoodsVO> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsVO> goodsList) {
        this.goodsList = goodsList;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
