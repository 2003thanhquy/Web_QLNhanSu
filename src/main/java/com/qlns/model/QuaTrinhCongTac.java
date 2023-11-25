package com.qlns.model;

import java.util.Date;

public class QuaTrinhCongTac {
    String maCT;
    String MaNV;
    String DiaDiem;
    Date NgayDB;
    Date NgayKT;
    String congViecCongTac;

    public QuaTrinhCongTac() {
    }

    public QuaTrinhCongTac(String maNV, String diaDiem, Date ngayDB, Date ngayKT, String congViecCongTac) {
        MaNV = maNV;
        DiaDiem = diaDiem;
        NgayDB = ngayDB;
        NgayKT = ngayKT;
        this.congViecCongTac = congViecCongTac;
    }

    public QuaTrinhCongTac(String maCT, String maNV, String diaDiem, Date ngayDB, Date ngayKT, String congViecCongTac) {
        this.maCT = maCT;
        MaNV = maNV;
        DiaDiem = diaDiem;
        NgayDB = ngayDB;
        NgayKT = ngayKT;
        this.congViecCongTac = congViecCongTac;
    }

    public String getMaCT() {
        return maCT;
    }

    public void setMaCT(String maCT) {
        this.maCT = maCT;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }

    public String getDiaDiem() {
        return DiaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        DiaDiem = diaDiem;
    }

    public Date getNgayDB() {
        return NgayDB;
    }

    public void setNgayDB(Date ngayDB) {
        NgayDB = ngayDB;
    }

    public Date getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(Date ngayKT) {
        NgayKT = ngayKT;
    }

    public String getCongViecCongTac() {
        return congViecCongTac;
    }

    public void setCongViecCongTac(String congViecCongTac) {
        this.congViecCongTac = congViecCongTac;
    }
}
