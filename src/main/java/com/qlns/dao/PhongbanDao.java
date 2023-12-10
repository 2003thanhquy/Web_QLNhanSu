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

    void themphongbancha(String tenpb,String MaQuanLy,String MaCN,String NgayBD);

    void themphongbancon(String tenpb,String MaPBCha,String TenPBCha,String MaQuanLy,String MaCN,String NgayBD);















}
