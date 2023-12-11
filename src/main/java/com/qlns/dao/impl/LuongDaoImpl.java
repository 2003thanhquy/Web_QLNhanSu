package com.qlns.dao.impl;

import com.qlns.connection.DBConnection;
import com.qlns.dao.LuongDao;
import com.qlns.model.Luong;
import com.qlns.model.PhongBan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LuongDaoImpl implements LuongDao {

    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;
    @Override
    public List<Luong> getLuong() {
        List<Luong> lstLuong = new ArrayList<>();
        String sql = "SELECT * FROM luong where status = 1";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Luong luong = new Luong();
                luong.setIdBacLuong(rs.getInt("IDBacLuong"));
                luong.setLuongCoBan(rs.getBigDecimal("LuongCoban"));
                luong.setHeSoLuong(rs.getFloat("HeSoLuong"));
                luong.setHeSoPC(rs.getFloat("HeSoPC"));
                lstLuong.add(luong);

            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return lstLuong;
    }
}
