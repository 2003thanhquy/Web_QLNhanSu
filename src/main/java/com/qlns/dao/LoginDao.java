package com.qlns.dao;

import com.qlns.model.TaiKhoan;

public interface LoginDao {
    TaiKhoan getAccount(String userName);
}
