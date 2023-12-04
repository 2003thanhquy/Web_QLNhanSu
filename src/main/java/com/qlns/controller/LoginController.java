package com.qlns.controller;

import com.qlns.model.TaiKhoan;
import com.qlns.service.LoginService;
import com.qlns.service.UserService;
import com.qlns.service.impl.LoginServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.print("ok");
        response.sendRedirect(request.getContextPath()+"/login/login.jsp");
            //request.getRequestDispatcher("login/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.print("day la post");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("pwd");
        String alterMsg = "";
        if(username.isEmpty() || password.isEmpty()){
            alterMsg ="Tài khoản hoặc mật khẩu không được rỗng";
            request.setAttribute("alter",alterMsg);
            request.getRequestDispatcher("/login/login.jsp").forward(request,response);
            return;
        }
        LoginService service = new LoginServiceImp();
        TaiKhoan acc = service.Login(username,password);
        if(acc != null){
            HttpSession session = request.getSession(true);
            session.setAttribute("account",acc);
            response.sendRedirect(request.getContextPath()+"/waiting");
        }else {
            alterMsg = "Tài khoản hoặc mật khẩu không đúng!!!";
            request.setAttribute("alter",alterMsg);
            request.getRequestDispatcher("/login/login.jsp").forward(request,response);
            return;
        }
    }
}