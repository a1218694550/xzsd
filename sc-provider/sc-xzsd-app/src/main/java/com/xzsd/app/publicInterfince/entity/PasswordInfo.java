package com.xzsd.app.publicInterfince.entity;

public class PasswordInfo {
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 原密码
     */
    private String password;
    /**
     * 新密码
     */
    private String newPassword;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
