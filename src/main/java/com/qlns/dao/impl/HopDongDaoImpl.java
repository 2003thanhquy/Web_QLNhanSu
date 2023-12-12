package com.qlns.dao.impl;

import com.qlns.connection.DBConnection;
import com.qlns.dao.HopDongDao;
import com.qlns.model.HopDong;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HopDongDaoImpl implements HopDongDao {
    public Connection conn = null;
    public PreparedStatement preparedStatement = null;
    public ResultSet rs = null;

    @Override
    public int create(HopDong hopDong) {
        String sql = "INSERT INTO HopDong(MaHopDong, MaNV, NgayBD, NgayKT, NoiDung) VALUES (?, ?, ?, ?, ?)";

        try {
            conn = new DBConnection().getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, hopDong.getMaHopDong());
            preparedStatement.setString(2, hopDong.getMaNV());
            preparedStatement.setDate(3, Date.valueOf(hopDong.getNgayBD()));
            preparedStatement.setDate(4, Date.valueOf(hopDong.getNgayKT()));
            preparedStatement.setString(5, hopDong.getNoidung());

            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<HopDong> findAll() {
        String sql = "SELECT * FROM HopDong";

        try {
            conn = new DBConnection().getConnection();
            preparedStatement = conn.prepareStatement(sql);
            rs = preparedStatement.executeQuery();

            List<HopDong> lstHopDong = new ArrayList<>();
            while (rs.next()) {
                HopDong hopDong = new HopDong();
                hopDong.setMaHopDong(rs.getString("MaHopDong"));
                hopDong.setMaNV(rs.getString("MaNV"));
                hopDong.setNgayBD(rs.getDate("NgayBD").toLocalDate());
                hopDong.setNgayKT(rs.getDate("NgayKT").toLocalDate());
                hopDong.setNoidung(rs.getString("NoiDung"));

                lstHopDong.add(hopDong);
            }

            return lstHopDong;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public HopDong findByMaHopDong(String maHopDong) {
        return null;
    }

    @Override
    public HopDong findByMaNhanVien(String maNhanVien) {
        return null;
    }

    @Override
    public int deleteByMaHopDong(String maHopDong) {
        return 0;
    }

    @Override
    public int deleteByMaNhanVien(String maNhanVien) {
        return 0;
    }
}
