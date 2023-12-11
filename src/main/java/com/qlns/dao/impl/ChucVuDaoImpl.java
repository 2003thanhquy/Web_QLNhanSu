package com.qlns.dao.impl;

import com.qlns.connection.DBConnection;
import com.qlns.dao.ChucVuDao;
import com.qlns.model.ChucVu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChucVuDaoImpl implements ChucVuDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;
    @Override
    public List<ChucVu> getChucVu() {
        String sql = "SELECT * FROM ChucVu where status = 1";
        List<ChucVu> lstChucVu = new ArrayList<>();
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                ChucVu cv = new ChucVu();
                cv.setIdChucVu(rs.getInt("IDChucVu"));
                cv.setTenChucVu(rs.getString("TenChucVu"));
                lstChucVu.add(cv);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return lstChucVu;
    }
}
