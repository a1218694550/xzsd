package com.xzsd.app.publicInterfince.entity;

public class PersonalInfo {
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 头像
     */
    private String userImg;
    /**
     * 用户角色
     */
    private int role;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邀请码
     */
    private String invCode;
    /**
     * 门店编号
     */
    private String storeCode;
    /**
     * 门店名
     */
    private String storeName;
    /**
     * 门店地址
     */
    private String address;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInvCode() {
        return invCode;
    }

    public void setInvCode(String invCode) {
        this.invCode = invCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
