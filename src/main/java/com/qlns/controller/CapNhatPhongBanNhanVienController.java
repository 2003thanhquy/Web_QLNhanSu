package com.qlns.controller;

import com.qlns.dao.UserDao;
import com.qlns.dao.impl.UserDaoImpl;
import com.qlns.model.TaiKhoan;
import com.qlns.model.ThongTinPhongBan;
import com.qlns.model.Thongtinnhanvien;
import com.qlns.service.PhongbanService;
import com.qlns.service.UserService;
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
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/danhsachnhanvientheophongban","/capnhatnhanvien"})
public class CapNhatPhongBanNhanVienController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getServletPath();
        try {
            switch (action) {
                case "/danhsachnhanvientheophongban":
                    danhsachnhanvientheophongban(req, resp);
                    break;
                case "/capnhatnhanvien":
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private void danhsachnhanvientheophongban(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        String MaPB = req.getParameter("MaPB");
        UserDao userDao = new UserDaoImpl();
        List<Thongtinnhanvien> listnv = userDao.laydanhsachnhanvientheophongban(MaPB);
        HttpSession session = req.getSession();
        session.setAttribute("listnvcuapb", listnv);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        for (Thongtinnhanvien nv : listnv) {
            out.println("<tr> onclick=\"chitietnhanvien("+ nv +")\"\n" +
                    "                                                       <td>" + nv.getMaNV() + "</td>\n" +
                    "                                                       <td>" + nv.getHoTen() + "</td>\n" +
                    "                                                       <td>" + nv.getTenChucVu() + "</td>\n" +
                    "                                                   </tr>");
        }



    }

    private void capnhatphongban(HttpServletRequest request, HttpServletResponse response)
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
