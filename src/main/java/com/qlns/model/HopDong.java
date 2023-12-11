package com.qlns.model;

import java.time.LocalDate;
import java.util.Date;

public class HopDong {
    String maHopDong;
    String maNV;
    LocalDate ngayBD;
    LocalDate ngayKT;
    String noidung;

    public HopDong() {
    }

    public HopDong(String maNV, LocalDate ngayBD, LocalDate ngayKT, String noidung) {
        this.maNV = maNV;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.noidung = noidung;
    }

    public HopDong(String maHopDong, String maNV, LocalDate ngayBD, LocalDate ngayKT, String noidung) {
        this.maHopDong = maHopDong;
        this.maNV = maNV;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.noidung = noidung;
    }

    public String getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(String maHopDong) {
        this.maHopDong = maHopDong;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public LocalDate getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(LocalDate ngayBD) {
        this.ngayBD = ngayBD;
    }

    public LocalDate getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(LocalDate ngayKT) {
        this.ngayKT = ngayKT;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
}
