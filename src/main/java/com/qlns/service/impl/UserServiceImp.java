package com.qlns.service.impl;

import com.qlns.dao.UserDao;
import com.qlns.dao.impl.UserDaoImpl;
import com.qlns.model.*;
import com.qlns.service.UserService;

import java.util.List;

public class UserServiceImp implements  UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public Thongtinnhanvien laythongtincanhan(String MaNV) {
        return userDao.laythongtincanhan(MaNV);
    }

    @Override
    public boolean themnhanvien(NhanVien nv) {
        return userDao.themnhanvien(nv);
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

    @Override
    public List<PhongBan> getPhongBan() {
        return null;
    }

    @Override
    public List<Luong> getLuong() {
        return null;
    }

    @Override
    public List<ChucVu> getChucVu() {
        return null;
    }

    @Override
    public List<TrinhDo> getTrinHDo() {
        return null;
    }


}
