package com.qlns.dao;

import com.qlns.model.ThongTinQuaTrinhCongTac;

import java.util.List;

public interface QuaTrinhCongTacDao {

    List<ThongTinQuaTrinhCongTac> Layquatrinhcongtacbanthan(String MaNV);
    List<ThongTinQuaTrinhCongTac> layquatrinhcongtacadmin();
    List<ThongTinQuaTrinhCongTac> layquatrinhcongtacgiamdoc();
    List<ThongTinQuaTrinhCongTac> layquatrinhcongtactruongphong();
    List<ThongTinQuaTrinhCongTac> layquatrinhcongtactotruong();


}
