package com.qlns.dao;

import com.qlns.model.PhongBan;
import com.qlns.model.ThongTinPhongBan;

import java.util.List;

public interface PhongbanDao {
    List<ThongTinPhongBan> layhetdanhsachphongban();
    List<ThongTinPhongBan> layhetdanhsachphongbangiamdoc(String MaGiamDoc);

    List<ThongTinPhongBan> layhetdanhsachphongbantruongphong(String MaTruongPhong);
    ThongTinPhongBan layhetphongbanthanquanly(String ToTruong);



//xemphongban
    List<ThongTinPhongBan> laydanhsachphongbanchaquyenadmin();
    List<ThongTinPhongBan> laydanhsachphongbangiamdoc(String MaTGiamDoc);

    List<ThongTinPhongBan> laydanhsachphongbancontuphongbancha(String MaPBCha);

    List<ThongTinPhongBan> laydanhsachphongbanchuacapnhatquanly();


     boolean themphongban(PhongBan pb);

    List<PhongBan> getPhongBan();


    void capnhatphongban(PhongBan pb);

    void xoaphongban(String mapb);

    List<ThongTinPhongBan> laydanhsachphongbantheomacn(String MaCN);

    void capnhatphongbankhichuyenchuc(String MaPB);

    void capnhatphongbanchuaquanly(PhongBan phongBan);
















}
