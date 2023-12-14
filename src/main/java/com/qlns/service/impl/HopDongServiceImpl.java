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
    public int suaHopDong(String id, HopDong hopDong) {
        return hopDongDao.updateByMaHopDong(id, hopDong);
    }

    @Override
    public int xoaHopDong(String id) {
        return hopDongDao.deleteByMaHopDong(id);
    }

    @Override
    public List<HopDong> findhopdongtheogiamdoc(String MaGiamDoc) {
        return hopDongDao.findhopdongtheogiamdoc(MaGiamDoc);
    }

    @Override
    public List<HopDong> findhopdongtheotruongphong(String MaTruongPhong) {
        return hopDongDao.findhopdongtheotruongphong(MaTruongPhong);
    }

    @Override
    public List<HopDong> findhopdongtheototruong(String MaToTruong) {
        return hopDongDao.findhopdongtheototruong(MaToTruong);
    }
}