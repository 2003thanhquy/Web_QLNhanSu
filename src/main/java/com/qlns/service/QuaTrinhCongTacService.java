package com.qlns.service;

import com.qlns.model.ThongTinQuaTrinhCongTac;

import java.util.List;

public interface QuaTrinhCongTacService {
    List<ThongTinQuaTrinhCongTac> Layquatrinhcongtacbanthan(String MaNV);
    List<ThongTinQuaTrinhCongTac> layquatrinhcongtacadmin();
    List<ThongTinQuaTrinhCongTac> layquatrinhcongtacgiamdoc(String MaGiamDoc);
    List<ThongTinQuaTrinhCongTac> layquatrinhcongtactruongphong(String MaTruongPhong);
    List<ThongTinQuaTrinhCongTac> layquatrinhcongtactotruong(String MaToTruong);
}
