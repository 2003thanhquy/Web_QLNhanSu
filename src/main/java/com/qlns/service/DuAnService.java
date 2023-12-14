package com.qlns.service;

import com.qlns.model.DANhanVien;
import com.qlns.model.DuAn;

import java.util.List;

public interface DuAnService {
    List<DuAn> getDuAn();
    List<DANhanVien> getChiTietDA(String maDA);
    List<DuAn> DuAnNhanVienthamgia(String MaNV);
    int themDuAn(DuAn duAn);
    int xoaByMaDuAn(String maDuAn);
    int suaByMaDuAn(String maDuAn, DuAn duAn);
    int themNhanVienVaoDuAn(String maDuAn, DANhanVien daNhanVien);
    int capnhatNhanVienTrongDuAn(String maDuAn, String maNV, DANhanVien daNhanVien);
    int xoaNhanVienKhoiDuAn(String maDuAn, String maNhanVien);

}