package com.qlns.service;

import com.qlns.model.TaiKhoan;

import java.util.List;

public interface TaiKhoanService {
    List<TaiKhoan> getTaiKhoan(String role, String manv);
    boolean capNhatTaiKhoan(TaiKhoan tk, String mkmoi);
}
