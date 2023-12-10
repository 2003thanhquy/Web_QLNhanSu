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
        list.add(new ThongTinPhongBan(rs.getString(1),
                rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7), rs.getString(8),rs.getString(9)));
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
                list.add(new ThongTinPhongBan(rs.getString(1),
                        rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7),rs.getString(8), rs.getString(9)));
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
                list.add(new ThongTinPhongBan(rs.getString(1),
                        rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7),rs.getString(8),rs.getString(9)));
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
                ThongTinPhongBan pb = new ThongTinPhongBan(rs.getString(1),
                        rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7),rs.getString(8),rs.getString(9));
            return pb;
            }

        }catch (Exception e){
            e.printStackTrace();

        }
        return null;
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
                list.add(new ThongTinPhongBan(rs.getString(1),
                        rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7),rs.getString(8), rs.getString(9)));
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
                list.add(new ThongTinPhongBan(rs.getString(1),
                        rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7),rs.getString(8),rs.getString(9)));
            }

        }catch (Exception e){
            e.printStackTrace();

        }
        return list;
    }




}
