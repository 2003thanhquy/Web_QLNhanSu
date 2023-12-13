package com.qlns.service.impl;

import com.qlns.dao.KThuongKLuatDao;
import com.qlns.dao.UserDao;
import com.qlns.dao.impl.KThuongKLuatDaoImpl;
import com.qlns.dao.impl.UserDaoImpl;
import com.qlns.model.*;
import com.qlns.service.UserService;

import java.util.List;

public class UserServiceImp implements  UserService {

    UserDao userDao = new UserDaoImpl();
    KThuongKLuatDao ktkl = new KThuongKLuatDaoImpl();
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
    public Boolean UpdateNV(NhanVien nv) {
        return userDao.UpdateNV(nv);
    }

    @Override
    public List<KThuongKLuc> getKThuongKLuat() {
        return ktkl.getKThuongKLuat();
    }

    @Override
    public List<KThuongKLuc> getKThuongKLuat(String manv) {
        return ktkl.getKThuongKLuat(manv);
    }

    @Override
    public boolean capnhatnhanvientruockhilenchuc(String manv, String mapb,int bacluong,int chucvu) {
        return userDao.capnhatnhanvientruockhilenchuc(manv,mapb,bacluong,chucvu);
    }
    @Override
    public boolean xoaNV(String manv) {
        return userDao.XoaNV(manv);
    }

    public List<Thongtinnhanvien> laydanhsachtotruong(String MaToTruong){
        return userDao.laydanhsachtotruong(MaToTruong);
    }
    @Override
    public List<KThuongKLuc> getKThuongKLuatgiamdoc(String MaGD) {
        return ktkl.getKThuongKLuatgiamdoc(MaGD);
    }

    @Override
    public List<KThuongKLuc> getKThuongKLuattruongphong(String MaTruongPhong) {
        return ktkl.getKThuongKLuattruongphong(MaTruongPhong);
    }

    @Override
    public List<KThuongKLuc> getKThuongKLuattotruong(String MaToTruong) {
        return ktkl.getKThuongKLuattotruong(MaToTruong);
    }

}
