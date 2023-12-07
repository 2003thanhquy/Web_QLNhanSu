package com.qlns.service;

import com.qlns.model.PhongBan;

import java.util.List;

public interface PhongbanService {
    List<PhongBan> layhetdanhsachphongban();

    List<PhongBan> laydanhsachphongbangiamdoc(String MaGiamDoc);

    List<PhongBan> laydanhsachphongbantruongphong(String MaTruongPhong);
    PhongBan layphongbanthanquanly(String ToTruong);
}
