package com.qlns.controller;

import com.qlns.model.ThongTinPhongBan;
import com.qlns.model.ThongTinQuaTrinhCongTac;
import com.qlns.service.PhongbanService;
import com.qlns.service.QuaTrinhCongTacService;
import com.qlns.service.impl.PhongbanServiceImp;
import com.qlns.service.impl.QuaTrinhCongTacServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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



