package com.course.entity;

public class Sysmess {
    private int sysStart;

    private int sysChoosenum;

    private String sysTime;

    private String sysF2;

    private String sysF3;

    public int getSysStart() {
        return sysStart;
    }

    public void setSysStart(int sysStart) {
        this.sysStart = sysStart;
    }

    public int getSysChoosenum() {
        return sysChoosenum;
    }

    public void setSysChoosenum(int sysChoosenum) {
        this.sysChoosenum = sysChoosenum;
    }

    public String getSysTime() {
        return sysTime;
    }

    public void setSysTime(String sysTime) {
        this.sysTime = sysTime == null ? null : sysTime.trim();
    }

    public String getSysF2() {
        return sysF2;
    }

    public void setSysF2(String sysF2) {
        this.sysF2 = sysF2 == null ? null : sysF2.trim();
    }

    public String getSysF3() {
        return sysF3;
    }

    public void setSysF3(String sysF3) {
        this.sysF3 = sysF3 == null ? null : sysF3.trim();
    }
}