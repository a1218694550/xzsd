package com.xzsd.pc.util;

import java.util.List;

public class CodeList {
    private String updater;
    private List<String> codeList;
    private List<String> repeatHGCodeList;
    private List<String> repeatRCCodeList;
    private String status;

    public CodeList() {
    }

    public CodeList(String updater, List<String> menuCodeList) {
        this.updater = updater;
        this.codeList = menuCodeList;
    }

    public CodeList(String updater, List<String> codeList, String status) {
        this.updater = updater;
        this.codeList = codeList;
        this.status = status;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }

    public List<String> getRepeatHGCodeList() {
        return repeatHGCodeList;
    }

    public void setRepeatHGCodeList(List<String> repeatHGCodeList) {
        this.repeatHGCodeList = repeatHGCodeList;
    }

    public List<String> getRepeatRCCodeList() {
        return repeatRCCodeList;
    }

    public void setRepeatRCCodeList(List<String> repeatRCCodeList) {
        this.repeatRCCodeList = repeatRCCodeList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
