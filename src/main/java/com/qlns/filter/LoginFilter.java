package com.qlns.filter;

import com.qlns.model.TaiKhoan;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Map;

//@WebFilter("/*")
public class LoginFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.print("lan filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestPath = request.getServletPath();
        if (!(requestPath.equals("/login")||requestPath.equals("/login/login.jsp"))) {
            HttpSession session = request.getSession();
            TaiKhoan acc =(TaiKhoan)session.getAttribute("account");
            if(acc==null){
                response.sendRedirect(request.getContextPath()+"/login");
                return;
            }

        }
        filterChain.doFilter(request, response);



    }

    @Override
    public void destroy() {

    }
}
