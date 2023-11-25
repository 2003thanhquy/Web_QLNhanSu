package com.qlns.model;

public class DuAn {
    String maDuAn;
    String tenDuAn;
    String trangThai;
    public  DuAn(){

    }

    public DuAn(String maDuAn, String tenDuAn, String trangThai) {
        this.maDuAn = maDuAn;
        this.tenDuAn = tenDuAn;
        this.trangThai = trangThai;
    }

    public DuAn(String tenDuAn, String trangThai) {
        this.tenDuAn = tenDuAn;
        this.trangThai = trangThai;
    }

    public String getMaDuAn() {
        return maDuAn;
    }

    public void setMaDuAn(String maDuAn) {
        this.maDuAn = maDuAn;
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
