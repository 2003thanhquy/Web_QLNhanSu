package com.qlns.controller;

import com.qlns.model.TaiKhoan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet( "/waiting")
public class WaitingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.print("waitting");
        HttpSession session = request.getSession();
        if(session != null && session.getAttribute("account")!=null){
            TaiKhoan acc = (TaiKhoan) session.getAttribute("account");
            request.setAttribute("username",acc.getUserName());
            if(acc.getUserRole().equals("admin")){
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }
            else {
                if (acc.getUserRole().equals("user")) {
                    response.sendRedirect(request.getContextPath()+"/thongtincanhan");
                } else {
                    response.sendRedirect(request.getContextPath() + "/index.jsp");
                }
            }

        }else{
            response.sendRedirect(request.getContextPath()+"/login/login.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}