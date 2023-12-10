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

    void themphongbancha(String tenpb,String MaQuanLy,String MaCN,String NgayBD);

    void themphongbancon(String tenpb,String MaPBCha,String TenPBCha,String MaQuanLy,String MaCN,String NgayBD);

}
