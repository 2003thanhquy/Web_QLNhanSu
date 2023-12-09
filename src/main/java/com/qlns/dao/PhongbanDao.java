package com.qlns.dao;

import com.qlns.model.PhongBan;
import com.qlns.model.ThongTinPhongBan;

import java.util.List;

public interface PhongbanDao {
    List<ThongTinPhongBan> layhetdanhsachphongban();
    List<ThongTinPhongBan> laydanhsachphongbangiamdoc(String MaGiamDoc);

    List<ThongTinPhongBan> laydanhsachphongbantruongphong(String MaTruongPhong);
    ThongTinPhongBan layphongbanthanquanly(String ToTruong);

}
