package com.qlns.dao;

import com.qlns.model.DANhanVien;
import com.qlns.model.DuAn;

import java.util.List;

public interface DuAnDao {

    List<DuAn> getDuAn();
    List<DANhanVien> getChiTietDA(String maDA);
    List<DuAn> getDuAn(String maDA);
    public List<DuAn> DuAnNhanVienthamgia(String MaNV);
    int create(DuAn duAn);
    int delete(String id);
    int update(String id, DuAn duAn);
    int themNhanVienVaoDuAn(String maDuAn, DANhanVien daNhanVien);
    int capnhatNhanVienTrongDuAn(String maDuAn, String maNV, DANhanVien daNhanVien);
    int xoaNhanVienKhoiDuAn(String maDuAn, String maNhanVien);
}