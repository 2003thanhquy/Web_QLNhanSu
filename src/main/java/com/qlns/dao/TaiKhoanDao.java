package com.qlns.dao;

import com.qlns.model.TaiKhoan;

import java.util.List;

public interface TaiKhoanDao {
    List<TaiKhoan> getTaiKhoan();
    TaiKhoan getTaiKhoan(String manv);
    boolean capNhatTaiKhoan(TaiKhoan tk);
    boolean xoaTaiKhoan(int userID);
    boolean themTaiKhoan(TaiKhoan tk);

}

