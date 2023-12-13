package com.qlns.controller;

import com.qlns.dao.UserDao;
import com.qlns.dao.impl.UserDaoImpl;
import com.qlns.model.*;
import com.qlns.service.ChiNhanhService;
import com.qlns.service.PhongbanService;
import com.qlns.service.UserService;
import com.qlns.service.impl.ChiNhanhServiceImp;
import com.qlns.service.impl.PhongbanServiceImp;
import com.qlns.service.impl.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;

@WebServlet("/phongban/*")
public class PhongBanController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String relativePath = uri.substring(contextPath.length() + "/phongban".length());
        try{
            switch (relativePath){
                case "/":
                    xemphongban(request,response);
                    break;
                case "/danhsachnhanvientheophongban":
                    danhsachnhanvientheophongban(request, response);
                    break;
                case "/danhsachnhanvienphongban":
                    danhsachphongbannv(request, response);
                    break;
                case "/xemphongbancon":
                    xemphongbancon(request, response);
                    break;
                case "/xemphongbancha":
                    xemphongbancha(request,response);
                    break;
                case "/capnhatphongban":
                    capnhatphongban(request,response);
                    break;
                case "/xemphongbanchuacapnhatquanly":
                    xemphongbanchuacapnhatquanly(request,response);
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
        doGet(req, resp);
    }
    private void danhsachphongbannv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImp();
        PhongbanService pbService = new PhongbanServiceImp();
        System.out.println("xem phobng bnan");
        HttpSession session = request.getSession();
        TaiKhoan tk = (TaiKhoan)session.getAttribute("account");
        Thongtinnhanvien user = userService.laythongtincanhan(tk.getMaNV());
        session.setAttribute("user", user);

        List<ThongTinPhongBan> listpb = new ArrayList<>();
        if(tk.getUserRole().equals("admin")){
            listpb = pbService.layhetdanhsachphongban();
        }
        else {
            if (tk.getUserRole().equals("giamdoc")) {
                listpb =  pbService.layhetdanhsachphongbangiamdoc(tk.getMaNV());
            } else {
                if (tk.getUserRole().equals("truongphong")) {
                    listpb = pbService.layhetdanhsachphongbantruongphong(tk.getMaNV());
                } else {
                    if (tk.getUserRole().equals("totruong"))
                    {
                        listpb.add(pbService.layhetphongbanthanquanly(tk.getMaNV()));
                    }
                    else
                    {
                        listpb= null;
                    }

                }
            }
        }

        session.setAttribute("listpbtheouser",listpb);
        //response.sendRedirect(request.getContextPath()+"/views/admin/QLPhongBan/DanhSachPhongBan.jsp");
        request.getRequestDispatcher("/views/admin/QLPhongBan/CapNhatNhanVien.jsp").forward(request,response);
    }

    private void xemphongban(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        UserService userService = new UserServiceImp();
        PhongbanService pbService = new PhongbanServiceImp();
        System.out.println("xem phobng bnan");
        HttpSession session = request.getSession();
        TaiKhoan tk = (TaiKhoan)session.getAttribute("account");
        Thongtinnhanvien user = userService.laythongtincanhan(tk.getMaNV());
        session.setAttribute("user", user);

        List<ThongTinPhongBan> listpb = new ArrayList<>();
        if(tk.getUserRole().equals("admin")){
            listpb = pbService.laydanhsachphongbanchaquyenadmin();
        }
        else {
            if (tk.getUserRole().equals("giamdoc")) {
                listpb =  pbService.laydanhsachphongbangiamdoc(tk.getMaNV());
            } else {
                if (tk.getUserRole().equals("truongphong")) {
                    listpb.add(pbService.layhetphongbanthanquanly(tk.getMaNV()));
                } else {
                    if(tk.getUserRole().equals("totruong")) {
                        listpb.add(pbService.layhetphongbanthanquanly(tk.getMaNV()));
                    }
                    else
                        request.getRequestDispatcher("/nhanvien/thongtin?manv="+tk.getMaNV()+"/").forward(request,response);
                }
            }
        }
        session.setAttribute("listpb",listpb);
        //response.sendRedirect(request.getContextPath()+"/views/admin/QLPhongBan/DanhSachPhongBan.jsp");
        request.getRequestDispatcher("/views/admin/QLPhongBan/DanhSachPhongBan.jsp").forward(request,response);
    }
    private void xemphongbancon(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
        String MaPB = req.getParameter("maphong");
        PhongbanService phongbanService = new PhongbanServiceImp();
        List<ThongTinPhongBan> listpbcon = new ArrayList<>();
        listpbcon = phongbanService.laydanhsachphongbancontuphongbancha(MaPB);
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        for (ThongTinPhongBan pb : listpbcon) {
            out.println("<div class=\"col-6 phongban-item--container\">\n" +
                    "                                            <div class=\"phongban-item\" onclick=\"handleItemClick(event,'"+pb.getTenPB()+"', '"+pb.getMaPB()+"', '"+pb.getTenChiNhanh()+"', '"+pb.getTenQuanLy()+"', '"+pb.getNgayBD()+"','"+pb.getMaQuanLy()+"','"+pb.getMaCN()+"')\">\n" +
                    "                                                <h1 class=\"tenphong\">"+pb.getTenPB()+"</h1>\n" +
                    "                                                <div class=\"chitietphong\">\n" +
                    "                                                    <div class=\"maphong-container chitiet-container\">\n" +
                    "                                                        <h3 class=\"maphong-label\">Mã phòng:</h3>\n" +
                    "                                                        <h3 class=\"maphong-text\">"+pb.getMaPB()+"</h3>\n" +
                    "                                                    </div>\n" +
                    "                                                    <div class=\"chinhanh-container chitiet-container\">\n" +
                    "                                                        <h3 class=\"chinhanh-label\">Chi nhánh:</h3>\n" +
                    "                                                        <h3 class=\"chinhanh-text\">"+pb.getTenChiNhanh()+"</h3>\n" +
                    "                                                    </div>\n" +
                    "                                                </div>\n" +
                    "                                                </div>\n" +
                    "                                            </div>");


        }
    }
    private void xemphongbancha(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        List<ThongTinPhongBan> listpbcha = new ArrayList<>();

        listpbcha = (List<ThongTinPhongBan>)session.getAttribute("listpb");

        PrintWriter out = resp.getWriter();
        for (ThongTinPhongBan pb : listpbcha) {
            out.println("<div class=\"col-6 phongban-item--container\">\n" +
                    "                                                <div class=\"phongban-item\" onclick=\"handleItemClick(event,'"+pb.getTenPB()+"', '"+pb.getMaPB()+"', '"+pb.getTenChiNhanh()+"', '"+pb.getTenQuanLy()+"', '"+pb.getNgayBD()+"','"+pb.getMaQuanLy()+"','"+pb.getMaCN()+"')\">\n" +
                    "                                                    <h1 class=\"tenphong\">"+pb.getTenPB()+"</h1>\n" +
                    "                                                    <div class=\"chitietphong\">\n" +
                    "                                                        <div class=\"maphong-container chitiet-container\">\n" +
                    "                                                            <h3 class=\"maphong-label\">Mã phòng:</h3>\n" +
                    "                                                            <h3 class=\"maphong-text\">"+pb.getMaPB()+"</h3>\n" +
                    "                                                        </div>\n" +
                    "                                                        <div class=\"chinhanh-container chitiet-container\">\n" +
                    "                                                            <h3 class=\"chinhanh-label\">Chi nhánh:</h3>\n" +
                    "                                                            <h3 class=\"chinhanh-text\">"+pb.getTenChiNhanh()+"</h3>\n" +
                    "                                                        </div>\n" +
                    "                                                        <div class=\"button-xemphongcon--container\">\n" +
                    "                                                            <button class=\"button-xemphongcon btn btn-outline-primary\" onclick= xempbcon('"+pb.getMaPB()+"')>Xem phòng ban con</button>\n" +
                    "                                            </div>\n" +
                    "                                                </div>\n" +
                    "                                                </div>\n" +
                    "                                            </div>");
        }
    }
    private void xemphongbanchuacapnhatquanly(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PhongbanService pbService = new PhongbanServiceImp();
        List<ThongTinPhongBan> listpbchuaql = new ArrayList<>();

        listpbchuaql = pbService.laydanhsachphongbanchuacapnhatquanly();
        PrintWriter out = resp.getWriter();
        for (ThongTinPhongBan pb : listpbchuaql) {
            out.println("<div class=\"col-6 phongban-item--container\">\n" +
                    "                                            <div class=\"phongban-item\" onclick=\"handleItemClick(event,'"+pb.getTenPB()+"', '"+pb.getMaPB()+"', '"+pb.getTenChiNhanh()+"', '"+pb.getTenQuanLy()+"', '"+pb.getNgayBD()+"','"+pb.getMaQuanLy()+"','"+pb.getMaCN()+"')\">\n" +
                    "                                                <h1 class=\"tenphong\">"+pb.getTenPB()+"</h1>\n" +
                    "                                                <div class=\"chitietphong\">\n" +
                    "                                                    <div class=\"maphong-container chitiet-container\">\n" +
                    "                                                        <h3 class=\"maphong-label\">Mã phòng:</h3>\n" +
                    "                                                        <h3 class=\"maphong-text\">"+pb.getMaPB()+"</h3>\n" +
                    "                                                    </div>\n" +
                    "                                                    <div class=\"chinhanh-container chitiet-container\">\n" +
                    "                                                        <h3 class=\"chinhanh-label\">Chi nhánh:</h3>\n" +
                    "                                                        <h3 class=\"chinhanh-text\">"+pb.getTenChiNhanh()+"</h3>\n" +
                    "                                                    </div>\n" +
                    "                                                </div>\n" +
                    "                                                </div>\n" +
                    "                                            </div>");


        }
    }
    private void danhsachnhanvientheophongban(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        String MaPB = req.getParameter("MaPB");
        UserService userService = new UserServiceImp();

        List<Thongtinnhanvien> listnv =  new ArrayList<>();
        if (MaPB.substring(0, 3).equals("PBC"))
            listnv = userService.laydanhsachnhanvientheophongbancha(MaPB);
        else
            listnv = userService.laydanhsachnhanvientheophongban(MaPB);

        HttpSession session = req.getSession();
        session.setAttribute("listnvcuapb", listnv);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        for (Thongtinnhanvien nv : listnv) {
            out.println("<tr onclick=\"chitietnhanvien('" + nv + "')\">\n" +
                    "                                                     <td class='column1'>" + nv.getMaNV() + "</td>\n" +
                    "                                                       <td class='column2'>" + nv.getHoTen() + "</td>\n" +
                    "                                                       <td class='column3'>" + nv.getTenChucVu() + "</td>\n" +
                    "                                                   </tr>");


        }
    }

    private void capnhatphongban(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        String kieucapnhat = request.getParameter("kieucapnhat");
        try{
            switch (kieucapnhat){
                case "them":
                    themphongban(request,response);
                    break;
                case "sua":
                    suaphongban(request,response);
                    break;
                case "xoa":
                    xoaphongban(request,response);
                    break;
                case "suapbchuaquanly":
                    suaphongbanpbchuaquanly(request,response);
                    break;
            }
        }catch (Exception ex){
            System.out.print(ex);
        }

    }
    private void themphongban(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{

        PhongbanService  phongbanService = new PhongbanServiceImp();
        PhongBan pb = new PhongBan();
        pb.setMaPB(request.getParameter("maphong").isEmpty() ? null : request.getParameter("maphong"));
        pb.setTenPB(request.getParameter("tenpb").isEmpty() ? null : request.getParameter("tenpb"));
        pb.setMaCN(request.getParameter("macn"));
        pb.setMaPBCha(request.getParameter("mapbcha").isEmpty() ? null : request.getParameter("mapbcha"));
        pb.setTenPBCha(request.getParameter("tenpbcha").isEmpty() ? null : request.getParameter("tenpbcha"));
        pb.setMaQuanLy(request.getParameter("maql").isEmpty() ? null : request.getParameter("maql"));
        LocalDate ngaythanhlap =LocalDate.parse(request.getParameter("mgaybd").isEmpty() ? null : request.getParameter("mgaybd"));
        pb.setNgayBD(ngaythanhlap);
        UserService userService = new UserServiceImp();

        phongbanService.themphongban(pb);

    }
    private void suaphongban(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        PhongBan pb = new PhongBan();
        UserService userService = new UserServiceImp();
        PhongbanService  phongbanService = new PhongbanServiceImp();
        pb.setMaPB(request.getParameter("maphong").isEmpty() ? null : request.getParameter("maphong"));
        pb.setTenPB(request.getParameter("tenpb").isEmpty() ? null : request.getParameter("tenpb"));
        pb.setMaCN(request.getParameter("macn"));
        pb.setMaPBCha(request.getParameter("mapbcha").isEmpty() ? null : request.getParameter("mapbcha"));
        pb.setTenPBCha(request.getParameter("tenpbcha").isEmpty() ? null : request.getParameter("tenpbcha"));
        pb.setMaQuanLy(request.getParameter("maql").isEmpty() ? null : request.getParameter("maql"));
        LocalDate ngaythanhlap =LocalDate.parse(request.getParameter("mgaybd").isEmpty() ? null : request.getParameter("mgaybd"));
        pb.setNgayBD(ngaythanhlap);
//        if (pb.getMaPB().substring(0, 3).equals("PBC"))
//        {
//            userService.capnhatnhanvientruockhilenchuc(pb.getMaQuanLy(),pb.getMaPB(),2,2);
//        }
//        else {
//            userService.capnhatnhanvientruockhilenchuc(pb.getMaQuanLy(), pb.getMaPB(), 3, 3);
//        }
//
//        phongbanService.capnhatphongbankhichuyenchuc(phongbanService.layhetphongbanthanquanly(pb.getMaQuanLy()).getMaPB());
        phongbanService.capnhatphongban(pb);


    }
    private void xoaphongban(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        String mapb =request.getParameter("maphong");
        PhongbanService pbservice = new PhongbanServiceImp();
        pbservice.xoaphongban(mapb);

    }
    private void suaphongbanpbchuaquanly(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        PhongBan pb = new PhongBan();
        UserService userService = new UserServiceImp();
        PhongbanService  phongbanService = new PhongbanServiceImp();
        pb.setMaPB(request.getParameter("maphong").isEmpty() ? null : request.getParameter("maphong"));
        pb.setTenPB(request.getParameter("tenpb").isEmpty() ? null : request.getParameter("tenpb"));
        pb.setMaCN(request.getParameter("macn"));
        pb.setMaPBCha(request.getParameter("mapbcha").isEmpty() ? null : request.getParameter("mapbcha"));
        pb.setTenPBCha(request.getParameter("tenpbcha").isEmpty() ? null : request.getParameter("tenpbcha"));
        pb.setMaQuanLy(request.getParameter("maql").isEmpty() ? null : request.getParameter("maql"));
        LocalDate ngaythanhlap =LocalDate.parse(request.getParameter("mgaybd").isEmpty() ? null : request.getParameter("mgaybd"));
        pb.setNgayBD(ngaythanhlap);
        if (pb.getMaPB().substring(0, 3).equals("PBC"))
        {
            userService.capnhatnhanvientruockhilenchuc(pb.getMaQuanLy(),pb.getMaPB(),2,2);
        }
        else {
            userService.capnhatnhanvientruockhilenchuc(pb.getMaQuanLy(), pb.getMaPB(), 3, 3);
        }

        phongbanService.capnhatphongbankhichuyenchuc(phongbanService.layhetphongbanthanquanly(pb.getMaQuanLy()).getMaPB());
        phongbanService.capnhatphongbanchuaquanly(pb);

    }




}
