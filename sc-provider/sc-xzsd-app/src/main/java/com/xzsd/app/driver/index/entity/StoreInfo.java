package com.xzsd.app.driver.index.entity;

public class StoreInfo {
    /**
     * 司机编号
     */
    private String driverCode;
    /**
     * 关键词
     */
    private String keyWord;
    /**
     * 门店编号
     */
    private String storeCode;
    /**
     * 门店名
     */
    private String storeName;
    /**
     * 邀请码
     */
    private String invCode;
    /**
     * 所在地址（将省市区详细地址拼接而成）
     */
    private String address;
    /**
     * 店长名
     */
    private String userName;
    /**
     * 联系方式
     */
    private String phone;

    public String getDriverCode() {
        return driverCode;
    }

    public void setDriverCode(String driverCode) {
        this.driverCode = driverCode;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
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

    public String getInvCode() {
        return invCode;
    }

    public void setInvCode(String invCode) {
        this.invCode = invCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
