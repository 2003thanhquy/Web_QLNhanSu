package com.qlns.service.impl;

import com.qlns.dao.KThuongKLuatDao;
import com.qlns.dao.impl.KThuongKLuatDaoImpl;
import com.qlns.model.KThuongKLuc;
import com.qlns.service.KThuongKyLuatService;

import java.util.List;

public class KThuongKyLuatServiceImpl implements KThuongKyLuatService {
    KThuongKLuatDao ktkldao = new KThuongKLuatDaoImpl();
    @Override
    public int ThemChuongTrinh(KThuongKLuc ktkl) {
        return ktkldao.ThemChuongTrinh(ktkl);
    }
    public int CapNhatChuongTrin(KThuongKLuc ktkl) {
        return ktkldao.CapNhatChuongTrin(ktkl);
    }
    public int XoaChuongTrinh(KThuongKLuc ktkl) {
        return ktkldao.XoaChuongTrinh(ktkl);
    }


}
