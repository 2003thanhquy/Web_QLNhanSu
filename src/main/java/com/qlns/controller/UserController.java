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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet( "/thongtincanhan")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService;

    public void init(ServletConfig config) throws ServletException {
        userService = new UserServiceImp();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            thongtincanhan(request,response);

    } catch (SQLException e) {

        e.printStackTrace();
    }

    }
    private void thongtincanhan(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        TaiKhoan tk = (TaiKhoan)session.getAttribute("account");
        Thongtinnhanvien user = userService.laythongtincanhan(tk.getMaNV());
        session.setAttribute("user", user);
        /*RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath()+ "/nhanvien/thongtincanhan.jsp");
        dispatcher.forward(request, response);*/

        response.sendRedirect(request.getContextPath()+ "/nhanvien/thongtincanhan.jsp");
    }
}
