package com.qlns.service;

import com.qlns.model.PhongBan;
import com.qlns.model.ThongTinPhongBan;
import com.qlns.model.Thongtinnhanvien;

import java.util.List;

public interface PhongbanService {
    List<ThongTinPhongBan> layhetdanhsachphongban();

    List<ThongTinPhongBan> layhetdanhsachphongbangiamdoc(String MaGiamDoc);

    List<ThongTinPhongBan> layhetdanhsachphongbantruongphong(String MaTruongPhong);
    ThongTinPhongBan layhetphongbanthanquanly(String ToTruong);
    List<ThongTinPhongBan> laydanhsachphongbangiamdoc(String MaGiamDoc);

    List<ThongTinPhongBan> laydanhsachphongbancontuphongbancha(String MaPBCha);
    List<ThongTinPhongBan> laydanhsachphongbanchaquyenadmin();
    List<ThongTinPhongBan> laydanhsachphongbanchuacapnhatquanly();


    boolean  themphongban(PhongBan pb);

    void capnhatphongban(PhongBan pb);

    void xoaphongban(String mapb);
    List<ThongTinPhongBan> laydanhsachphongbantheomacn(String MaCN);
     void capnhatphongbankhichuyenchuc(String MaPB);
    void capnhatphongbanchuaquanly(PhongBan phongBan);


    List<PhongBan> getPhongBan();
    public List<ThongTinPhongBan> laydanhsachphongbanchatheomacn(String MaCN);

}
