package com.qlns.dao.impl;

import com.qlns.connection.DBConnection;
import com.qlns.dao.LoginDao;
import com.qlns.model.TaiKhoan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDaoImpl implements LoginDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;


    @Override
    public TaiKhoan getAccount(String userName) {
        String sql = "SELECT * FROM  TaiKhoan WHERE status = 1 and username = ?";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,userName);
            rs= ps.executeQuery();
            while(rs.next()){
                TaiKhoan tk = new TaiKhoan();
                tk.setUserID(rs.getInt("UserID"));
                tk.setUserName(rs.getString("UserName"));
                tk.setMaNV(rs.getString("MaNV"));
                tk.setPassword(rs.getString("Password"));
                tk.setUserRole(rs.getString("UserRole"));
                return tk;
            }


        }catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }
}
