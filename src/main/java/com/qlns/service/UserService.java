package com.qlns.service;

import com.qlns.model.ChucVu;
import com.qlns.model.NhanVien;
import com.qlns.model.Thongtinnhanvien;

import java.util.List;

public interface UserService {

    Thongtinnhanvien laythongtincanhan(String MaNV);
    boolean themnhanvien(NhanVien nv);
    List<Thongtinnhanvien> laydanhsachnhanvienadmin();
    List<Thongtinnhanvien> laydanhsachnhanviengiamdoc(String MaGiamDoc);
    List<Thongtinnhanvien> laydanhsachnhanvientruongphong(String MaTruongPhong);

    List<Thongtinnhanvien> laydanhsachnhanvientheophongban(String MaPB);



}
