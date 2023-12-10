package com.qlns.controller;


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
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/XemPhongBan","/xemphongbancon","/xemphongbancha"})
public class XemPhongBanController extends HttpServlet {
    @Override
    protected  void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException, ServletException {
        String action = req.getServletPath();
        try {
            switch (action) {
                case "/XemPhongBan":
                    xemphongban(req, resp);
                    break;
                case "/xemphongbancon":
                    xemphongbancon(req, resp);
                    break;
                case "/xemphongbancha":
                    xemphongbancha(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
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
                   listpb = null;
                }
            }
        }
        session.setAttribute("listpb",listpb);
        //response.sendRedirect(request.getContextPath()+"/views/admin/QLPhongBan/DanhSachPhongBan.jsp");
        request.getRequestDispatcher("/views/admin/QLPhongBan/DanhSachPhongBan.jsp").forward(request,response);
    }
    private void xemphongbancon(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
        String MaPB = req.getParameter("MaPB");
        PhongbanService phongbanService = new PhongbanServiceImp();
        List<ThongTinPhongBan> listpbcon = new ArrayList<>();
        listpbcon = phongbanService.laydanhsachphongbancontuphongbancha(MaPB);
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        for (ThongTinPhongBan pb : listpbcon) {
            out.println("<div class=\"col-6 phongban-item--container\">\n" +
                    "                                            <div class=\"phongban-item\" onclick=\"handleItemClick('"+pb.getTenPB()+"', '"+pb.getMaPB()+"', '"+pb.getTenChiNhanh()+"', '"+pb.getTenChiNhanh()+"', '"+pb.getNgayBD()+"')\">\n" +
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
                    "                                                <div class=\"phongban-item\" onclick=\"handleItemClick('"+pb.getTenPB()+"', '"+pb.getMaPB()+"', '"+pb.getTenChiNhanh()+"', '"+pb.getTenChiNhanh()+"', '"+pb.getNgayBD()+"')\">\n" +
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


}
