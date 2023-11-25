package com.qlns.model;

public class ChucVu {
    int idChucVu;
    String tenChucVu;
    public ChucVu(){

    }

    public ChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    public ChucVu(int idChucVu, String tenChucVu) {
        this.idChucVu = idChucVu;
        this.tenChucVu = tenChucVu;
    }

    public int getIdChucVu() {
        return idChucVu;
    }

    public void setIdChucVu(int idChucVu) {
        this.idChucVu = idChucVu;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }
}

