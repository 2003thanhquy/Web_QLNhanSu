package com.qlns.model;

import java.time.LocalDate;
import java.util.Date;

public class PhongBan {
    String maPB;
    String maPBCha;
    String  tenPB;
    String maCN;
    String maQuanLy;
    String tenPBCha;
    LocalDate ngayBD;

    public PhongBan() {
    }

    public PhongBan(String maPB, String tenPB, String maCN, String maQuanLy, LocalDate ngayBD) {
        this.maPB = maPB;
        this.tenPB = tenPB;
        this.maCN = maCN;
        this.maQuanLy = maQuanLy;
        this.ngayBD = ngayBD;
    }

    public PhongBan(String maPB, String maPBCha, String tenPB,String tenPBcha, String maCN, String maQuanLy,  LocalDate ngayBD) {
        this.maPB = maPB;
        this.maPBCha = maPBCha;
        this.tenPB = tenPB;
        this.maCN = maCN;
        this.maQuanLy = maQuanLy;
        this.tenPBCha= tenPBcha;
        this.ngayBD = ngayBD;
    }

    public String getMaPB() {
        return maPB;
    }

    public void setMaPB(String maPB) {
        this.maPB = maPB;
    }

    public String getMaPBCha() {
        return maPBCha;
    }

    public void setMaPBCha(String maPBCha) {
        this.maPBCha = maPBCha;
    }

    public String getTenPB() {
        return tenPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }

    public String getMaCN() {
        return maCN;
    }

    public void setMaCN(String maCN) {
        this.maCN = maCN;
    }

    public String getMaQuanLy() {
        return maQuanLy;
    }

    public void setMaQuanLy(String maQuanLy) {
        this.maQuanLy = maQuanLy;
    }

    public String getTenPBCha() {
        return tenPBCha;
    }

    public void setTenPBCha(String tenPhongBan) {
        this.tenPBCha = tenPhongBan;
    }

    public LocalDate getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(LocalDate ngayBD) {
        this.ngayBD = ngayBD;
    }
}
