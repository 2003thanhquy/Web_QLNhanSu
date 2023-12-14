package com.qlns.service;

import com.qlns.model.ThongTinQuaTrinhCongTac;

import java.util.List;

public interface QuaTrinhCongTacService {
    List<ThongTinQuaTrinhCongTac> Layquatrinhcongtacbanthan(String MaNV);
    List<ThongTinQuaTrinhCongTac> layquatrinhcongtacadmin();
    List<ThongTinQuaTrinhCongTac> layquatrinhcongtacgiamdoc();
    List<ThongTinQuaTrinhCongTac> layquatrinhcongtactruongphong();
    List<ThongTinQuaTrinhCongTac> layquatrinhcongtactotruong();
}
