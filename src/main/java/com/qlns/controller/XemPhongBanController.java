package com.qlns.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = {"/XemPhongBan"})
public class XemPhongBanController extends HttpServlet {
    @Override
    protected  void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException, ServletException {
        // resp.sendRedirect(req.getContextPath()+"/views/GiamDoc/PhongBan.jsp");
        RequestDispatcher rs = req.getRequestDispatcher("/views/admin/QLPhongBan/DanhSachPhongBan.jsp");
        rs.forward(req,resp);
    }
    @Override
    protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {

    }
}
