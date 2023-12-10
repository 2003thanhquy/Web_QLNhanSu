package com.qlns.controller;

import com.qlns.model.PhongBan;
import com.qlns.model.TaiKhoan;
import com.qlns.model.Thongtinnhanvien;
import com.qlns.service.PhongbanService;
import com.qlns.service.UserService;
import com.qlns.service.impl.PhongbanServiceImp;
import com.qlns.service.impl.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
//@WebServlet(urlPatterns = {"/XemNhanVien"})
public class XemDanhSachNhanVienController extends HttpServlet {
    protected  void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException, ServletException {
        // resp.sendRedirect(req.getContextPath()+"/views/GiamDoc/PhongBan.jsp");
        try {
            xemdanhsachnhanvien(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {

    }

    private void xemdanhsachnhanvien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        UserService userService = new UserServiceImp();


        HttpSession session = request.getSession();
        TaiKhoan tk = (TaiKhoan)session.getAttribute("account");
        Thongtinnhanvien user = userService.laythongtincanhan(tk.getMaNV());
        session.setAttribute("user", user);

        List<Thongtinnhanvien> listnv = null;
        if(tk.getUserRole().equals("admin")){
            listnv = userService.laydanhsachnhanvienadmin();
        }
        else {
            if (tk.getUserRole().equals("giamdoc")) {
                listnv = userService.laydanhsachnhanviengiamdoc(tk.getMaNV());
            } else {
                if (tk.getUserRole().equals("truongphong")) {
                    listnv = userService.laydanhsachnhanvientruongphong(tk.getMaNV());
                } else {
//                    listpb = (List<PhongBan>) pbService.layphongbanthanquanly(tk.getMaNV());
                }
            }
        }
        session.setAttribute("listnv",listnv);
        response.sendRedirect(request.getContextPath()+"/views/admin/QLNhanVien/XemNhanVien.jsp");
    }
}
