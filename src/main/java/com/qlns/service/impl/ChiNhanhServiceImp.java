package com.qlns.service.impl;

import com.qlns.dao.ChiNhanhDao;
import com.qlns.dao.PhongbanDao;
import com.qlns.dao.impl.ChiNhanhDaoImpl;
import com.qlns.dao.impl.PhongbanDaoImpl;
import com.qlns.model.ChiNhanh;
import com.qlns.service.ChiNhanhService;

import java.util.List;

public class ChiNhanhServiceImp implements ChiNhanhService {
    ChiNhanhDao cnDao = new ChiNhanhDaoImpl();
    @Override
    public List<ChiNhanh> danhsachchinhanh() {
        return cnDao.danhsachchinhanh();

    }
}
