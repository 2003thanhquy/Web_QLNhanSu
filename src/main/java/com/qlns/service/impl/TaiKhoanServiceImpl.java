package com.qlns.service.impl;

import com.qlns.dao.TaiKhoanDao;
import com.qlns.dao.impl.TaiKhoanDaoImpl;
import com.qlns.model.TaiKhoan;
import com.qlns.service.TaiKhoanService;

import java.util.List;

public class TaiKhoanServiceImpl implements TaiKhoanService {
    TaiKhoanDao tkdao = new TaiKhoanDaoImpl();
    @Override
    public List<TaiKhoan> getTaiKhoan(String role, String manv) {
        return tkdao.getTaiKhoan(role,manv);
    }
    @Override
    public boolean capNhatTaiKhoan(TaiKhoan tk, String mkmoi) {
        return tkdao.capNhatTaiKhoan(tk,mkmoi);
    }
}
