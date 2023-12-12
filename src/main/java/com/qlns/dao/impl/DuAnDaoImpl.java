package com.qlns.dao.impl;

import com.qlns.connection.DBConnection;
import com.qlns.dao.DuAnDao;
import com.qlns.model.ChucVu;
import com.qlns.model.DANhanVien;
import com.qlns.model.DuAn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DuAnDaoImpl implements DuAnDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;
    @Override
    public List<DuAn> getDuAn() {
        String sql = "SELECT * FROM DuAn where status = 1";
        List<DuAn> lstDA = new ArrayList<>();
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                DuAn da = new DuAn();
                da.setMaDuAn(rs.getString("MaDuAn"));
                da.setTenDuAn(rs.getString("TenDuAN"));
                da.setTrangThai(rs.getString("TrangThaiLamViec"));
                lstDA.add(da);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return lstDA;
    }

    @Override
    public List<DANhanVien> getChiTietDA(String maDA) {
        String sql = "select * from ttduan where maDA = ?";
        List<DANhanVien> lstDA = new ArrayList<>();
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,maDA);
            rs= ps.executeQuery();
            while(rs.next()){
                DANhanVien da = new DANhanVien();
                da.setMaDA(rs.getString("MaDA"));
                da.setMaNV(rs.getString("MaNV"));
                da.setTrangThaiLamViec(rs.getString("TrangThaiLamViec"));
                da.setTenDA(rs.getString("TenDuAn"));
                da.setTrangThai(rs.getString("TrangThai"));
                lstDA.add(da);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return lstDA;
    }

    @Override
    public List<DuAn> getDuAn(String maDA) {
        return null;
    }
}
