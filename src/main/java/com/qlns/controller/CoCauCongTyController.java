package com.qlns.controller;

import com.qlns.dao.UserDao;
import com.qlns.dao.impl.UserDaoImpl;
import com.qlns.model.ChiNhanh;
import com.qlns.model.PhongBan;
import com.qlns.model.ThongTinPhongBan;
import com.qlns.model.Thongtinnhanvien;
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
import java.util.List;

@WebServlet("/cocaucongty/*")
public class CoCauCongTyController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String relativePath = uri.substring(contextPath.length() + "/cocaucongty".length());
        try{
            switch (relativePath){
                case "/":
                    xemcocaucongty(request,response);
                    break;
                case "/phongbancha":
                    phongbancha(request,response);
                    break;
                default:
                    response.sendRedirect(request.getContextPath()+"/error/error.jsp");
                    break;
            }
        }catch (Exception ex){
            System.out.print(ex);
        }


    }

    private void phongbancha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String MaCN = request.getParameter("MaCN");
        PhongbanService PhongbanService = new PhongbanServiceImp();
        List<ThongTinPhongBan> listpbcc = PhongbanService.laydanhsachphongbantheomacn(MaCN);



        PrintWriter out = response.getWriter();
        for (ThongTinPhongBan pb : listpbcc) {
            out.println("<h3><i class=\"fa-solid fa-arrow-right icon-arrow icon-2\"></i>"+pb.getTenPB()+"</h3>");


        }
    }

    private void xemcocaucongty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChiNhanhService chiNhanhService = new ChiNhanhServiceImp();
        PhongbanService phongbanService = new PhongbanServiceImp();
        UserService userService = new UserServiceImp();

        List<ChiNhanh> listcn = chiNhanhService.danhsachchinhanh();
        request.setAttribute("listcncc",listcn);

        request.getRequestDispatcher("/views/admin/CoCauCongTy/CoCauCongTy.jsp").forward(request,response);


    }

}
