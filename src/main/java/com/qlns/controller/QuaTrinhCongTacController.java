package com.qlns.controller;

import com.qlns.model.TaiKhoan;
import com.qlns.model.ThongTinPhongBan;
import com.qlns.model.ThongTinQuaTrinhCongTac;
import com.qlns.model.Thongtinnhanvien;
import com.qlns.service.PhongbanService;
import com.qlns.service.QuaTrinhCongTacService;
import com.qlns.service.UserService;
import com.qlns.service.impl.PhongbanServiceImp;
import com.qlns.service.impl.QuaTrinhCongTacServiceImpl;
import com.qlns.service.impl.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/quatrinhcongtac/*")
public class QuaTrinhCongTacController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String relativePath = uri.substring(contextPath.length() + "/quatrinhcongtac".length());
        try {
            switch (relativePath) {
                case "/":
                    xemcongtacnhanvien(request,response);
                    break;
                case "/xemcongtacbanthan":
                    xemquatrinhcongtacbanthan(request, response);
                    break;

                default:
                    response.sendRedirect(request.getContextPath() + "/error/error.jsp");
                    break;
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }


    }

    private void xemcongtacnhanvien(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserService userService = new UserServiceImp();

        HttpSession session = request.getSession();
        TaiKhoan tk = (TaiKhoan)session.getAttribute("account");
        Thongtinnhanvien user = userService.laythongtincanhan(tk.getMaNV());
        session.setAttribute("user", user);
        QuaTrinhCongTacService quaTrinhCongTacService =  new QuaTrinhCongTacServiceImpl();
         List<ThongTinQuaTrinhCongTac> listqtct = new ArrayList<>();

        if(tk.getUserRole().equals("admin")){
            listqtct = quaTrinhCongTacService.layquatrinhcongtacadmin();
        }
        else {
            if (user.getIDChucVu() == 1) {
                listqtct = quaTrinhCongTacService.layquatrinhcongtacgiamdoc(tk.getMaNV());
            } else {
                response.sendRedirect(request.getContextPath() + "/nhanvien/thongtin?manv=" + tk.getMaNV());

        }
        request.setAttribute("listqtct",listqtct);

        request.getRequestDispatcher("/views/admin/QuaTrinhCongTac/QuaTrinhCongTac.jsp").forward(request,response);
    }

    private void xemquatrinhcongtacbanthan(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String MaNV = request.getParameter("MaNV");
        QuaTrinhCongTacService quaTrinhCongTacService = new QuaTrinhCongTacServiceImpl();
        List<ThongTinQuaTrinhCongTac> listttct = new ArrayList<>();
        listttct = quaTrinhCongTacService.Layquatrinhcongtacbanthan(MaNV);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        for (ThongTinQuaTrinhCongTac qtct : listttct) {
            out.println("   <tr>\n" +
                    "                                <td>" + qtct.getNoiDung() + "</td>\n" +
                    "                                <td>" + qtct.getNgayBD() + "</td>\n" +
                    "                                <td>" + qtct.getTenChucVU() + "</td>\n" +
                    "                            </tr>");
        }

    }
}



