package com.qlns.dao.impl;

import com.qlns.connection.DBConnection;
import com.qlns.dao.UserDao;
import com.qlns.model.ChucVu;
import com.qlns.model.Luong;
import com.qlns.model.NhanVien;
import com.qlns.model.Thongtinnhanvien;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
                ttnv.setNamSinh(rs.getString("NamSinh"));
                ttnv.setTenChiNhanh(rs.getString("TenChiNhanh"));
                byte[] hinhAnhBytes = rs.getBytes("HinhAnh");


                if (hinhAnhBytes != null) {
                    Byte[] hinhAnh = new Byte[hinhAnhBytes.length];
                    for (int i = 0; i < hinhAnhBytes.length; i++) {
                        hinhAnh[i] = hinhAnhBytes[i];
                    }
                    ttnv.setHinhAnh(hinhAnh);
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

}
