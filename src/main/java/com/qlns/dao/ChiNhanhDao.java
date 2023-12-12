package com.qlns.dao;

import com.qlns.model.ChiNhanh;

import java.util.List;

public interface ChiNhanhDao {
    List<ChiNhanh>  danhsachchinhanh();
    void themchinhanh(ChiNhanh cn);
    void capnhatchinhanh(ChiNhanh cn);
    void xoachinhanh(String macn);
     void capnhatgiamdocchinhanh(String macn);
     ChiNhanh laychinhanhgiamdocquanly(String MaGiamDoc);

}
