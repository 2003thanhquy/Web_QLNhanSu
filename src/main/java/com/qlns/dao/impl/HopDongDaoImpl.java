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
        String sql = "SELECT * FROM HopDong WHERE Status=1";

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
    public List<HopDong> findhopdongtheogiamdoc(String MaGiamDoc) {
        String sql = " SELECT hd.*\n" +
                "                FROM ThongTinNhanVien nv\n" +
                "                INNER JOIN chinhanh cn ON nv.MaCN = cn.MaCN\n" +
                "                INNER JOIN hopdong hd ON nv.MaNV = hd.MaNV\n" +
                "                WHERE cn.MaGiamDoc = ? and hd.status =1";

        try {
            conn = new DBConnection().getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,MaGiamDoc);
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
    public List<HopDong> findhopdongtheotruongphong(String MaTruongPhong) {
        String sql = " SELECT hd.*\n" +
                "                FROM ThongTinNhanVien nv \n" +
                "                INNER JOIN phongban pb ON nv.MaPB = pb.MaPB \n" +
                "                INNER JOIN hopdong hd ON nv.MaNV = hd.MaNV \n" +
                "                INNER JOIN phongban pbcha ON pb.MaPBCha = pbcha.MaPB \n" +
                "                WHERE pbcha.MaQuanLy = ? and hd.status =1\n" +
                "union \n" +
                "SELECT hd.* \n" +
                "                FROM ThongTinNhanVien nv\n" +
                "                INNER JOIN phongban pb ON nv.MaPB = pb.MaPB\n" +
                "                INNER JOIN hopdong hd ON nv.MaNV = hd.MaNV\n" +
                "                WHERE pb.MaQuanLy = ? and hd.status =1";

        try {
            conn = new DBConnection().getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,MaTruongPhong);
            preparedStatement.setString(2,MaTruongPhong);
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
    public List<HopDong> findhopdongtheototruong(String MaToTruong) {
        String sql = " SELECT hd.* \n" +
                "                FROM ThongTinNhanVien nv\n" +
                "                INNER JOIN phongban pb ON nv.MaPB = pb.MaPB\n" +
                "                INNER JOIN hopdong hd ON nv.MaNV = hd.MaNV\n" +
                "                WHERE pb.MaQuanLy = ? and hd.status=1";

        try {
            conn = new DBConnection().getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,MaToTruong);
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
    public int updateByMaHopDong(String maHopDong, HopDong hopDong) {
        String sql = "UPDATE HopDong SET MaHopDong=?, MaNV=?, NgayBD=?, NgayKT=?, NoiDung=?  WHERE MaHopDong = ?";

        try {
            conn = new DBConnection().getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, hopDong.getMaHopDong());
            preparedStatement.setString(2, hopDong.getMaNV());
            preparedStatement.setDate(3, Date.valueOf(hopDong.getNgayBD()));
            preparedStatement.setDate(4, Date.valueOf(hopDong.getNgayKT()));
            preparedStatement.setString(5, hopDong.getNoidung());
            preparedStatement.setString(6, maHopDong);

            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteByMaHopDong(String maHopDong) {
        String sql = "UPDATE HopDong SET Status=0 WHERE MaHopDong = ?";

        try {
            conn = new DBConnection().getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, maHopDong);
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteByMaNhanVien(String maNhanVien) {
        return 0;
    }
}