package com.qlns.controller;

import com.qlns.model.TaiKhoan;
import com.qlns.model.Thongtinnhanvien;
import com.qlns.service.TaiKhoanService;
import com.qlns.service.impl.TaiKhoanServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/taikhoan/*")
@MultipartConfig
public class TaiKhoanController extends HttpServlet {
    private TaiKhoanService taiKhoanService;
    @Override
    public void init() {
        taiKhoanService = new TaiKhoanServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String relativePath = uri.substring(contextPath.length() + "/taikhoan".length());
        try {
            switch (relativePath){
                case "/":
                    this.XemDanhSachTaiKhoan(request,response);
                    break;
                default:
                    response.sendRedirect(request.getContextPath()+"/error/error.jsp");
            }
        }catch (Exception ex){
            System.out.print(ex);
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void XemDanhSachTaiKhoan(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        HttpSession session = request.getSession();
        TaiKhoan tk = (TaiKhoan)session.getAttribute("account");
        Thongtinnhanvien user = (Thongtinnhanvien)  session.getAttribute("user");
        List<TaiKhoan> listtk = taiKhoanService.getTaiKhoan(tk.getUserRole(),user.getMaNV());
        request.setAttribute("listtk",listtk);
        request.getRequestDispatcher("/views/admin/QLTaiKhoan/TaiKhoan.jsp").forward(request,response);
    }
}
