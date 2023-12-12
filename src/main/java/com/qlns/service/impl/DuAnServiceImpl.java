package com.qlns.service.impl;

import com.qlns.dao.DuAnDao;
import com.qlns.dao.impl.DuAnDaoImpl;
import com.qlns.model.DANhanVien;
import com.qlns.model.DuAn;
import com.qlns.service.DuAnService;

import java.util.List;

public class DuAnServiceImpl implements DuAnService {
    DuAnDao daDao = new DuAnDaoImpl();
    @Override
    public List<DuAn> getDuAn() {
        return daDao.getDuAn();
    }

    @Override
    public List<DANhanVien> getChiTietDA(String maDA) {
        return daDao.getChiTietDA(maDA);
    }
}
