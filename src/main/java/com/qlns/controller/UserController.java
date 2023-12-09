package com.qlns.controller;

import com.qlns.dao.UserDao;
import com.qlns.model.ChucVu;
import com.qlns.model.NhanVien;
import com.qlns.model.TaiKhoan;
import com.qlns.model.Thongtinnhanvien;
import com.qlns.service.LoginService;
import com.qlns.service.UserService;
import com.qlns.service.impl.LoginServiceImp;
import com.qlns.service.impl.UserServiceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/themnhanvien"})
@MultipartConfig
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService;

    public void init(ServletConfig config) throws ServletException {
        userService = new UserServiceImp();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            thongtincanhan(request, response);
//
//        } catch (SQLException e) {
//
//            e.printStackTrace();
//        }
        try {
            themnhanvien(request, response);

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void thongtincanhan(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        TaiKhoan tk = (TaiKhoan) session.getAttribute("account");
        Thongtinnhanvien user = userService.laythongtincanhan(tk.getMaNV());
        session.setAttribute("user", user);
        /*RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath()+ "/nhanvien/thongtincanhan.jsp");
        dispatcher.forward(request, response);*/

        response.sendRedirect(request.getContextPath() + "/nhanvien/thongtincanhan.jsp");
    }


    private void themnhanvien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
//        HttpSession session = request.getSession();
//        TaiKhoan tk = (TaiKhoan) session.getAttribute("account");
//        Thongtinnhanvien user = userService.laythongtincanhan(tk.getMaNV());
//        session.setAttribute("user", user);
        InputStream fileInputStream = request.getPart("image").getInputStream();
        byte[] fileData = fileInputStream.readAllBytes();

        Byte[] byteArrayWrapper = new Byte[fileData.length];
        for (int i = 0; i < fileData.length; i++) {
            byteArrayWrapper[i] = fileData[i];
        }

        String hoVaTen = request.getParameter("tnv-hovaten");
        String cmnd = request.getParameter("tnv-cmnd");
        String diaChi = request.getParameter("tnv-diachi");
        String sdt = request.getParameter("tnv-sdt");
        String ngaySinh = request.getParameter("tnv-ngaysinh");
        String gioiTinh = request.getParameter("gender");
        String maPhongBan = request.getParameter("tnv-idphongban");
        int maBacLuong = Integer.parseInt(request.getParameter("tnv-idbacluong"));
        int maChucVu = Integer.parseInt(request.getParameter("tnv-idchucvu"));
        int maTrinhDo = Integer.parseInt(request.getParameter("tnv-idtrinhdo"));

        userService.themnhanvien( maPhongBan, maBacLuong, maChucVu, maTrinhDo, hoVaTen, cmnd, diaChi, byteArrayWrapper, sdt, ngaySinh, gioiTinh);
            response.sendRedirect("XemNhanVien");


    }
}

