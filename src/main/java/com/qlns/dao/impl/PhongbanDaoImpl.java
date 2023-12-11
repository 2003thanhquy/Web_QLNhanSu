package com.qlns.dao.impl;

import com.qlns.connection.DBConnection;
import com.qlns.dao.PhongbanDao;
import com.qlns.model.PhongBan;
import com.qlns.model.ThongTinPhongBan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PhongbanDaoImpl implements PhongbanDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public List<ThongTinPhongBan> layhetdanhsachphongban() {
        List<ThongTinPhongBan> list = new ArrayList<>();
        String sql =  "SELECT * FROM  ThongTinPhongBan WHERE status = 1";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                java.sql.Date dateValue = java.sql.Date.valueOf(rs.getDate(7).toLocalDate());
        list.add(new ThongTinPhongBan(rs.getString(1),
                rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), dateValue.toLocalDate(), rs.getString(8),rs.getString(9)));
            }



        }catch (Exception e){
            e.printStackTrace();

        }
        return list;


    }
    public List<ThongTinPhongBan> layhetdanhsachphongbangiamdoc(String MaGiamDoc)
    {
        List<ThongTinPhongBan> list = new ArrayList<>();
        String sql =" select pb.MaPB,pb.MaPBCha,pb.TenPB,TenPBCha,pb.MaCN,MaQuanLy,pb.NgayBD,pb.TenQuanLy,pb.TenChiNhanh from\n" +
                "    QuanLyNhanSu.chinhanh cn inner join QuanLyNhanSu.ThongTinPhongBan pb on cn.MaCN = pb.MaCN\n" +
                "    where MaGiamDoc = ? and pb.status = 1";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,MaGiamDoc);
            rs= ps.executeQuery();
            while(rs.next()){
                java.sql.Date dateValue = java.sql.Date.valueOf(rs.getDate(7).toLocalDate());
                list.add(new ThongTinPhongBan(rs.getString(1),
                        rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), dateValue.toLocalDate(), rs.getString(8),rs.getString(9)));
            }

        }catch (Exception e){
            e.printStackTrace();

        }
        return list;
    }

    @Override
    public List<ThongTinPhongBan> layhetdanhsachphongbantruongphong(String MaTruongPhong) {
        List<ThongTinPhongBan> list = new ArrayList<>();
        String sql= "   select pb.MaPB,pb.MaPBCha,pb.TenPB,pb.TenPBCha,pb.MaCN,pb.MaQuanLy,pb.NgayBD,pb.TenQuanLy,pb.TenChiNhanh from \n" +
                "   QuanLyNhanSu.ThongTinPhongBan pbcha inner join  QuanLyNhanSu.ThongTinPhongBan pb on pbcha.MaPB = pb.MaPBCha\n" +
                "   where pbcha.MaQuanLy=? and pb.status =1";
        try{
            list.add(layhetphongbanthanquanly(MaTruongPhong));
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,MaTruongPhong);
            rs= ps.executeQuery();

            while(rs.next()){
                java.sql.Date dateValue = java.sql.Date.valueOf(rs.getDate(7).toLocalDate());
                list.add(new ThongTinPhongBan(rs.getString(1),
                        rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), dateValue.toLocalDate(), rs.getString(8),rs.getString(9)));
            }

        }catch (Exception e){
            e.printStackTrace();

        }
        return list;
    }
    public  ThongTinPhongBan layhetphongbanthanquanly(String MaToTruong){
        String sql= " select * from ThongTinPhongBan where MaQuanLy = ? and status =1";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,MaToTruong);
            rs= ps.executeQuery();
            while(rs.next()){
                java.sql.Date dateValue = java.sql.Date.valueOf(rs.getDate(7).toLocalDate());

                ThongTinPhongBan pb = new ThongTinPhongBan(rs.getString(1),
                        rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),dateValue.toLocalDate(),rs.getString(8),rs.getString(9));
            return pb;
            }

        }catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public List<ThongTinPhongBan> laydanhsachphongbanchaquyenadmin() {
        List<ThongTinPhongBan> list = new ArrayList<>();
        String sql ="   select pb.MaPB,pb.MaPBCha,pb.TenPB,TenPBCha,pb.MaCN,MaQuanLy,pb.NgayBD,pb.TenQuanLy,pb.TenChiNhanh from\n" +
                "QuanLyNhanSu.chinhanh cn inner join QuanLyNhanSu.ThongTinPhongBan pb \n" +
                "  where  pb.status = 1 and pb.MaPBCha is null";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                java.sql.Date dateValue = java.sql.Date.valueOf(rs.getDate(7).toLocalDate());
                list.add(new ThongTinPhongBan(rs.getString(1),
                        rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), dateValue.toLocalDate(), rs.getString(8),rs.getString(9)));
            }

        }catch (Exception e){
            e.printStackTrace();

        }
        return list;
    }

    @Override
    public List<ThongTinPhongBan> laydanhsachphongbangiamdoc(String MaGiamDoc) {
        List<ThongTinPhongBan> list = new ArrayList<>();
        String sql ="   select pb.MaPB,pb.MaPBCha,pb.TenPB,TenPBCha,pb.MaCN,MaQuanLy,pb.NgayBD,pb.TenQuanLy,pb.TenChiNhanh from\n" +
                "QuanLyNhanSu.chinhanh cn inner join QuanLyNhanSu.ThongTinPhongBan pb \n" +
                "  where MaGiamDoc = ? and pb.status = 1 and pb.MaPBCha is null";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,MaGiamDoc);
            rs= ps.executeQuery();
            while(rs.next()){
                java.sql.Date dateValue = java.sql.Date.valueOf(rs.getDate(7).toLocalDate());
                list.add(new ThongTinPhongBan(rs.getString(1),
                        rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), dateValue.toLocalDate(), rs.getString(8),rs.getString(9)));
            }

        }catch (Exception e){
            e.printStackTrace();

        }
        return list;
    }

    @Override
    public List<ThongTinPhongBan> laydanhsachphongbancontuphongbancha(String MaPBCha) {
        List<ThongTinPhongBan> list = new ArrayList<>();
        String sql= "   select pb.MaPB,pb.MaPBCha,pb.TenPB,pb.TenPBCha,pb.MaCN,pb.MaQuanLy,pb.NgayBD,pb.TenQuanLy,pb.TenChiNhanh from \n" +
                "                  QuanLyNhanSu.ThongTinPhongBan pbcha inner join  QuanLyNhanSu.ThongTinPhongBan pb on pbcha.MaPB = pb.MaPBCha\n" +
                "                   where pbcha.MaPB=? and pb.status =1";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,MaPBCha);
            rs= ps.executeQuery();

            while(rs.next()){
                java.sql.Date dateValue = java.sql.Date.valueOf(rs.getDate(7).toLocalDate());
                list.add(new ThongTinPhongBan(rs.getString(1),
                        rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), dateValue.toLocalDate(), rs.getString(8),rs.getString(9)));
            }

        }catch (Exception e){
            e.printStackTrace();

        }
        return list;
    }

    @Override
    public List<ThongTinPhongBan> laydanhsachphongbanchuacapnhatquanly() {
        List<ThongTinPhongBan> list = new ArrayList<>();
        String sql =  "SELECT * FROM  ThongTinPhongBan WHERE status = 1 and ThongTinPhongBan.MaQuanLy is null";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                java.sql.Date dateValue = java.sql.Date.valueOf(rs.getDate(7).toLocalDate());
                list.add(new ThongTinPhongBan(rs.getString(1),
                        rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), dateValue.toLocalDate(), rs.getString(8),rs.getString(9)));
            }


        }catch (Exception e){
            e.printStackTrace();

        }
        return list;

    }


    public void themphongban(PhongBan pb) {
        String sql = "INSERT INTO `QuanLyNhanSu`.`phongban` (`MaPB`, `MaPBCha`, `TenPB`, `TenPBCha`, `MaCN`, `MaQuanLy`, `NgayBD`) "
                + "VALUES (null, ? , ?, ?, ?, ?, ?)";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, pb.getMaPBCha());
            ps.setString(2, pb.getTenPB());
            ps.setString(3, pb.getTenPBCha());
            ps.setString(4, pb.getMaCN());
            ps.setString(5, pb.getMaQuanLy());
            ps.setDate(6, java.sql.Date.valueOf(pb.getNgayBD()));
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Thêm phòng ban thành công.");
            } else {
                System.out.println("Thêm phòng ban thất bại.");
            }
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    @Override
    public List<PhongBan> getPhongBan() {
        List<PhongBan> lstPhongBan = new ArrayList<>();
        String sql = "SELECT * FROM PhongBan where status = 1";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                PhongBan pb  = new PhongBan();
                pb.setMaPB(rs.getString("MaPB"));
                pb.setTenPB(rs.getString("TenPB"));
                pb.setMaCN(rs.getString("MaCN"));
                pb.setMaPBCha(rs.getString("MaPBCha"));
                pb.setTenPBCha(rs.getString("TenPBCha"));
                pb.setMaQuanLy(rs.getString("MaQuanLy"));
                pb.setNgayBD(rs.getDate("NgayBD").toLocalDate());
                lstPhongBan.add(pb);

            }
        }catch (Exception e){
            e.printStackTrace();

        }
        return lstPhongBan;
    }

    @Override
    public void capnhatphongban(PhongBan pb) {
        String sql = "UPDATE `QuanLyNhanSu`.`phongban` SET `MaPBCha` = ?, `TenPB` = ?,`TenPBCha` = ?, `MaCN` = ?, `MaQuanLy` = ?, `NgayBD` = ? WHERE `MaPB` = ?";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, pb.getMaPBCha());
            ps.setString(2, pb.getTenPB());
            ps.setString(3, pb.getTenPBCha());
            ps.setString(4, pb.getMaCN());
            ps.setString(5, pb.getMaQuanLy());
            ps.setDate(6, java.sql.Date.valueOf(pb.getNgayBD()));
            ps.setString(7, pb.getMaPB());
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
    public void xoaphongban(String mapb) {
        String sql = "UPDATE `QuanLyNhanSu`.`phongban` SET `status` = 0 WHERE `MaPB` = ?";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,mapb);

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


}
