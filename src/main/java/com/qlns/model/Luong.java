package com.qlns.model;

import java.math.BigDecimal;

public class Luong {
    int idBacLuong;
    BigDecimal luongCoBan;
    float heSoLuong;
    float heSoPC;

    public Luong() {
    }

    public Luong(BigDecimal luongCoBan, float heSoLuong, float heSoPC) {
        this.luongCoBan = luongCoBan;
        this.heSoLuong = heSoLuong;
        this.heSoPC = heSoPC;
    }

    public Luong(int idBacLuong, BigDecimal luongCoBan, float heSoLuong, float heSoPC) {
        this.idBacLuong = idBacLuong;
        this.luongCoBan = luongCoBan;
        this.heSoLuong = heSoLuong;
        this.heSoPC = heSoPC;
    }

    public int getIdBacLuong() {
        return idBacLuong;
    }

    public void setIdBacLuong(int idBacLuong) {
        this.idBacLuong = idBacLuong;
    }

    public BigDecimal getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(BigDecimal luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public float getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(float heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public float getHeSoPC() {
        return heSoPC;
    }

    public void setHeSoPC(float heSoPC) {
        this.heSoPC = heSoPC;
    }
}
