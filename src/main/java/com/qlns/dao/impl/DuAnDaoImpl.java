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


    public List<DuAn> DuAnNhanVienthamgia(String MaNV)
    {
        String sql = "\n" +
                "select * from duan\n" +
                "inner join nhanvien_duan on duan.MaDuAn = nhanvien_duan.MaDA\n" +
                "where MaNV = ?";
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
    public int create(DuAn duAn) {
        String sql = "INSERT INTO DuAn(MaDuAn, TenDuAn, TrangThaiLamViec) VALUES (?, ?, ?)";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, duAn.getMaDuAn());
            ps.setString(2, duAn.getTenDuAn());
            ps.setString(3, duAn.getTrangThai());

            return ps.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public int delete(String id) {
        String sql = "UPDATE DuAn SET Status=0 WHERE MaDuAn=?";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            return ps.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public int update(String id, DuAn duAn) {
        String sql = "UPDATE DuAn SET MaDuAN=?, TenDuAn=?, TrangThaiLamViec=? WHERE MaDuAn=?";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, duAn.getMaDuAn());
            ps.setString(2, duAn.getTenDuAn());
            ps.setString(3, duAn.getTrangThai());
            ps.setString(4, id);

            return ps.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public int themNhanVienVaoDuAn(String maDuAn, DANhanVien daNhanVien) {
        String sql = "INSERT INTO nhanvien_duan(MaNV, TrangThaiLamViec, MaDA) VALUES (?, ?, ?)";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, daNhanVien.getMaNV());
            ps.setString(2, daNhanVien.getTrangThaiLamViec());
            ps.setString(3, maDuAn);

            return ps.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public int capnhatNhanVienTrongDuAn(String maDuAn, String maNV, DANhanVien daNhanVien) {
        String sql = "UPDATE nhanvien_duan SET MaNV=?, TrangThaiLamViec=? WHERE MaDA=? AND MaNV=?";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, daNhanVien.getMaNV());
            ps.setString(2, daNhanVien.getTrangThaiLamViec());
            ps.setString(3, maDuAn);
            ps.setString(4, maNV);

            return ps.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public int xoaNhanVienKhoiDuAn(String maDuAn, String maNhanVien) {
        String sql = "UPDATE nhanvien_duan SET Status=0 WHERE MaDA=? AND MaNV=?";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maDuAn);
            ps.setString(2, maNhanVien);

            return ps.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return 0;
    }
}