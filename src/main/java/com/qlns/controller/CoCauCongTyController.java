package com.qlns.controller;

import com.qlns.model.ChiNhanh;
import com.qlns.model.HopDong;
import com.qlns.model.PhongBan;
import com.qlns.model.TaiKhoan;
import com.qlns.service.ChiNhanhService;
import com.qlns.service.CoCauCongTyService;
import com.qlns.service.impl.ChiNhanhServiceImp;
import com.qlns.service.impl.CoCauCongTyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cocaucongty/*")

public class CoCauCongTyController extends HttpServlet {
    private CoCauCongTyService ctcy;
   public void init(){
        ctcy = new  CoCauCongTyServiceImpl();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String relativePath = uri.substring(contextPath.length() +"/cocaucongty".length());
        try{
            switch (relativePath){
                case "/":
                    request.getRequestDispatcher("/views/admin/CoCauCongTy/CoCauCongTy.jsp").forward(request,response);
                    break;
                case "/chinhanh":
                    getChiNhanh(request,response);
                    break;
                case "/pbcha":
                    getPBCha(request,response);
                    break;
                case "/pbcon":
                    getPBCon(request,response);
                    break;
                default:
                    response.sendRedirect(request.getContextPath()+"/error/error.jsp");
                    break;
            }
        }catch (Exception ex){
            System.out.print(ex);
        }
    }

    private void getChiNhanh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       List<ChiNhanh> lstCN = ctcy.getCN();
        StringBuilder jsonString = new StringBuilder();
        jsonString.append("[");

        for (ChiNhanh cn : lstCN) {
            jsonString.append("{");
            jsonString.append("\"macn\": \"").append(cn.getMaCN()).append("\",");
            jsonString.append("\"tencn\": \"").append(cn.getTenChiNhanh()).append("\"");
            jsonString.append("},");
        }

        if (!lstCN.isEmpty()) {
            jsonString.deleteCharAt(jsonString.length() - 1); // Remove the last comma
        }

        jsonString.append("]");
        response.setCharacterEncoding("UTF8");
        response.setContentType("application/json");
        response.getWriter().println(jsonString);
        response.setStatus(HttpServletResponse.SC_ACCEPTED);

    }
    private void getPBCha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String macn  = request.getParameter("macn");
        List<PhongBan> lstPB = ctcy.getPBCha(macn);
        StringBuilder jsonString = new StringBuilder();
        jsonString.append("[");

        for (PhongBan pb : lstPB) {
            jsonString.append("{");
            jsonString.append("\"mapbcha\": \"").append(pb.getMaPB()).append("\",");
            jsonString.append("\"tenpbcha\": \"").append(pb.getTenPB()).append("\"");
            jsonString.append("},");
        }

        if (!lstPB.isEmpty()) {
            jsonString.deleteCharAt(jsonString.length() - 1); // Remove the last comma
        }

        jsonString.append("]");
        response.setCharacterEncoding("UTF8");
        response.setContentType("application/json");
        response.getWriter().println(jsonString);
        response.setStatus(HttpServletResponse.SC_ACCEPTED);

    }
    private void getPBCon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mapbcha  = request.getParameter("mapbcha");
        List<PhongBan> lstPB = ctcy.getPBCon(mapbcha);
        StringBuilder jsonString = new StringBuilder();
        jsonString.append("[");

        for (PhongBan pb : lstPB) {
            jsonString.append("{");
            jsonString.append("\"mapbcon\": \"").append(pb.getMaPB()).append("\",");
            jsonString.append("\"tenpbcon\": \"").append(pb.getTenPB()).append("\"");
            jsonString.append("},");
        }

        if (!lstPB.isEmpty()) {
            jsonString.deleteCharAt(jsonString.length() - 1); // Remove the last comma
        }

        jsonString.append("]");
        response.setCharacterEncoding("UTF8");
        response.setContentType("application/json");
        response.getWriter().println(jsonString);
        response.setStatus(HttpServletResponse.SC_ACCEPTED);

    }
}
