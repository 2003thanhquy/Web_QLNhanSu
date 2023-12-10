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













}
