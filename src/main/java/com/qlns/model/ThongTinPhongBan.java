package com.qlns.model;

import java.util.Date;

public class ThongTinPhongBan {
    String maPB;
    String maPBCha;
    String  tenPB;
    String maCN;
    String maQuanLy;
    String tenPBCha;
    Date ngayBD;
    String tenQuanLy;
    String tenChiNhanh;
    public ThongTinPhongBan() {
    }

    public ThongTinPhongBan(String maPB, String maPBCha, String tenPB,String tenPBCha, String maCN, String maQuanLy, Date ngayBD, String tenQuanLy, String tenChiNhanh) {
        this.maPB = maPB;
        this.maPBCha = maPBCha;
        this.tenPB = tenPB;
        this.maCN = maCN;
        this.maQuanLy = maQuanLy;
        this.tenPBCha = tenPBCha;
        this.ngayBD = ngayBD;
        this.tenQuanLy = tenQuanLy;
        this.tenChiNhanh = tenChiNhanh;
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

    public void setTenPBCha(String tenPBCha) {
        this.tenPBCha = tenPBCha;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public String getTenQuanLy() {
        return tenQuanLy;
    }

    public void setTenQuanLy(String tenQuanLy) {
        this.tenQuanLy = tenQuanLy;
    }

    public String getTenChiNhanh() {
        return tenChiNhanh;
    }

    public void setTenChiNhanh(String tenChiNhanh) {
        this.tenChiNhanh = tenChiNhanh;
    }




}
