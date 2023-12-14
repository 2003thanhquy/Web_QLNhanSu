package com.qlns.service.impl;

import com.qlns.dao.QuaTrinhCongTacDao;
import com.qlns.dao.impl.QuaTrinhCongTacDaoImpl;
import com.qlns.model.QuaTrinhCongTac;
import com.qlns.model.ThongTinQuaTrinhCongTac;
import com.qlns.service.QuaTrinhCongTacService;

import java.util.List;

public class QuaTrinhCongTacServiceImpl implements QuaTrinhCongTacService {
    QuaTrinhCongTacDao quaTrinhCongTacDao = new QuaTrinhCongTacDaoImpl();
    @Override
    public List<ThongTinQuaTrinhCongTac> Layquatrinhcongtacbanthan(String MaNV) {
        return quaTrinhCongTacDao.Layquatrinhcongtacbanthan(MaNV);
    }

    @Override
    public List<ThongTinQuaTrinhCongTac> layquatrinhcongtacadmin() {
        return null;
    }

    @Override
    public List<ThongTinQuaTrinhCongTac> layquatrinhcongtacgiamdoc() {
        return null;
    }

    @Override
    public List<ThongTinQuaTrinhCongTac> layquatrinhcongtactruongphong() {
        return null;
    }

    @Override
    public List<ThongTinQuaTrinhCongTac> layquatrinhcongtactotruong() {
        return null;
    }
}
