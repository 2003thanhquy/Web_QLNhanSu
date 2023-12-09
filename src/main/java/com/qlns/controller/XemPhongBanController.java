package com.qlns.controller;

import com.qlns.model.PhongBan;
import com.qlns.model.TaiKhoan;
import com.qlns.model.ThongTinPhongBan;
import com.qlns.model.Thongtinnhanvien;
import com.qlns.service.PhongbanService;
import com.qlns.service.UserService;
import com.qlns.service.impl.PhongbanServiceImp;
import com.qlns.service.impl.UserServiceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/XemPhongBan"})
public class XemPhongBanController extends HttpServlet {
    @Override
    protected  void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException, ServletException {
        // resp.sendRedirect(req.getContextPath()+"/views/GiamDoc/PhongBan.jsp");
        try {
            xemphongban(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {

    }

    private void xemphongban(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        UserService userService = new UserServiceImp();
        PhongbanService pbService = new PhongbanServiceImp();

        HttpSession session = request.getSession();
        TaiKhoan tk = (TaiKhoan)session.getAttribute("account");
        Thongtinnhanvien user = userService.laythongtincanhan(tk.getMaNV());
        session.setAttribute("user", user);

        List<ThongTinPhongBan> listpb;
        if(tk.getUserRole().equals("admin")){
            listpb = pbService.layhetdanhsachphongban();
        }
        else {
            if (tk.getUserRole().equals("giamdoc")) {
                listpb =  pbService.laydanhsachphongbangiamdoc(tk.getMaNV());
            } else {
                if (tk.getUserRole().equals("truongphong")) {
                    listpb =  pbService.laydanhsachphongbantruongphong(tk.getMaNV());
                } else {
                    listpb = (List<ThongTinPhongBan>) pbService.layphongbanthanquanly(tk.getMaNV());
                }
            }
        }
        session.setAttribute("listpb",listpb);
        response.sendRedirect(request.getContextPath()+"/views/admin/QLPhongBan/DanhSachPhongBan.jsp");
    }
}
