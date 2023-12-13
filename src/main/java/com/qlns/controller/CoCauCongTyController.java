package com.qlns.controller;

import com.qlns.model.ChiNhanh;
import com.qlns.model.TaiKhoan;
import com.qlns.service.ChiNhanhService;
import com.qlns.service.impl.ChiNhanhServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cocaucongty/*")

public class CoCauCongTyController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String relativePath = uri.substring(contextPath.length() +"/chinhanh".length());
        try{
            switch (relativePath){
                case "/":
                    XemCoCauCongTy(request,response);
                    break;
                default:
                    response.sendRedirect(request.getContextPath()+"/error/error.jsp");
                    break;
            }
        }catch (Exception ex){
            System.out.print(ex);
        }
    }

    private void XemCoCauCongTy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChiNhanhService chiNhanhService = new ChiNhanhServiceImp();
        HttpSession session = request.getSession();
        TaiKhoan tk = (TaiKhoan)session.getAttribute("account");

        List<ChiNhanh> listcn = new ArrayList<>();
        listcn = chiNhanhService.danhsachchinhanh();

        request.setAttribute("listcncc",listcn);

        request.getRequestDispatcher("/views/admin/CoCauCongTy/CoCauCongTy.jsp").forward(request,response);

    }

}
