package com.qlns.controller;

import com.qlns.model.ChiNhanh;
import com.qlns.service.ChiNhanhService;
import com.qlns.service.impl.ChiNhanhServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.qlns.dao.UserDao;
import com.qlns.dao.impl.UserDaoImpl;
import com.qlns.model.NhanVien;
import com.qlns.model.TaiKhoan;
import com.qlns.model.Thongtinnhanvien;
import com.qlns.service.UserService;
import com.qlns.service.impl.UserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/chinhanh/*")
public class ChiNhanhController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String relativePath = uri.substring(contextPath.length() +"/chinhanh".length());
        try{
            switch (relativePath){
                case "/":
                    XemDanhSachChiNhanh(request,response);
                    break;
                case "/dachsachphongbanchinhanh":
                    XemDanhSachChiNhanh(request,response);
                    break;
                case "/capnhatchinhanh":
                    XemDanhSachChiNhanh(request,response);
                    break;
                default:
                    response.sendRedirect(request.getContextPath()+"/error/error.jsp");
                    break;
            }
        }catch (Exception ex){
            System.out.print(ex);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
    private void XemDanhSachChiNhanh(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ChiNhanhService chiNhanhService = new ChiNhanhServiceImp();
        List<ChiNhanh> listcn = new ArrayList<>();
        listcn = chiNhanhService.danhsachchinhanh();
        HttpSession session = req.getSession();
        req.setAttribute("listcn",listcn);
        req.getRequestDispatcher("/views/admin/QLChiNhanh/DanhSachChiNhanh.jsp").forward(req,resp);

    }
    private void XemDanhSachPhongBan(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ChiNhanhService chiNhanhService = new ChiNhanhServiceImp();
        List<ChiNhanh> listcn = new ArrayList<>();
        listcn = chiNhanhService.danhsachchinhanh();
        HttpSession session = req.getSession();
        req.setAttribute("listcn",listcn);
        req.getRequestDispatcher("/views/admin/QLChiNhanh/DanhSachChiNhanh.jsp").forward(req,resp);

    }
    private void CapNhatChiNhanh(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String kieucapnhat = req.getParameter("kieucapnhat");

        switch (kieucapnhat) {
            case "them":
                themchinhnah(req, resp);
                break;
            case "sua":
                suachinhanh(req, resp);
                break;
            case "xoa":
                XemDanhSachChiNhanh(req, resp);
                break;
            default:
                resp.sendRedirect(req.getContextPath() + "/error/error.jsp");
                break;


        }
    }
    private void suachinhanh(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ChiNhanhService chiNhanhService = new ChiNhanhServiceImp();
        List<ChiNhanh> listcn = new ArrayList<>();
        listcn = chiNhanhService.danhsachchinhanh();
        HttpSession session = req.getSession();
        req.setAttribute("listcn",listcn);
        req.getRequestDispatcher("/views/admin/QLChiNhanh/DanhSachChiNhanh.jsp").forward(req,resp);
    }
    private void themchinhnah(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ChiNhanhService chiNhanhService = new ChiNhanhServiceImp();
        ChiNhanh cn = new ChiNhanh(req.getParameter("macn"),req.getParameter("magiamdoc"),req.getParameter("tencn"),req.getParameter("diachi"), Date.valueOf(req.getParameter("ngaythanhlap")).toLocalDate());

        chiNhanhService.themchinhanh(cn);

        req.getRequestDispatcher("/views/admin/QLChiNhanh/DanhSachChiNhanh.jsp").forward(req,resp);

    }
    private void xoachinhanh(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ChiNhanhService chiNhanhService = new ChiNhanhServiceImp();
        List<ChiNhanh> listcn = new ArrayList<>();
        listcn = chiNhanhService.danhsachchinhanh();
        HttpSession session = req.getSession();
        req.setAttribute("listcn",listcn);
        req.getRequestDispatcher("/views/admin/QLChiNhanh/DanhSachChiNhanh.jsp").forward(req,resp);

    }

}
