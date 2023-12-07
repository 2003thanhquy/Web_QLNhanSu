package com.qlns.service.impl;

import com.qlns.dao.UserDao;
import com.qlns.dao.impl.UserDaoImpl;
import com.qlns.model.ChucVu;
import com.qlns.model.NhanVien;
import com.qlns.model.Thongtinnhanvien;
import com.qlns.service.UserService;
public class UserServiceImp implements  UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public Thongtinnhanvien laythongtincanhan(String MaNV) {
        return userDao.laythongtincanhan(MaNV);
    }

}
