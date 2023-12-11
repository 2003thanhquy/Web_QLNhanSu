package com.qlns.dao.impl;

import com.qlns.connection.DBConnection;
import com.qlns.dao.UserDao;
import com.qlns.model.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public Thongtinnhanvien laythongtincanhan(String MaNV) {
        String sql = "SELECT * FROM  ThongTinNhanVien WHERE status = 1 and MaNV = ?";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,MaNV);
            rs= ps.executeQuery();
            while(rs.next()){
                Thongtinnhanvien ttnv = new Thongtinnhanvien();
                ttnv.setMaNV(rs.getString("MaNV"));
                ttnv.setTenPhongBan(rs.getString("TenPB"));
                ttnv.setBacLuong(rs.getInt("IDBacLuong"));
                ttnv.setTenChucVu(rs.getString("TenChucVu"));
                ttnv.setTenTrinhDo(rs.getString("TenTrinhDo"));
                ttnv.setHoTen(rs.getString("HoTen"));
                ttnv.setCccd(rs.getString("CCCD"));
                ttnv.setDiaChi(rs.getString("DiaChi"));
                ttnv.setSoDienThoai(rs.getString("SDT"));
                ttnv.setNamSinh(rs.getDate("NamSinh").toLocalDate());
                ttnv.setTenChiNhanh(rs.getString("TenChiNhanh"));
                byte[] hinhAnhBytes = rs.getBytes("HinhAnh");


                if (hinhAnhBytes != null) {
                    Byte[] hinhAnh = new Byte[hinhAnhBytes.length];
                    for (int i = 0; i < hinhAnhBytes.length; i++) {
                        hinhAnh[i] = hinhAnhBytes[i];
                    }
//                    ttnv.setHinhAnh(hinhAnh);
                } else {
                    // Trường HinhAnh có giá trị NULL, xử lý theo ý muốn của bạn
                    ttnv.setHinhAnh(null); // hoặc thực hiện một xử lý khác
                }
                ttnv.setGioiTinh(rs.getString("GioiTinh"));
                return ttnv;
            }


        }catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public boolean themnhanvien( NhanVien nv) {
        String sql = "INSERT INTO nhanvien (MaNV,MaPB, IDBacLuong, IDChucVu, IDTrinhDo, HoTen, CCCD, DiaChi, HinhAnh, SDT, NamSinh, GioiTinh) VALUES (null,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getMaPB());
            ps.setInt(2, nv.getIdBacLuong());
            ps.setInt(3, nv.getIdChucVu());
            ps.setInt(4, nv.getIdTrinhDo());
            ps.setString(5, nv.getHoTen());
            ps.setString(6, nv.getCCCD());
            ps.setString(7, nv.getDiaChi());
            ps.setString(8, nv.getHinhAnh());
            ps.setString(9, nv.getSdt());
            ps.setDate(10, java.sql.Date.valueOf(nv.getNamSinh()));
            ps.setString(11, nv.getGioiTinh());
            int rowsAffected = ps.executeUpdate();

            return rowsAffected>0;
        }catch (Exception e){
            e.printStackTrace();

        }
        return false;
    }

    @Override
    public List<Thongtinnhanvien> laydanhsachnhanvienadmin() {
        List<Thongtinnhanvien> list = new ArrayList<>();
        String sql = "SELECT * FROM  ThongTinNhanVien WHERE status = 1 ";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                list.add(new Thongtinnhanvien(rs.getString(1),rs.getString(2),rs.getDate(3).toLocalDate(),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12),rs.getString(13)));
            }

        }catch (Exception e){
            e.printStackTrace();

        }
        return list;
    }

    @Override
    public List<Thongtinnhanvien> laydanhsachnhanviengiamdoc(String MaGiamDoc) {

        List<Thongtinnhanvien> list = new ArrayList<>();
        String sql = "    \n" +
                "SELECT nv.*\n" +
                "FROM ThongTinNhanVien nv\n" +
                "INNER JOIN chinhanh cn ON nv.MaCN = cn.MaCN\n" +
                "WHERE cn.MaGiamDoc = ? ";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,MaGiamDoc);
            rs= ps.executeQuery();
            while(rs.next()){
                list.add(new Thongtinnhanvien(rs.getString(1),rs.getString(2),rs.getDate(3).toLocalDate(),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12),rs.getString(13)));
            }

        }catch (Exception e){
            e.printStackTrace();

        }
        return list;
    }

    @Override
    public List<Thongtinnhanvien> laydanhsachnhanvientruongphong(String MaTruongPhong) {
        List<Thongtinnhanvien> list = new ArrayList<>();
        String sql = "SELECT *\n" +
                "FROM (\n" +
                "    SELECT nv.*\n" +
                "    FROM ThongTinNhanVien nv\n" +
                "    INNER JOIN phongban pb ON nv.MaPB = pb.MaPB OR pb.MaPBCha = nv.MaPB\n" +
                "    WHERE pb.MaQuanLy = ?\n" +
                "    \n" +
                "    UNION\n" +
                "    \n" +
                "    SELECT nv.*\n" +
                "    FROM ThongTinNhanVien nv\n" +
                "    INNER JOIN QuanLyNhanSu.phongban pb ON nv.MaPB = pb.MaPB\n" +
                "    INNER JOIN QuanLyNhanSu.phongban pbcha ON pbcha.MaPB = pb.MaPBCha\n" +
                "    WHERE pbcha.MaQuanLy = ? AND pb.status = 1\n" +
                ")as nv\n" +
                "ORDER BY nv.MaNV;";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,MaTruongPhong);
            ps.setString(2,MaTruongPhong);
            rs= ps.executeQuery();
            while(rs.next()){
                list.add(new Thongtinnhanvien(rs.getString(1),rs.getString(2),rs.getDate(3).toLocalDate(),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12),rs.getString(13)));
            }

        }catch (Exception e){
            e.printStackTrace();

        }
        return list;
    }

    @Override
    public List<Thongtinnhanvien> laydanhsachnhanvientheophongban(String MaPB) {
        List<Thongtinnhanvien> list = new ArrayList<>();
        String sql = "SELECT nv.* FROM  ThongTinNhanVien nv inner join PhongBan pb on nv.MaPB = pb.MaPB WHERE nv.status = 1 and pb.MaPB = ? ";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,MaPB);
            rs= ps.executeQuery();
            while(rs.next()){
                list.add(new Thongtinnhanvien(rs.getString(1),rs.getString(2),rs.getDate(3).toLocalDate(),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12),rs.getString(13)));
            }

        }catch (Exception e){
            e.printStackTrace();

        }
        return list;
    }



}
