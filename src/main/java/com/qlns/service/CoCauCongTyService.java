package com.qlns.service;

import com.qlns.dao.ChiNhanhDao;
import com.qlns.dao.PhongbanDao;
import com.qlns.dao.impl.ChiNhanhDaoImpl;
import com.qlns.dao.impl.PhongbanDaoImpl;
import com.qlns.model.ChiNhanh;
import com.qlns.model.PhongBan;

import java.util.List;

public interface CoCauCongTyService {

    List<ChiNhanh> getCN();
    List<PhongBan>  getPBCha(String macn);
    List<PhongBan> getPBCon(String mapbcha);
}
