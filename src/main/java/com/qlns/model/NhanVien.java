package com.qlns.model;

import java.time.LocalDate;
import java.util.Date;

public class NhanVien {
    String maNV;
    String maPB;
    
    int idBacLuong;
    int idChucVu;
    int idTrinhDo;

    String HoTen;
    String CCCD;
    String DiaChi;
    String hinhAnh;
    String sdt;
    LocalDate namSinh;
    String GioiTinh;

    public NhanVien() {
    }

    public NhanVien(String maPB, int idBacLuong, int idChucVu, int idTrinhDo,String HoTen, String CCCD, String diaChi, String hinhAnh, String sdt, LocalDate namSinh, String gioiTinh) {
        this.maPB = maPB;
        this.idBacLuong = idBacLuong;
        this.idChucVu = idChucVu;
        this.idTrinhDo = idTrinhDo;
        this.HoTen = HoTen;
        this.CCCD = CCCD;
        DiaChi = diaChi;
        this.hinhAnh = hinhAnh;
        this.sdt = sdt;
        this.namSinh = namSinh;
        GioiTinh = gioiTinh;
    }

    public NhanVien(String maNV, String maPB, int idBacLuong, int idChucVu,  int idTrinhDo,String HoTen, String CCCD, String diaChi, String hinhAnh, String sdt, LocalDate namSinh, String gioiTinh) {
        this.maNV = maNV;
        this.maPB = maPB;
        this.idBacLuong = idBacLuong;
        this.idChucVu = idChucVu;
        this.idTrinhDo = idTrinhDo;
        this.HoTen = HoTen;
        this.CCCD = CCCD;
        DiaChi = diaChi;
        this.hinhAnh = hinhAnh;
        this.sdt = sdt;
        this.namSinh = namSinh;
        GioiTinh = gioiTinh;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaPB() {
        return maPB;
    }

    public void setMaPB(String maPB) {
        this.maPB = maPB;
    }

    public int getIdBacLuong() {
        return idBacLuong;
    }

    public void setIdBacLuong(int idBacLuong) {
        this.idBacLuong = idBacLuong;
    }

    public int getIdChucVu() {
        return idChucVu;
    }

    public void setIdChucVu(int idChucVu) {
        this.idChucVu = idChucVu;
    }


    public int getIdTrinhDo() {
        return idTrinhDo;
    }

    public void setIdTrinhDo(int idTrinhDo) {
        this.idTrinhDo = idTrinhDo;
    }
    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        this.HoTen = hoTen;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public LocalDate getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(LocalDate namSinh) {
        this.namSinh = namSinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }
}
