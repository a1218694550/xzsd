package com.xzsd.pc.customer.entity;

public class CustomerVo {
    /**
     * 页码
     */
    private int pageNum;
    /**
     * 一页多少数据
     */
    private int pageSize;
    /**
     * 客户编号
     */
    private String cusCode;
    /**
     * 客户姓名
     */
    private String cusName;
    /**
     * 客户账号
     */
    private String cusAccount;
    /**
     * 性别
     */
    private String sex;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 头像
     */
    private String cusImg;
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

    public String getCusCode() {
        return cusCode;
    }

    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusAccount() {
        return cusAccount;
    }

    public void setCusAccount(String cusAccount) {
        this.cusAccount = cusAccount;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getCusImg() {
        return cusImg;
    }

    public void setCusImg(String cusImg) {
        this.cusImg = cusImg;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
