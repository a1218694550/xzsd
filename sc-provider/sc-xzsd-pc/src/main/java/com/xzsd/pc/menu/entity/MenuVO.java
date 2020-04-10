package com.xzsd.pc.menu.entity;

public class MenuVO {
    /**
     * 菜单编号
     */
    private String menuCode;
    /**
     * 菜单名
     */
    private String name;
    /**
     * 是否菜单 0 不是 1是
     */
    private int isMenu;
    /**
     * 备注
     */
    private String remarks;

    /**
     * 版本号
     */
    private int version;

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(int isMenu) {
        this.isMenu = isMenu;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
