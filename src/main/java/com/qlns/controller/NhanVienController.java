package com.qlns.controller;

import com.qlns.dao.UserDao;
import com.qlns.dao.impl.UserDaoImpl;
import com.qlns.model.*;
import com.qlns.service.*;
import com.qlns.service.impl.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@WebServlet("/nhanvien/*")
@MultipartConfig
public class NhanVienController extends HttpServlet {
    private UserService userService;
    private PhongbanService pb;
    private LuongSerrvice luong;
    private ChucVuService cv;
    private TrinhDoService td ;
    @Override
    public void init(){
        pb = new PhongbanServiceImp();
        luong = new LuongServiceImpl();
        cv = new ChucVuServiceImlp();
        td = new TrinhDoServiceImpl();
        userService = new UserServiceImp();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String relativePath = uri.substring(contextPath.length() + "/nhanvien".length());
        try{
            switch (relativePath){
                case "/":
                    XemDanhSach(request,response);
                    break;
                case "/themnhanvien":
                    ThemNhanVien(request,response);
                    break;
                case "/thongtin":
                    XemNhanVien(request,response);
                    break;
                default:
                    response.sendRedirect(request.getContextPath()+"/error/error.jsp");
                    break;
            }
        }catch (Exception ex){
            System.out.print(ex);
        }


    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    public void XemDanhSach(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {

        HttpSession session = request.getSession();
        TaiKhoan tk = (TaiKhoan)session.getAttribute("account");
        Thongtinnhanvien user = userService.laythongtincanhan(tk.getMaNV());
        request.setAttribute("user", user);
        List<Thongtinnhanvien> listnv = null;
        if(tk.getUserRole().equals("admin")){
            listnv = userService.laydanhsachnhanvienadmin();
        }
        else {
            if (tk.getUserRole().equals("giamdoc")) {
                listnv = userService.laydanhsachnhanviengiamdoc(tk.getMaNV());
            } else {
                if (tk.getUserRole().equals("truongphong")) {
                    listnv = userService.laydanhsachnhanvientruongphong(tk.getMaNV());
                } else {
//                    listpb = (List<PhongBan>) pbService.layphongbanthanquanly(tk.getMaNV());
                }
            }
        }
        request.setAttribute("listnv",listnv);
        request.getRequestDispatcher("/views/admin/QLNhanVien/XemNhanVien.jsp").forward(request,response);
    }
    public void ThemNhanVien(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, ParseException {
        if (request.getMethod().equals("GET")) {
            request.setAttribute("lstPB",pb.getPhongBan());
            request.setAttribute("lstLuong",luong.getLuong());
            request.setAttribute("lstCV",cv.getChucVu());
            request.setAttribute("lstTD",td.getTrinhDo());
            request.getRequestDispatcher("/views/admin/QLNhanVien/ThemNhanVien.jsp").forward(request, response);
        } else {
                Part part = request.getPart("image");
                NhanVien nv = getNV(request,response);
                UserService user = new UserServiceImp();
                if(user.themnhanvien(nv)){
                    String realpath = request.getServletContext().getRealPath("/uploads");
                    if(!Files.exists(Paths.get(realpath))){
                        System.out.println("khoi  tao thanh cong"+ realpath);
                        Files.createDirectories(Paths.get(realpath));
                    }
                    part.write(realpath+"/"+nv.getHinhAnh());
                    response.setContentType("text/html");
                    PrintWriter out = response.getWriter();
                    out.println("<h1>day la file</h1>");
                    try{
                        out.println("<img src='"+request.getContextPath()+"/uploads/"+nv.getHinhAnh()+"'>");
                    }catch (Exception e){}
                }
        }
    }

    public void XemNhanVien(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, ParseException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String manv = request.getParameter("manv");
        UserService user = new UserServiceImp();
        if (request.getMethod().equals("GET")) {
            Thongtinnhanvien ttnv = user.laythongtincanhan(manv);
            request.setAttribute("lstPB",pb.getPhongBan());
            request.setAttribute("lstLuong",luong.getLuong());
            request.setAttribute("lstCV",cv.getChucVu());
            request.setAttribute("lstTD",td.getTrinhDo());
            request.setAttribute("ttnv", ttnv);
            request.getRequestDispatcher("/views/admin/QLThongTinCaNhan/ThongTinCaNhan.jsp").forward(request, response);
        }else{
            Part part = request.getPart("image");
            NhanVien nv = getNV(request,response);
            nv.setMaNV(manv);
            if(user.UpdateNV(nv)){
                    response.setContentType("text/html");
                    PrintWriter out = response.getWriter();
                    out.println("<h1>Them thanh cong</h1>");

            }
        }

    }
    private NhanVien getNV(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, ParseException{

        String hoten = request.getParameter("tnv-hovaten");
        String cmnd = request.getParameter("tnv-cmnd");
        String diachi = request.getParameter("tnv-diachi");
        String sdt = request.getParameter("tnv-sdt");
        LocalDate namsinh = LocalDate.parse(request.getParameter("tnv-ngaysinh"));
        String gioitinh = request.getParameter("gender");
        String maphongban = request.getParameter("tnv-maphongban");
        int idbacluong = Integer.parseInt(request.getParameter("tnv-idbacluong"));
        int idchucvu = Integer.parseInt(request.getParameter("tnv-idchucvu"));
        int idtrinhdo = Integer.parseInt(request.getParameter("tnv-idtrinhdo"));
        Part part = request.getPart("image");
        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        return new NhanVien(maphongban,idbacluong,idchucvu,idtrinhdo,hoten,cmnd,diachi,filename,sdt,namsinh,gioitinh);
    }

}