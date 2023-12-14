package com.qlns.service.impl;

import com.qlns.dao.ChiNhanhDao;
import com.qlns.dao.PhongbanDao;
import com.qlns.dao.impl.ChiNhanhDaoImpl;
import com.qlns.dao.impl.PhongbanDaoImpl;
import com.qlns.model.ChiNhanh;
import com.qlns.model.PhongBan;
import com.qlns.service.CoCauCongTyService;

import java.util.List;

public class CoCauCongTyServiceImpl implements CoCauCongTyService {
    ChiNhanhDao cnDao = new ChiNhanhDaoImpl();
    PhongbanDao pbdao  = new PhongbanDaoImpl();

    @Override
    public List<ChiNhanh> getCN() {
        return cnDao.danhsachchinhanh();
    }

    @Override
    public List<PhongBan> getPBCha(String macn) {
        return pbdao.getPBCha(macn);
    }

    @Override
    public List<PhongBan> getPBCon(String mapbcha) {
        return pbdao.getPBCon(mapbcha);
    }
}
