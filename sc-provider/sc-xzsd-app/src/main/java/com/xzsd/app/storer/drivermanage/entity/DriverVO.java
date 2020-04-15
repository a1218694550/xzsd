package com.xzsd.app.storer.drivermanage.entity;

/**
 * 司机信息
 * @author zehong
 * @time 2020/4/13
 */
public class DriverVO {
    private String driverCode;
    private String driverName;
    private String phone;

    public String getDriverCode() {
        return driverCode;
    }

    public void setDriverCode(String driverCode) {
        this.driverCode = driverCode;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
