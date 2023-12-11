package com.qlns.dao.impl;

import com.qlns.connection.DBConnection;
import com.qlns.dao.TrinhDoDao;
import com.qlns.model.TrinhDo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrinhDoDaoImpl  implements TrinhDoDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public List<TrinhDo> getTrinhDo() {
        List<TrinhDo> lstTrinhdo = new ArrayList<>();
        String sql = "SELECT * FROM Trinhdo where status = 1";
        try{
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                TrinhDo td = new TrinhDo();
                td.setIdTrinhDo(rs.getInt("IDTrinhDo"));
                td.setTenTrinhDo(rs.getString("TenTrinhdo"));
                lstTrinhdo.add(td);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return lstTrinhdo;
    }
}
