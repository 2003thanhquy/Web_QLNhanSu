package com.qlns.service;

import com.qlns.model.KThuongKLuc;

import java.util.List;

public interface KThuongKyLuatService {
    int ThemChuongTrinh(KThuongKLuc ktkl);
     int CapNhatChuongTrin(KThuongKLuc ktkl);
     int XoaChuongTrinh(KThuongKLuc ktkl);

}
