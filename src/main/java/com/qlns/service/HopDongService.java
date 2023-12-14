package com.qlns.service;

import com.qlns.model.HopDong;

import java.util.List;
public interface HopDongService {
    int themHopDong(HopDong hopDong);
    List<HopDong> findAll();
    HopDong find();
    int suaHopDong(String id, HopDong hopDong);
    int xoaHopDong(String id);
    List<HopDong> findhopdongtheogiamdoc(String MaGiamDoc);
    List<HopDong> findhopdongtheotruongphong(String MaTruongPhong);
    List<HopDong> findhopdongtheototruong(String MaToTruong);
}