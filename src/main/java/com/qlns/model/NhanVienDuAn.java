package com.qlns.model;

public class NhanVienDuAn {
    String maDA;
    String maNV;
    String trangThai;

    public NhanVienDuAn() {
    }

    public NhanVienDuAn(String trangThai) {
        this.trangThai = trangThai;
    }

    public NhanVienDuAn(String maDA, String maNV, String trangThai) {
        this.maDA = maDA;
        this.maNV = maNV;
        this.trangThai = trangThai;
    }

    public String getMaDA() {
        return maDA;
    }

    public void setMaDA(String maDA) {
        this.maDA = maDA;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
