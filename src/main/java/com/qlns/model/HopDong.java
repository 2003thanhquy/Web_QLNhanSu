package com.qlns.model;

import java.util.Date;

public class HopDong {
    String maHopDong;
    String maNV;
    Date ngayBD;
    Date ngayKT;
    String noidung;

    public HopDong() {
    }

    public HopDong(String maNV, Date ngayBD, Date ngayKT, String noidung) {
        this.maNV = maNV;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.noidung = noidung;
    }

    public HopDong(String maHopDong, String maNV, Date ngayBD, Date ngayKT, String noidung) {
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

    public Date getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
}
