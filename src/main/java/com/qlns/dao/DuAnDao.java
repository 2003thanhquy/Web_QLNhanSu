package com.qlns.dao;

import com.qlns.model.DANhanVien;
import com.qlns.model.DuAn;

import java.util.List;

public interface DuAnDao {

    List<DuAn> getDuAn();
    List<DANhanVien> getChiTietDA(String maDA);
    List<DuAn> getDuAn(String maDA);
}
