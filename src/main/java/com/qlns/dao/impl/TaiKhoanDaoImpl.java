package com.qlns.dao.impl;

import com.qlns.connection.DBConnection;
import com.qlns.dao.TaiKhoanDao;
import com.qlns.model.TaiKhoan;
import com.qlns.model.ThongTinPhongBan;
import com.qlns.model.Thongtinnhanvien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDaoImpl implements TaiKhoanDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;
    @Override
    public boolean capNhatTaiKhoan(TaiKhoan tk){
        String sql = "UPDATE taikhoan SET Password = ? WHERE UserName = ?";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,tk.getPassword());
            ps.setString(2,tk.getUserName());
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated >0;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean xoaTaiKhoan(int userID) {
        String sql = "UPDATE taikhoan SET status = 0 WHERE UserID = ?";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,userID);
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated >0;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean themTaiKhoan(TaiKhoan tk) {

        String sql = "INSERT INTO TaiKhoan (userID, userName, password, userRole, maNV)\n" +
                "VALUES (?, ?,?,?,?)";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,tk.getUserID());
            ps.setString(2,tk.getUserName());
            ps.setString(3,tk.getPassword());
            ps.setString(4,tk.getUserRole());
            ps.setString(5,tk.getMaNV());
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated >0;
        } catch (Exception e){
            e.printStackTrace();
        }


        return false;
    }

    @Override
    public List<TaiKhoan> getTaiKhoan() {
        List<TaiKhoan> list = new ArrayList<>();
        String sql = "SELECT * FROM taikhoan WHERE status =1";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                list.add(new TaiKhoan(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public TaiKhoan getTaiKhoan(String manv) {
        TaiKhoan tk = null;
        String sql = "SELECT * FROM taikhoan WHERE MaNV = ? and status =1";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,manv);
            rs= ps.executeQuery();
            while(rs.next()){
                tk = new TaiKhoan(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return tk;
    }
}
