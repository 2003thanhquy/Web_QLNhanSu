package com.qlns.controller;

import com.qlns.model.NhanVien;
import com.qlns.model.TaiKhoan;
import com.qlns.model.Thongtinnhanvien;
import com.qlns.service.UserService;
import com.qlns.service.impl.UserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@WebServlet("/nhanvien/*")
public class NhanVienController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String relativePath = uri.substring(contextPath.length() + "/nhanvien".length());
        try{
            switch (relativePath){
                case "/":
                    XemNhanVien(request,response);
                    break;
                case "/themnhanvien":
                    ThemNhanVien(request,response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    public void XemNhanVien(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        UserService userService = new UserServiceImp();
        HttpSession session = request.getSession();
        TaiKhoan tk = (TaiKhoan)session.getAttribute("account");
        Thongtinnhanvien user = userService.laythongtincanhan(tk.getMaNV());
        request.setAttribute("user", user);
        List<Thongtinnhanvien> listnv = null;
        if(tk.getUserRole().equals("admin")){
            listnv = userService.laydanhsachnhanvienadmin();
        }
        else {
            if (tk.getUserRole().equals("giamdoc")) {
                listnv = userService.laydanhsachnhanviengiamdoc(tk.getMaNV());
            } else {
                if (tk.getUserRole().equals("truongphong")) {
                    listnv = userService.laydanhsachnhanvientruongphong(tk.getMaNV());
                } else {
//                    listpb = (List<PhongBan>) pbService.layphongbanthanquanly(tk.getMaNV());
                }
            }
        }
        request.setAttribute("listnv",listnv);
        request.getRequestDispatcher("/views/admin/QLNhanVien/XemNhanVien.jsp").forward(request,response);
    }
    public void ThemNhanVien(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
            if(request.getMethod().equals("GET")){
                request.getRequestDispatcher("/views/admin/QLNhanVien/ThemNhanVien.jsp").forward(request,response);
            }else{
                String hoten = request.getParameter("tnv-hovaten");
                String cmnd = request.getParameter("tnv-cmnd");
                String diachi = request.getParameter("tnv-diachi");
                String sdt = request.getParameter("tnv-sdt");
                DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate targetDate = LocalDate.parse(request.getParameter("tnv-ngaysinh"),df);
                String gioitinh = request.getParameter("gender");
                int idphongban = Integer.parseInt(request.getParameter("tnv-idphongban"));
                int idchucvu = Integer.parseInt(request.getParameter("tnv-idchucvu"));
                int idtrinhdo = Integer.parseInt(request.getParameter("tnv-idtrinhdo"));
                Part part = request.getPart("image");


            }

    }

}