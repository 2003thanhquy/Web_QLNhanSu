package com.qlns.dao;

import com.qlns.model.ChucVu;
import com.qlns.model.Luong;
import com.qlns.model.NhanVien;
import com.qlns.model.Thongtinnhanvien;

import java.util.List;

public interface UserDao {
    Thongtinnhanvien laythongtincanhan(String MaNV);
    boolean themnhanvien(NhanVien nv);

    List<Thongtinnhanvien> laydanhsachnhanvienadmin();
    List<Thongtinnhanvien> laydanhsachnhanviengiamdoc(String MaGiamDoc);
    List<Thongtinnhanvien> laydanhsachnhanvientruongphong(String MaTruongPhong);

    List<Thongtinnhanvien> laydanhsachnhanvientheophongban(String MaPB);






}
