package com.qlns.dao;

import com.qlns.model.KThuongKLuc;

import java.util.List;

public interface KThuongKLuatDao {
    List<KThuongKLuc> getKThuongKLuat();
    List<KThuongKLuc> getKThuongKLuat(String manv);
    public int ThemChuongTrinh(KThuongKLuc ktkl);
    public int CapNhatChuongTrin(KThuongKLuc ktkl);
    public int XoaChuongTrinh(KThuongKLuc ktkl);
    public List<KThuongKLuc> getKThuongKLuatgiamdoc(String MaGD);
    public List<KThuongKLuc> getKThuongKLuattruongphong(String MaTruongPhong);
    public List<KThuongKLuc> getKThuongKLuattotruong(String MaToTruong);
}
