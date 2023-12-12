package com.qlns.service.impl;

import com.qlns.dao.TaiKhoanDao;
import com.qlns.dao.impl.TaiKhoanDaoImpl;
import com.qlns.model.TaiKhoan;
import com.qlns.service.TaiKhoanService;

import java.util.List;

public class TaiKhoanServiceImpl implements TaiKhoanService {
    TaiKhoanDao tkdao = new TaiKhoanDaoImpl();
    @Override
    public List<TaiKhoan> getTaiKhoan() {
        return tkdao.getTaiKhoan();
    }

    @Override
    public TaiKhoan getTaiKhoan(String mv) {
        return tkdao.getTaiKhoan(mv);
    }

    @Override
    public boolean capNhatTaiKhoan(TaiKhoan tk) {
        return tkdao.capNhatTaiKhoan(tk);
    }
    @Override
    public boolean themTaiKhoan(TaiKhoan tk) {
        return tkdao.themTaiKhoan(tk);
    }

    @Override
    public boolean xoaTaiKhoan(int userID) {
        return tkdao.xoaTaiKhoan(userID);
    }
}
