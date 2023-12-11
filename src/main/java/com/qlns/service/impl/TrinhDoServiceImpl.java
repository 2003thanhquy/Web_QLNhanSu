package com.qlns.service.impl;

import com.qlns.dao.TrinhDoDao;
import com.qlns.dao.impl.TrinhDoDaoImpl;
import com.qlns.model.TrinhDo;
import com.qlns.service.TrinhDoService;

import java.util.List;

public class TrinhDoServiceImpl implements TrinhDoService {
    TrinhDoDao trinhDoDao = new TrinhDoDaoImpl();
    @Override
    public List<TrinhDo> getTrinhDo() {
        return trinhDoDao.getTrinhDo();
    }
}
