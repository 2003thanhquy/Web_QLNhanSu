package com.qlns.service.impl;

import com.qlns.dao.PhongbanDao;
import com.qlns.dao.impl.PhongbanDaoImpl;
import com.qlns.model.PhongBan;
import com.qlns.model.ThongTinPhongBan;
import com.qlns.model.Thongtinnhanvien;
import com.qlns.service.PhongbanService;

import java.util.List;

public class PhongbanServiceImp implements PhongbanService {
    PhongbanDao pbDao = new PhongbanDaoImpl();
    public List<ThongTinPhongBan> layhetdanhsachphongban(){
        return pbDao.layhetdanhsachphongban();
    }

    @Override
    public List<ThongTinPhongBan> layhetdanhsachphongbangiamdoc(String MaGiamDoc) {
        return pbDao.layhetdanhsachphongbangiamdoc(MaGiamDoc);
    }

    @Override
    public List<ThongTinPhongBan> layhetdanhsachphongbantruongphong(String MaTruongPhong) {
        return pbDao.layhetdanhsachphongbantruongphong(MaTruongPhong);
    }

    @Override
    public ThongTinPhongBan layhetphongbanthanquanly(String MaToTruong) {
        return pbDao.layhetphongbanthanquanly(MaToTruong);
    }

    @Override
    public List<ThongTinPhongBan> laydanhsachphongbangiamdoc(String MaGiamDoc) {
        return pbDao.laydanhsachphongbangiamdoc(MaGiamDoc);
    }

    @Override
    public List<ThongTinPhongBan> laydanhsachphongbancontuphongbancha(String MaPBCha) {
        return pbDao.laydanhsachphongbancontuphongbancha(MaPBCha);
    }

}