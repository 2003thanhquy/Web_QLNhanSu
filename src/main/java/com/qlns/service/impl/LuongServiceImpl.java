package com.qlns.service.impl;

import com.qlns.dao.LuongDao;
import com.qlns.dao.impl.LuongDaoImpl;
import com.qlns.model.Luong;
import com.qlns.service.LuongSerrvice;

import java.util.List;

public class LuongServiceImpl implements LuongSerrvice {
    LuongDao luongDao = new LuongDaoImpl();
    @Override
    public List<Luong> getLuong() {
        return luongDao.getLuong();
    }
}
