package com.qlns.dao;

import com.qlns.model.*;

import java.util.List;

public interface UserDao {
    Thongtinnhanvien laythongtincanhan(String MaNV);
    boolean themnhanvien(NhanVien nv);

    List<Thongtinnhanvien> laydanhsachnhanvienadmin();
    List<Thongtinnhanvien> laydanhsachnhanviengiamdoc(String MaGiamDoc);
    List<Thongtinnhanvien> laydanhsachnhanvientruongphong(String MaTruongPhong);

    List<Thongtinnhanvien> laydanhsachnhanvientheophongban(String MaPB);
    public boolean capnhatnhanvientruockhilenchuc(String manv, String mapb,int bacluong,int chucvu);

    Boolean UpdateNV(NhanVien nv);

    Boolean XoaNV(String manv);

    public List<Thongtinnhanvien> laydanhsachtotruong(String MaToTruong);
    public List<Thongtinnhanvien> laydanhsachnhanvientheophongbancha(String MaPB);





}
