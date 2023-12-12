package com.qlns.controller;

import com.qlns.model.HopDong;
import com.qlns.model.TaiKhoan;
import com.qlns.model.Thongtinnhanvien;
import com.qlns.service.HopDongService;
import com.qlns.service.TaiKhoanService;
import com.qlns.service.impl.HopDongServiceImpl;
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
        if (relativePath.startsWith("/thongtin")) {
            XuLyTaiKhoan(request, response);
            return;
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    public void XemDanhSachTaiKhoan(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        HttpSession session = request.getSession();
        TaiKhoan tk = (TaiKhoan)session.getAttribute("account");

        List<TaiKhoan> listtk = taiKhoanService.getTaiKhoan();
        //Parse to JSON
        StringBuilder jsonString = new StringBuilder();
        jsonString.append("[");

        for (TaiKhoan taikoan : listtk) {
            jsonString.append("{");
            jsonString.append("\"userID\": \"").append(taikoan.getUserID()).append("\",");
            jsonString.append("\"userName\": \"").append(taikoan.getUserName()).append("\",");
            jsonString.append("\"password\": \"").append(taikoan.getPassword()).append("\",");
            jsonString.append("\"userRole\": \"").append(taikoan.getUserRole()).append("\",");
            jsonString.append("\"maNV\": \"").append(taikoan.getMaNV()).append("\"");
            jsonString.append("},");
        }

        if (!listtk.isEmpty()) {
            jsonString.deleteCharAt(jsonString.length() - 1); // Remove the last comma
        }

        jsonString.append("]");

        response.setContentType("application/json");
        response.getWriter().println(jsonString);
        response.setStatus(HttpServletResponse.SC_ACCEPTED);


    }
    public void CapNhatTaiKhoan(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        int userID = Integer.parseInt(request.getParameter("userID"));
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String userRole = request.getParameter("userRole");
        String  maNV = request.getParameter("maNV");
        TaiKhoan tk = new TaiKhoan(userID,userName,password,userRole,maNV);
        boolean status =  taiKhoanService.capNhatTaiKhoan(tk);
        if (status) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }
    public void themTaiKhoan(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        int userID = Integer.parseInt(request.getParameter("userID"));
        String userName = request.getParameter("userName").isEmpty()?null:request.getParameter("userName");
        String password = request.getParameter("password").isEmpty()?null:request.getParameter("password");
        String userRole = request.getParameter("userRole").isEmpty()?null:request.getParameter("userRole");
        String  maNV = request.getParameter("maNV").isEmpty()?null:request.getParameter("maNV");;


        TaiKhoan tk = new TaiKhoan(userID,userName,password,userRole,maNV);
        boolean status =  taiKhoanService.themTaiKhoan(tk);
        if (status) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }
    public void  XoaTaiKhoan(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        int userID = Integer.parseInt(request.getParameter("userID"));
        boolean status =  taiKhoanService.xoaTaiKhoan(userID);
        if (status) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
    public void XuLyTaiKhoan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        final String startRoute = "/taikhoan";
        String action = request.getPathInfo().substring(startRoute.length());
        System.out.println(action);

        switch (action) {
            case "":
                request.getRequestDispatcher("/views/admin/QLTaiKhoan/TaiKhoan.jsp").forward(request,response);
                break;
            case "/danhsach":
                XemDanhSachTaiKhoan(request, response);
                break;
            case "/them":
                themTaiKhoan(request, response);
                break;
            case "/sua":
                CapNhatTaiKhoan(request, response);
                break;
            case "/xoa":
               XoaTaiKhoan(request, response);
                break;
            default:
        }
    }

}
