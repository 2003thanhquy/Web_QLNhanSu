package com.qlns.model;

import java.time.LocalDate;
import java.util.Date;

public class KThuongKLuc {
    int id;
    String maNV;
    String noiDung;
    LocalDate Ngay;
    String soKT_KL;
    int loai;

    public KThuongKLuc() {

    }

    public KThuongKLuc(String maNV, String noiDung, LocalDate ngay, String soKT_KL, int loai) {
        this.maNV = maNV;
        this.noiDung = noiDung;
        Ngay = ngay;
        this.soKT_KL = soKT_KL;
        this.loai = loai;
    }

    public KThuongKLuc(int id, String maNV, String noiDung, LocalDate ngay, String soKT_KL, int loai) {
        this.id = id;
        this.maNV = maNV;
        this.noiDung = noiDung;
        Ngay = ngay;
        this.soKT_KL = soKT_KL;
        this.loai = loai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public LocalDate getNgay() {
        return Ngay;
    }

    public void setNgay(LocalDate ngay) {
        Ngay = ngay;
    }

    public String getSoKT_KL() {
        return soKT_KL;
    }

    public void setSoKT_KL(String soKT_KL) {
        this.soKT_KL = soKT_KL;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }
}
