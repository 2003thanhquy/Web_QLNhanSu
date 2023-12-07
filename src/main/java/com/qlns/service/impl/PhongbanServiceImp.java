package com.qlns.service.impl;

import com.qlns.dao.PhongbanDao;
import com.qlns.dao.impl.PhongbanDaoImpl;
import com.qlns.model.PhongBan;
import com.qlns.service.PhongbanService;

import java.util.List;

public class PhongbanServiceImp implements PhongbanService {
    PhongbanDao pbDao = new PhongbanDaoImpl();
    public List<PhongBan> layhetdanhsachphongban(){
        return pbDao.layhetdanhsachphongban();
    }

    @Override
    public List<PhongBan> laydanhsachphongbangiamdoc(String MaGiamDoc) {
        return pbDao.laydanhsachphongbangiamdoc(MaGiamDoc);
    }

    @Override
    public List<PhongBan> laydanhsachphongbantruongphong(String MaTruongPhong) {
        return pbDao.laydanhsachphongbantruongphong(MaTruongPhong);
    }

    @Override
    public PhongBan layphongbanthanquanly(String MaToTruong) {
        return pbDao.layphongbanthanquanly(MaToTruong);
    }
}
