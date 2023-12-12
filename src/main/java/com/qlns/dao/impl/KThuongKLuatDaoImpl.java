package com.qlns.dao.impl;

import com.qlns.connection.DBConnection;
import com.qlns.dao.KThuongKLuatDao;
import com.qlns.model.ChucVu;
import com.qlns.model.KThuongKLuc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KThuongKLuatDaoImpl implements KThuongKLuatDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;
    @Override
    public List<KThuongKLuc> getKThuongKLuat() {
        String sql = "SELECT * FROM KThuong_KLuc where status = 1";
        List<KThuongKLuc> lstKtkl = new ArrayList<>();
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                KThuongKLuc ktkl = new KThuongKLuc();
                ktkl.setId(rs.getInt("ID"));
                ktkl.setMaNV(rs.getString("MaNV"));
                ktkl.setNoiDung(rs.getString("NoiDung"));
                ktkl.setNgay(rs.getDate("Ngay").toLocalDate());
                ktkl.setSoKT_KL(rs.getString("soKT_KL"));
                ktkl.setLoai(rs.getInt("Loai"));
                lstKtkl.add(ktkl);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return lstKtkl;
    }

    @Override
    public List<KThuongKLuc> getKThuongKLuat(String manv) {
        String sql = "SELECT * FROM KThuong_KLuc where status = 1 and MaNV = ?";
        List<KThuongKLuc> lstKtkl = new ArrayList<>();
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,manv);
            rs = ps.executeQuery();
            while(rs.next()){
                KThuongKLuc ktkl = new KThuongKLuc();
                ktkl.setId(rs.getInt("ID"));
                ktkl.setMaNV(rs.getString("MaNV"));
                ktkl.setNoiDung(rs.getString("NoiDung"));
                ktkl.setNgay(rs.getDate("Ngay").toLocalDate());
                ktkl.setSoKT_KL(rs.getString("soKT_KL"));
                ktkl.setLoai(rs.getInt("Loai"));
                lstKtkl.add(ktkl);
            }


        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return lstKtkl;
    }
}
