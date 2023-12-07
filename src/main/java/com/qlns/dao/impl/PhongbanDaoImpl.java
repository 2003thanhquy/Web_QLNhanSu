package com.qlns.dao.impl;

import com.qlns.connection.DBConnection;
import com.qlns.dao.PhongbanDao;
import com.qlns.model.PhongBan;

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
    public List<PhongBan> layhetdanhsachphongban() {
        List<PhongBan> list = new ArrayList<>();
        String sql =  "SELECT * FROM  PhongBan WHERE status = 1";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
        list.add(new PhongBan(rs.getString(1),
                rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7)));
            }


        }catch (Exception e){
            e.printStackTrace();

        }
        return list;


    }
    public List<PhongBan> laydanhsachphongbangiamdoc(String MaGiamDoc)
    {
        List<PhongBan> list = new ArrayList<>();
        String sql =" select pb.MaPB,pb.MaPBCha,pb.TenPB,TenPBCha,pb.MaCN,MaQuanLy,pb.NgayBD from\n" +
                "    QuanLyNhanSu.chinhanh cn inner join QuanLyNhanSu.phongban pb on cn.MaCN = pb.MaCN\n" +
                "    where MaGiamDoc = ? and pb.status = 1";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,MaGiamDoc);
            rs= ps.executeQuery();
            while(rs.next()){
                list.add(new PhongBan(rs.getString(1),
                        rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7)));
            }

        }catch (Exception e){
            e.printStackTrace();

        }
        return list;
    }

    @Override
    public List<PhongBan> laydanhsachphongbantruongphong(String MaTruongPhong) {
        List<PhongBan> list = new ArrayList<>();
        String sql= "   select pb.MaPB,pb.MaPBCha,pb.TenPB,pb.TenPBCha,pb.MaCN,pb.MaQuanLy,pb.NgayBD from \n" +
                "   QuanLyNhanSu.phongban pbcha inner join  QuanLyNhanSu.phongban pb on pbcha.MaPB = pb.MaPBCha\n" +
                "   where pbcha.MaQuanLy=? and pb.status =1";
        try{
            list.add(layphongbanthanquanly(MaTruongPhong));
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,MaTruongPhong);
            rs= ps.executeQuery();

            while(rs.next()){
                list.add(new PhongBan(rs.getString(1),
                        rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7)));
            }

        }catch (Exception e){
            e.printStackTrace();

        }
        return list;
    }
    public  PhongBan layphongbanthanquanly(String MaToTruong){
        String sql= " select * from phongban where MaQuanLy = ? and status =1";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,MaToTruong);
            rs= ps.executeQuery();
            while(rs.next()){
            PhongBan pb = new PhongBan(rs.getString(1),
                        rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7));
            return pb;
            }

        }catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }


}
