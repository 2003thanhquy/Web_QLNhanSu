package com.qlns.service.impl;

import com.qlns.dao.UserDao;
import com.qlns.dao.impl.UserDaoImpl;
import com.qlns.model.ChucVu;
import com.qlns.model.NhanVien;
import com.qlns.model.Thongtinnhanvien;
import com.qlns.service.UserService;

import java.util.List;

public class UserServiceImp implements  UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public Thongtinnhanvien laythongtincanhan(String MaNV) {
        return userDao.laythongtincanhan(MaNV);
    }

    @Override
    public void themnhanvien( String maPB,  int idBacLuong, int idChucVu, int idTrinhDo, String HoTen, String CCCD, String diaChi, Byte[] hinhAnh, String sdt, String namSinh, String gioiTinh) {
        userDao.themnhanvien( maPB, idBacLuong, idChucVu, idTrinhDo, HoTen, CCCD, diaChi, hinhAnh, sdt, namSinh, gioiTinh);
    }

    @Override
    public List<Thongtinnhanvien> laydanhsachnhanvienadmin() {
        return userDao.laydanhsachnhanvienadmin();
    }

    @Override
    public List<Thongtinnhanvien> laydanhsachnhanviengiamdoc(String MaGiamDoc) {
        return userDao.laydanhsachnhanviengiamdoc(MaGiamDoc);
    }

    @Override
    public List<Thongtinnhanvien> laydanhsachnhanvientruongphong(String MaTruongPhong) {
        return userDao.laydanhsachnhanvientruongphong(MaTruongPhong);
    }
    public List<Thongtinnhanvien> laydanhsachnhanvientheophongban(String MaPB){
        return userDao.laydanhsachnhanvientheophongban(MaPB);
    }


}