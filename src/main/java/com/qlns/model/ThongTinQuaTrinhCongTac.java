package com.qlns.model;

import java.time.LocalDate;

public class ThongTinQuaTrinhCongTac {
    String MaCT;
    String MaNV;
    String NoiDung;

    LocalDate NgayBD;

    int IDChucVu;
    String TenChucVU;

    public ThongTinQuaTrinhCongTac() {
    }

    public ThongTinQuaTrinhCongTac(String maCT, String maNV, String noiDung, LocalDate ngayBD, int IDChucVu, String tenChucVU) {
        MaCT = maCT;
        MaNV = maNV;
        NoiDung = noiDung;
        NgayBD = ngayBD;
        this.IDChucVu = IDChucVu;
        TenChucVU = tenChucVU;
    }

    public String getMaCT() {
        return MaCT;
    }

    public void setMaCT(String maCT) {
        MaCT = maCT;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public LocalDate getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(LocalDate ngayBD) {
        NgayBD = ngayBD;
    }

    public int getIDChucVu() {
        return IDChucVu;
    }

    public void setIDChucVu(int IDChucVu) {
        this.IDChucVu = IDChucVu;
    }

    public String getTenChucVU() {
        return TenChucVU;
    }

    public void setTenChucVU(String tenChucVU) {
        TenChucVU = tenChucVU;
    }
}
