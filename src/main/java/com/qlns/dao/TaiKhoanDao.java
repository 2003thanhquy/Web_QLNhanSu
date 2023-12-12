package com.qlns.dao;

import com.qlns.model.TaiKhoan;

import java.util.List;

public interface TaiKhoanDao {
    List<TaiKhoan> getTaiKhoan(String role, String manv);
    boolean capNhatTaiKhoan(TaiKhoan tk, String mkmoi);

}

