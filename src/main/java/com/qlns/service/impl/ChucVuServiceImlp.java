package com.qlns.service.impl;

import com.qlns.dao.ChucVuDao;
import com.qlns.dao.impl.ChucVuDaoImpl;
import com.qlns.model.ChucVu;
import com.qlns.service.ChucVuService;

import java.util.List;

public class ChucVuServiceImlp implements ChucVuService {
    ChucVuDao chucVuDao = new ChucVuDaoImpl();
    @Override
    public List<ChucVu> getChucVu() {
        return chucVuDao.getChucVu();
    }
}
