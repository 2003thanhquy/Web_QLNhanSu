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
    public List<TaiKhoan> getTaiKhoan(String role, String manv){

        List<TaiKhoan> list = new ArrayList<>();
        String sql ;
        switch (role) {
            case "admin":
                list = this.getTaiKhoan_admin(role, manv);
                break;
            default:
                list = this.getTaiKhoan_OneUser(role, manv);
                break;
        }
        return list;
    }
    @Override
    public boolean capNhatTaiKhoan(TaiKhoan tk, String mkmoi){
        String sql = "UPDATE taikhoan SET Password = ? WHERE UserName = ?";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,mkmoi);
            ps.setString(1,tk.getUserName());
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated >0;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public List<TaiKhoan> getTaiKhoan_OneUser(String role, String manv) {
        List<TaiKhoan> list = new ArrayList<>();
        String sql = "SELECT * FROM taikhoan WHERE MaNV = ? and status =1";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,manv);
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
    public List<TaiKhoan> getTaiKhoan_admin(String role, String manv) {
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
}
