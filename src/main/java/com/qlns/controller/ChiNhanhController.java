package com.qlns.controller;

import com.qlns.model.*;
import com.qlns.service.ChiNhanhService;
import com.qlns.service.PhongbanService;
import com.qlns.service.impl.ChiNhanhServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.qlns.dao.UserDao;
import com.qlns.dao.impl.UserDaoImpl;
import com.qlns.service.UserService;
import com.qlns.service.impl.PhongbanServiceImp;
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
                    XemDanhSachPhongBan(request,response);
                    break;
                case "/capnhatchinhanh":
                    CapNhatChiNhanh(request,response);
                    break;
                case "/xemphongbantheochinhanh":
                    XemPhongBanTheoChiNhanh(request,response);
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
        session.setAttribute("listcn",listcn);
        req.getRequestDispatcher("/views/admin/QLChiNhanh/DanhSachChiNhanh.jsp").forward(req,resp);

    }
    private void XemDanhSachPhongBan(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ChiNhanhService chiNhanhService = new ChiNhanhServiceImp();
        List<ChiNhanh> listcn = new ArrayList<>();
        listcn = chiNhanhService.danhsachchinhanh();
        req.setAttribute("listcn",listcn);
        req.getRequestDispatcher("/views/admin/QLChiNhanh/Chinhanh-PhongBan.jsp").forward(req,resp);

    }

    private void XemPhongBanTheoChiNhanh(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PhongbanService phongbanService = new PhongbanServiceImp();
        String macn =  req.getParameter("macn");
        List<ThongTinPhongBan> listpbcn = new ArrayList<>();
        listpbcn = phongbanService.laydanhsachphongbantheomacn(macn);
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        for (ThongTinPhongBan pb : listpbcn) {
            out.println(" <tr class=\"row100 body \">\n" +
                    "                                                <td class=\"cell100 column1\">"+pb.getMaPB()+"</td>\n" +
                    "                                                <td class=\"cell100 column2\">"+pb.getTenPB()+"</td>\n" +
                    "                                                <td class=\"cell100 column3\">"+pb.getTenChiNhanh()+"<td>\n" +
                    "                                            </tr>");
        }

    }

    private void CapNhatChiNhanh(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String kieucapnhat = req.getParameter("kieucapnhat");

        switch (kieucapnhat) {
            case "them":
                themchinhanh(req, resp);
                break;
            case "capnhat":
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

        LocalDate ngaythanhlap = LocalDate.parse(req.getParameter("ngaythanhlap"));
        ChiNhanh cn = new ChiNhanh(req.getParameter("macn"),req.getParameter("magiamdoc"),req.getParameter("tencn"),req.getParameter("diachi"), ngaythanhlap);

        chiNhanhService.capnhatchinhanh(cn);
        List<ChiNhanh> listcn = new ArrayList<>();
        listcn = chiNhanhService.danhsachchinhanh();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        for (ChiNhanh CN : listcn) {
            out.println("<tr class=\"row100 body dscn-table-tr\" onclick=\"handleItemClick('"+CN.getMaCN()+"','"+CN.getTenChiNhanh()+"','"+CN.getDiaChi()+"','"+CN.getNgayBD()+"','"+cn.getMaGiamDoc()+"')\">\n" +
                    "                                                <td class=\"cell100 column1\">"+CN.getMaCN()+"</td>\n" +
                    "                                                <td class=\"cell100 column2\">"+CN.getTenChiNhanh()+"</td>\n" +
                    "                                                <td class=\"cell100 column3\">"+CN.getDiaChi()+"</td>\n" +
                    "                                                <td class=\"cell100 column4\">"+CN.getNgayBD()+"</td>\n" +
                    "                                                <td class=\"cell100 column5\">"+CN.getMaGiamDoc()+"</td>\n" +
                    "                                            </tr>");
        }
    }
    private void themchinhanh(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ChiNhanhService chiNhanhService = new ChiNhanhServiceImp();

        LocalDate ngaythanhlap = LocalDate.parse(req.getParameter("ngaythanhlap").isEmpty() ? null : req.getParameter("ngaythanhlap"));
        ChiNhanh cn = new ChiNhanh(req.getParameter("macn").isEmpty() ? null : req.getParameter("macn"),req.getParameter("magiamdoc").isEmpty() ? null : req.getParameter("magiamdoc"),req.getParameter("tencn").isEmpty() ? null : req.getParameter("tencn"),req.getParameter("diachi").isEmpty() ? null : req.getParameter("diachi"), ngaythanhlap);

        chiNhanhService.themchinhanh(cn);
        List<ChiNhanh> listcn = new ArrayList<>();
        listcn = chiNhanhService.danhsachchinhanh();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        for (ChiNhanh CN : listcn) {
            out.println("<tr class=\"row100 body dscn-table-tr\" onclick=\"handleItemClick('"+CN.getMaCN()+"','"+CN.getTenChiNhanh()+"','"+CN.getDiaChi()+"','"+CN.getNgayBD()+"','"+cn.getMaGiamDoc()+"')\">\n" +
                    "                                                <td class=\"cell100 column1\">"+CN.getMaCN()+"</td>\n" +
                    "                                                <td class=\"cell100 column2\">"+CN.getTenChiNhanh()+"</td>\n" +
                    "                                                <td class=\"cell100 column3\">"+CN.getDiaChi()+"</td>\n" +
                    "                                                <td class=\"cell100 column4\">"+CN.getNgayBD()+"</td>\n" +
                    "                                                <td class=\"cell100 column5\">"+CN.getMaGiamDoc()+"</td>\n" +
                    "                                            </tr>");
        }

    }
    private void xoachinhanh(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ChiNhanhService chiNhanhService = new ChiNhanhServiceImp();

        LocalDate ngaythanhlap = LocalDate.parse(req.getParameter("ngaythanhlap"));
        ChiNhanh cn = new ChiNhanh(req.getParameter("macn"),req.getParameter("magiamdoc"),req.getParameter("tencn"),req.getParameter("diachi"), ngaythanhlap);

        chiNhanhService.capnhatchinhanh(cn);
        List<ChiNhanh> listcn = new ArrayList<>();
        listcn = chiNhanhService.danhsachchinhanh();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        for (ChiNhanh CN : listcn) {
            out.println("<tr class=\"row100 body dscn-table-tr\" onclick=\"handleItemClick('"+CN.getMaCN()+"','"+CN.getTenChiNhanh()+"','"+CN.getDiaChi()+"','"+CN.getNgayBD()+"','"+cn.getMaGiamDoc()+"')\">\n" +
                    "                                                <td class=\"cell100 column1\">"+CN.getMaCN()+"</td>\n" +
                    "                                                <td class=\"cell100 column2\">"+CN.getTenChiNhanh()+"</td>\n" +
                    "                                                <td class=\"cell100 column3\">"+CN.getDiaChi()+"</td>\n" +
                    "                                                <td class=\"cell100 column4\">"+CN.getNgayBD()+"</td>\n" +
                    "                                                <td class=\"cell100 column5\">"+CN.getMaGiamDoc()+"</td>\n" +
                    "                                            </tr>");
        }

    }

}
