package com.qlns.model;

import java.time.LocalDate;
import java.util.Date;

public class QuaTrinhCongTac {
    String maCT;
    String MaNV;
    String DiaDiem;
    LocalDate NgayDB;
    LocalDate NgayKT;
    String congViecCongTac;

    public QuaTrinhCongTac() {
    }

    public QuaTrinhCongTac(String maNV, String diaDiem, LocalDate ngayDB, LocalDate ngayKT, String congViecCongTac) {
        MaNV = maNV;
        DiaDiem = diaDiem;
        NgayDB = ngayDB;
        NgayKT = ngayKT;
        this.congViecCongTac = congViecCongTac;
    }

    public QuaTrinhCongTac(String maCT, String maNV, String diaDiem, LocalDate ngayDB, LocalDate ngayKT, String congViecCongTac) {
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

    public LocalDate getNgayDB() {
        return NgayDB;
    }

    public void setNgayDB(LocalDate ngayDB) {
        NgayDB = ngayDB;
    }

    public LocalDate getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(LocalDate ngayKT) {
        NgayKT = ngayKT;
    }

    public String getCongViecCongTac() {
        return congViecCongTac;
    }

    public void setCongViecCongTac(String congViecCongTac) {
        this.congViecCongTac = congViecCongTac;
    }
}
