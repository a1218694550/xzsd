package com.xzsd.app.customer.goodsclass.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class GoodsClassOne {
    /**
     * 一级分类编号
     */
    private String classOneCode;
    /**
     * 一级分类名
     */
    private String classOneName;
    /**
     * 备注
     */
    private String comment;
    /**
     * 版本号
     */
    private int version;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
