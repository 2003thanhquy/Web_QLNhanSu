package com.qlns.controller;

import com.qlns.dao.UserDao;
import com.qlns.dao.impl.UserDaoImpl;
import com.qlns.model.ThongTinPhongBan;
import com.qlns.model.Thongtinnhanvien;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/danhsachnhanvientheophongban"})
public class CapNhatPhongBanNhanVienController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String MaPB = req.getParameter("MaPB");
        UserDao userDao = new UserDaoImpl();
        List<Thongtinnhanvien> listnv = userDao.laydanhsachnhanvientheophongban(MaPB);
        HttpSession session = req.getSession();
        session.setAttribute("listnvcuapb", listnv);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        for (Thongtinnhanvien nv : listnv) {
            out.println("<tr>\n" +
                    "                                                       <td>" + nv.getMaNV() + "</td>\n" +
                    "                                                       <td>" + nv.getHoTen() + "</td>\n" +
                    "                                                       <td>" + nv.getTenChucVu() + "</td>\n" +
                    "                                                   </tr>");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
