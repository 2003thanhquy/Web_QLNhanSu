package com.qlns.service;

import com.qlns.model.HopDong;

import java.util.List;
public interface HopDongService {
    int themHopDong(HopDong hopDong);
    List<HopDong> findAll();
    HopDong find();
    int suaHopDong();
    int xoaHopDong();
}
