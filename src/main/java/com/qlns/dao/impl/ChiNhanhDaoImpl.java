package com.qlns.dao.impl;

import com.qlns.connection.DBConnection;
import com.qlns.dao.ChiNhanhDao;
import com.qlns.model.ChiNhanh;
import com.qlns.model.PhongBan;
import com.qlns.model.ThongTinPhongBan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ChiNhanhDaoImpl implements ChiNhanhDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;
    @Override
    public List<ChiNhanh> danhsachchinhanh() {
        List<ChiNhanh> list = new ArrayList<>();
        String sql= "   select * from chinhanh where status =1";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            rs= ps.executeQuery();

            while(rs.next()){
                java.sql.Date dateValue = java.sql.Date.valueOf(rs.getDate(5).toLocalDate());
               list.add(new ChiNhanh(rs.getString(1),rs.getString(2),
                       rs.getString(3),rs.getString(4),dateValue.toLocalDate()));
            }

        }catch (Exception e){
            e.printStackTrace();

        }
        return list;
    }

    @Override
    public void themchinhanh(ChiNhanh cn) {
        String sql = "INSERT INTO `QuanLyNhanSu`.`chinhanh` (`MaCN`, `MaGiamDoc`, `TenChiNhanh`, `DiaChi`, `NgayBD`) VALUES (null, ?, ?, ?, ?)";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, cn.getMaGiamDoc());
            ps.setString(2, cn.getTenChiNhanh());
            ps.setString(3, cn.getDiaChi());
            ps.setDate(4, java.sql.Date.valueOf(cn.getNgayBD()));
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật phòng ban thành công.");
            } else {
                System.out.println("Cập nhật phòng ban thất bại.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void capnhatchinhanh(ChiNhanh cn) {


        String sql = "UPDATE `QuanLyNhanSu`.`chinhanh` SET `MaGiamDoc` = ?, `TenChiNhanh` = ?, `DiaChi` = ?, `NgayBD` = ? WHERE `MaCN` = ?";
            try {
                conn = new DBConnection().getConnection();
                ps = conn.prepareStatement(sql);
                ps.setString(1, cn.getMaGiamDoc());
                ps.setString(2, cn.getTenChiNhanh());
                ps.setString(3, cn.getDiaChi());
                ps.setDate(4, java.sql.Date.valueOf(cn.getNgayBD()));
                ps.setString(5,cn.getMaCN());
                int rowsUpdated = ps.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Cập nhật phòng ban thành công.");
                } else {
                    System.out.println("Cập nhật phòng ban thất bại.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    @Override
    public void xoachinhanh(String macn) {

    }
}
