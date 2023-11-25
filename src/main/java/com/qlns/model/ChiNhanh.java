package com.qlns.model;

import java.util.Date;

public class ChiNhanh {
    String maCN;
    String maGiamDoc;
    String tenChiNhanh;
    String diaChi;
    Date NgayBD;
    public ChiNhanh(){

    }
    public ChiNhanh(String maCN, String maGiamDoc, String tenChiNhanh, String diaChi, Date ngayBD) {
        this.maCN = maCN;
        this.maGiamDoc = maGiamDoc;
        this.tenChiNhanh = tenChiNhanh;
        this.diaChi = diaChi;
        NgayBD = ngayBD;
    }

    public ChiNhanh(String maGiamDoc, String tenChiNhanh, String diaChi, Date ngayBD) {
        this.maGiamDoc = maGiamDoc;
        this.tenChiNhanh = tenChiNhanh;
        this.diaChi = diaChi;
        NgayBD = ngayBD;
    }

    public String getMaCN() {
        return maCN;
    }

    public void setMaCN(String maCN) {
        this.maCN = maCN;
    }

    public String getMaGiamDoc() {
        return maGiamDoc;
    }

    public void setMaGiamDoc(String maGiamDoc) {
        this.maGiamDoc = maGiamDoc;
    }

    public String getTenChiNhanh() {
        return tenChiNhanh;
    }

    public void setTenChiNhanh(String tenChiNhanh) {
        this.tenChiNhanh = tenChiNhanh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(Date ngayBD) {
        NgayBD = ngayBD;
    }
}
