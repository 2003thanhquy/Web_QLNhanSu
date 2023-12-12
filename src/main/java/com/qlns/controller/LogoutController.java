package com.qlns.controller;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutController extends  HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xóa session khi người dùng đăng xuất
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Hủy bỏ session
        }
        // Chuyển hướng về trang đăng nhập
        response.sendRedirect(request.getContextPath()+"/login");
    }
}