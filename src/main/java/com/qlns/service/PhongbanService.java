package com.qlns.service;

import com.qlns.model.PhongBan;
import com.qlns.model.ThongTinPhongBan;

import java.util.List;

public interface PhongbanService {
    List<ThongTinPhongBan> layhetdanhsachphongban();

    List<ThongTinPhongBan> laydanhsachphongbangiamdoc(String MaGiamDoc);

    List<ThongTinPhongBan> laydanhsachphongbantruongphong(String MaTruongPhong);
    ThongTinPhongBan layphongbanthanquanly(String ToTruong);
}
