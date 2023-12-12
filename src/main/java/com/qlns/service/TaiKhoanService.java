package com.qlns.service;

import com.qlns.model.TaiKhoan;

import java.util.List;

public interface TaiKhoanService {
    List<TaiKhoan> getTaiKhoan();
    TaiKhoan getTaiKhoan(String mv);
    boolean capNhatTaiKhoan(TaiKhoan tk);
    boolean themTaiKhoan(TaiKhoan tk);
    boolean xoaTaiKhoan(int userID);
}
