package com.qlns.dao.impl;

import com.qlns.connection.DBConnection;
import com.qlns.dao.KThuongKLuatDao;
import com.qlns.model.ChucVu;
import com.qlns.model.KThuongKLuc;

import java.sql.*;
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
    @Override
    public int ThemChuongTrinh(KThuongKLuc ktkl) {
        String sql = "INSERT INTO kthuong_kluc(ID, MaNV, NoiDung, Ngay, soKT_KL, Loai) VALUES (?,?,?,?,?,?)";
        try {
            conn = new DBConnection().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, ktkl.getId());

            preparedStatement.setString(2, ktkl.getMaNV());
            preparedStatement.setString(3, ktkl.getNoiDung());
            preparedStatement.setDate(4,Date.valueOf( ktkl.getNgay()));
            preparedStatement.setString(5,ktkl.getSoKT_KL());
            preparedStatement.setInt(6,ktkl.getLoai());
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    @Override
    public int CapNhatChuongTrin(KThuongKLuc ktkl) {
        String sql = "UPDATE kthuong_kluc SET MaNV =?, NoiDung=?, Ngay=?, SoKT_KL=?,Loai=? WHERE ID=? ";
        try {
            conn = new DBConnection().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, ktkl.getMaNV());
            preparedStatement.setString(2, ktkl.getNoiDung());
            preparedStatement.setDate(3,Date.valueOf( ktkl.getNgay()));
            preparedStatement.setString(4,ktkl.getSoKT_KL());
            preparedStatement.setInt(5,ktkl.getLoai());
            preparedStatement.setInt(6,ktkl.getId());
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    @Override
    public int XoaChuongTrinh(KThuongKLuc ktkl) {
        String sql = "UPDATE kthuong_kluc SET Status=0 WHERE ID=? ";
        try {
            conn = new DBConnection().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, ktkl.getId());
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
