package com.qlns.service.impl;

import com.qlns.dao.HopDongDao;
import com.qlns.dao.impl.HopDongDaoImpl;
import com.qlns.model.HopDong;
import com.qlns.service.HopDongService;

import java.util.List;
public class HopDongServiceImpl implements HopDongService {
    HopDongDao hopDongDao = new HopDongDaoImpl();
    @Override
    public int themHopDong(HopDong hopDong) {
        return hopDongDao.create(hopDong);
    }

    @Override
    public List<HopDong> findAll() {
        return hopDongDao.findAll();
    }

    @Override
    public HopDong find() {
        return null;
    }

    @Override
    public int suaHopDong() {
        return 0;
    }

    @Override
    public int xoaHopDong() {
        return 0;
    }
}
