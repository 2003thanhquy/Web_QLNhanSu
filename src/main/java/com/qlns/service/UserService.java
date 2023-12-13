package com.qlns.service;

import com.qlns.model.*;

import java.util.List;

public interface UserService {

    Thongtinnhanvien laythongtincanhan(String MaNV);
    boolean themnhanvien(NhanVien nv);
    List<Thongtinnhanvien> laydanhsachnhanvienadmin();
    List<Thongtinnhanvien> laydanhsachnhanviengiamdoc(String MaGiamDoc);
    List<Thongtinnhanvien> laydanhsachnhanvientruongphong(String MaTruongPhong);
    Boolean UpdateNV(NhanVien nv);
    List<KThuongKLuc> getKThuongKLuat();
    List<KThuongKLuc> getKThuongKLuat(String manv);
    public List<KThuongKLuc> getKThuongKLuatgiamdoc(String MaGD);
    public List<KThuongKLuc> getKThuongKLuattruongphong(String MaGD);
    public List<KThuongKLuc> getKThuongKLuattotruong(String MaToTruong);
    public boolean capnhatnhanvientruockhilenchuc(String manv, String mapb,int bacluong,int chucvu);
    boolean xoaNV(String manv);

}
