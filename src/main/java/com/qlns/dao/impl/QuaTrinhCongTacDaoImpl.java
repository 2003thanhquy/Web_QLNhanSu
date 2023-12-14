package com.qlns.dao.impl;

import com.qlns.connection.DBConnection;
import com.qlns.dao.QuaTrinhCongTacDao;
import com.qlns.model.ThongTinPhongBan;
import com.qlns.model.ThongTinQuaTrinhCongTac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuaTrinhCongTacDaoImpl implements QuaTrinhCongTacDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public List<ThongTinQuaTrinhCongTac> Layquatrinhcongtacbanthan(String MaNV) {

        List<ThongTinQuaTrinhCongTac> list = new ArrayList<>();
        String sql= "SELECT * FROM QuanLyNhanSu.thongtinquatrinhcongtac\n" +
                "where thongtinquatrinhcongtac.MaNV = ?";
        try{

            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,MaNV);
            rs= ps.executeQuery();

            while(rs.next()){
                java.sql.Date dateValue = java.sql.Date.valueOf(rs.getDate(4).toLocalDate());
                list.add(new ThongTinQuaTrinhCongTac(rs.getString(1),
                        rs.getString(2),rs.getString(3),dateValue.toLocalDate(),rs.getInt(5),rs.getString(7)));
            }

        }catch (Exception e){
            e.printStackTrace();

        }
        return list;
    }

    @Override
    public List<ThongTinQuaTrinhCongTac> layquatrinhcongtacadmin() {
        return null;
    }

    @Override
    public List<ThongTinQuaTrinhCongTac> layquatrinhcongtacgiamdoc() {
        return null;
    }

    @Override
    public List<ThongTinQuaTrinhCongTac> layquatrinhcongtactruongphong() {
        return null;
    }

    @Override
    public List<ThongTinQuaTrinhCongTac> layquatrinhcongtactotruong() {
        return null;
    }
}
