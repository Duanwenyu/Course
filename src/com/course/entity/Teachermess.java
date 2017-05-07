package com.course.entity;

public class Teachermess {
    private String techNo;

    private String techMajor;

    private String techName;

    private String techSex;

    private String techTitle;

    private String techPassword;

    public String getTechNo() {
        return techNo;
    }

    public void setTechNo(String techNo) {
        this.techNo = techNo == null ? null : techNo.trim();
    }

    public String getTechMajor() {
        return techMajor;
    }

    public void setTechMajor(String techMajor) {
        this.techMajor = techMajor == null ? null : techMajor.trim();
    }

    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName == null ? null : techName.trim();
    }

    public String getTechSex() {
        return techSex;
    }

    public void setTechSex(String techSex) {
        this.techSex = techSex == null ? null : techSex.trim();
    }

    public String getTechTitle() {
        return techTitle;
    }

    public void setTechTitle(String techTitle) {
        this.techTitle = techTitle == null ? null : techTitle.trim();
    }

    public String getTechPassword() {
        return techPassword;
    }

    public void setTechPassword(String techPassword) {
        this.techPassword = techPassword == null ? null : techPassword.trim();
    }
}