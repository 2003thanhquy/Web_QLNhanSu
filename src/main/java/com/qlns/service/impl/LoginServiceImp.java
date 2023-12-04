package com.qlns.service.impl;

import com.qlns.dao.LoginDao;
import com.qlns.dao.impl.LoginDaoImpl;
import com.qlns.model.TaiKhoan;
import com.qlns.service.LoginService;

public class LoginServiceImp  implements LoginService {
    LoginDao loginDao = new LoginDaoImpl();
    @Override
    public TaiKhoan Login(String username, String password) {
        TaiKhoan acc = this.GetAccount(username);
        if(acc!=null && acc.getPassword().equals(password))
            return acc;
        return null;
    }

    @Override
    public TaiKhoan GetAccount(String username) {
        //get userDao
        return loginDao.getAccount(username);
    }

}
