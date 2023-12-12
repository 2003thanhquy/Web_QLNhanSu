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
            case "user":
                list = this.getTaiKhoan_OneUser(role,manv);
                break;
            case "nhanvien":
                list = this.getTaiKhoan_OneUser(role,manv);
                break;
            case "totruong":
                list = this.getTaiKhoan_OneUser(role,manv);
                break;
            case "giamdoc":
                list = this.getTaiKhoan_GiamDoc(role,manv);
                break;
            case "truongphong":
                list = this.getTaiKhoan_TruongPhong(role,manv);
                break;
            case "admin":
                list = this.getTaiKhoan_admin(role, manv);
                break;
            default:
                list = this.getTaiKhoan_admin(role, manv);
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
    @Override
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
    @Override
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
    @Override
    public List<TaiKhoan> getTaiKhoan_TruongPhong(String role, String manv) {
        List<TaiKhoan> list = new ArrayList<>();
        String sql = "SELECT tk.*\n" +
                "FROM taikhoan tk INNER JOIN  \n" +
                "\t\t\t\t(SELECT *\n" +
                "                FROM (\n" +
                "\t\t\t\tSELECT nv.*\n" +
                "                FROM ThongTinNhanVien nv\n" +
                "                INNER JOIN phongban pb ON nv.MaPB = pb.MaPB OR pb.MaPBCha = nv.MaPB\n" +
                "                WHERE pb.MaQuanLy =? \n" +
                "                UNION\n" +
                "                SELECT nv.*\n" +
                "                FROM ThongTinNhanVien nv\n" +
                "                INNER JOIN QuanLyNhanSu.phongban pb ON nv.MaPB = pb.MaPB\n" +
                "                INNER JOIN QuanLyNhanSu.phongban pbcha ON pbcha.MaPB = pb.MaPBCha\n" +
                "                WHERE pbcha.MaQuanLy = ? AND pb.status = 1\n" +
                "                )as nv\n" +
                "                ORDER BY nv.MaNV) ss\n" +
                "\t\t\twhere tk.MaNV = ss.MaNV";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,manv);
            ps.setString(2,manv);
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
    public List<TaiKhoan> getTaiKhoan_GiamDoc(String role, String manv) {
        List<TaiKhoan> list = new ArrayList<>();
        String sql = "SELECT * \n" +
                "  FROM taikhoan tk INNER JOIN (SELECT nv.*\n" +
                "\tFROM ThongTinNhanVien nv\n" +
                "\tINNER JOIN chinhanh cn ON nv.MaCN = cn.MaCN\n" +
                "\tWHERE cn.MaGiamDoc = ? ) nnv\n" +
                "WHERE tk.MaNV = nnv.MaNV and tk.status = 1";
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
}
