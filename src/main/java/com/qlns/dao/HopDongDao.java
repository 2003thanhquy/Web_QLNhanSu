package com.qlns.dao;

import com.qlns.model.HopDong;

import java.util.List;

public interface HopDongDao {
    int create(HopDong hopDong);
    List<HopDong> findAll();
    HopDong findByMaHopDong(String maHopDong);
    HopDong findByMaNhanVien(String maNhanVien);

    int deleteByMaHopDong(String maHopDong);
    int deleteByMaNhanVien(String maNhanVien);
}
