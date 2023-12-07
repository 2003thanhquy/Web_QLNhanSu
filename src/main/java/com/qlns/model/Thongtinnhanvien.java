package com.qlns.model;

public class Thongtinnhanvien {

    String maNV;
    String hoTen;
    String namSinh;
    String gioiTinh;
    String cccd;
    String diaChi;
    String tenChiNhanh;
    String tenChucVu;
    String tenPhongBan;
    String soDienThoai;
    int bacLuong;
    String tenTrinhDo;
    Byte[] hinhAnh;


    public Thongtinnhanvien() {
    }

    public Thongtinnhanvien(String hoTen, String namSinh, String gioiTinh, String cccd, String diaChi, String tenChiNhanh, String tenChucVu, String tenPhongBan, String soDienThoai, int bacLuong, String tenTrinhDo,  Byte[] hinhAnh) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.cccd = cccd;
        this.diaChi = diaChi;
        this.tenChiNhanh = tenChiNhanh;
        this.tenChucVu = tenChucVu;
        this.tenPhongBan = tenPhongBan;
        this.soDienThoai = soDienThoai;
        this.bacLuong = bacLuong;
        this.tenTrinhDo = tenTrinhDo;
        this.hinhAnh = hinhAnh;
    }

    public Byte[] getHinhAnh() {
        return hinhAnh;
    }


    public Thongtinnhanvien(String maNV, String hoTen, String namSinh, String gioiTinh, String cccd, String diaChi, String tenChiNhanh, String tenChucVu, String tenPhongBan, String soDienThoai, int bacLuong, String tenTrinhDo, Byte[] hinhAnh) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.cccd = cccd;
        this.diaChi = diaChi;
        this.tenChiNhanh = tenChiNhanh;
        this.tenChucVu = tenChucVu;
        this.tenPhongBan = tenPhongBan;
        this.soDienThoai = soDienThoai;
        this.bacLuong = bacLuong;
        this.tenTrinhDo = tenTrinhDo;
        this.hinhAnh = hinhAnh;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTenChiNhanh() {
        return tenChiNhanh;
    }

    public void setTenChiNhanh(String tenChiNhanh) {
        this.tenChiNhanh = tenChiNhanh;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public int getBacLuong() {
        return bacLuong;
    }

    public void setBacLuong(int bacLuong) {
        this.bacLuong = bacLuong;
    }

    public String getTenTrinhDo() {
        return tenTrinhDo;
    }

    public void setTenTrinhDo(String tenTrinhDo) {
        this.tenTrinhDo = tenTrinhDo;
    }
    public void setHinhAnh(Byte[] hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

}


