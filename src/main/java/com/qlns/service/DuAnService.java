package com.qlns.service;

import com.qlns.model.DANhanVien;
import com.qlns.model.DuAn;

import java.util.List;

public interface DuAnService {
    List<DuAn> getDuAn();
    List<DANhanVien> getChiTietDA(String maDA);
}
