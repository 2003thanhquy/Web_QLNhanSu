package com.qlns.service;

import com.qlns.model.TaiKhoan;

public interface LoginService {
    TaiKhoan Login(String username,String password);
    TaiKhoan GetAccount(String username);
}
