package com.qlns.service;

import com.qlns.model.ChucVu;
import com.qlns.model.NhanVien;
import com.qlns.model.Thongtinnhanvien;

import java.util.List;

public interface UserService {

    Thongtinnhanvien laythongtincanhan(String MaNV);
    void themnhanvien(String maNV, String maPB,  int idBacLuong, int idChucVu,  int idTrinhDo,String HoTen, String CCCD, String diaChi, Byte[] hinhAnh, String sdt, String namSinh, String gioiTinh);
    List<Thongtinnhanvien> laydanhsachnhanvienadmin();
    List<Thongtinnhanvien> laydanhsachnhanviengiamdoc(String MaGiamDoc);
    List<Thongtinnhanvien> laydanhsachnhanvientruongphong(String MaTruongPhong);


}
