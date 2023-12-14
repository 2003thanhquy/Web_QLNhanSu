package com.qlns.service.impl;

import com.qlns.dao.DuAnDao;
import com.qlns.dao.impl.DuAnDaoImpl;
import com.qlns.model.DANhanVien;
import com.qlns.model.DuAn;
import com.qlns.service.DuAnService;

import java.util.List;

public class DuAnServiceImpl implements DuAnService {
    DuAnDao daDao = new DuAnDaoImpl();
    @Override
    public List<DuAn> getDuAn() {
        return daDao.getDuAn();
    }

    @Override
    public List<DANhanVien> getChiTietDA(String maDA) {
        return daDao.getChiTietDA(maDA);
    }

    @Override
    public List<DuAn> DuAnNhanVienthamgia(String MaNV) {
        return daDao.DuAnNhanVienthamgia(MaNV);
    }

    @Override
    public int themDuAn(DuAn duAn) {
        return daDao.create(duAn);
    }

    @Override
    public int xoaByMaDuAn(String maDuAn) {
        return daDao.delete(maDuAn);
    }

    @Override
    public int suaByMaDuAn(String maDuAn, DuAn duAn) {
        return daDao.update(maDuAn, duAn);
    }

    @Override
    public int themNhanVienVaoDuAn(String maDuAn, DANhanVien daNhanVien) {
        return daDao.themNhanVienVaoDuAn(maDuAn, daNhanVien);
    }

    @Override
    public int capnhatNhanVienTrongDuAn(String maDuAn, String maNV, DANhanVien daNhanVien) {
        return daDao.capnhatNhanVienTrongDuAn(maDuAn, maNV, daNhanVien);
    }

    @Override
    public int xoaNhanVienKhoiDuAn(String maDuAn, String maNhanVien) {
        return daDao.xoaNhanVienKhoiDuAn(maDuAn, maNhanVien);
    }
}