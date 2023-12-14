package com.qlns.controller;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.qlns.dao.UserDao;
import com.qlns.dao.impl.UserDaoImpl;
import com.qlns.model.*;
import com.qlns.service.*;
import com.qlns.service.impl.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@WebServlet("/nhanvien/*")
@MultipartConfig
public class NhanVienController extends HttpServlet {
    private UserService userService;
    private PhongbanService pb;
    private LuongSerrvice luong;
    private ChucVuService cv;
    private TrinhDoService td;
    private DuAnService duAnService;

    @Override
    public void init() {
        pb = new PhongbanServiceImp();
        luong = new LuongServiceImpl();
        cv = new ChucVuServiceImlp();
        td = new TrinhDoServiceImpl();
        userService = new UserServiceImp();
        duAnService = new DuAnServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String relativePath = uri.substring(contextPath.length() + "/nhanvien".length());
        if (relativePath.startsWith("/hopdong")) {
            XuLyHopDong(request, response);
            return;
        }
        if (relativePath.startsWith("/duan")) {
            XuLyDuAn(request, response);
            return;
        }
        if (relativePath.startsWith("/khenthuongkyluat")) {
            XuLyKTKL(request, response);
            return;
        }

        try {
            switch (relativePath) {
                case "/":
                    XemDanhSach(request, response);
                    break;
                case "/xoa":
                    XoaNhanhVien(request, response);
                case "/themnhanvien":

                    ThemNhanVien(request,response);
                    break;
                case "/thongtin":
                    XemNhanVien(request, response);
                    break;
                case "/duan":
                    XemDuAn(request, response);
                    break;
                case "/duan/chitiet":
                    DuAnChitiet(request, response);
                    break;
                default:
                    response.sendRedirect(request.getContextPath() + "/error/error.jsp");
                    break;
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void XemDanhSach(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        TaiKhoan tk = (TaiKhoan) session.getAttribute("account");
        Thongtinnhanvien user = userService.laythongtincanhan(tk.getMaNV());
        request.setAttribute("user", user);
        List<Thongtinnhanvien> listnv = null;
        if (tk.getUserRole().equals("admin")) {
            listnv = userService.laydanhsachnhanvienadmin();
        } else {
            response.sendRedirect(request.getContextPath()+"/nhanvien/thongtin?manv="+tk.getMaNV());
        }
        request.setAttribute("listnv", listnv);
        request.getRequestDispatcher("/views/admin/QLNhanVien/XemNhanVien.jsp").forward(request, response);
    }

    public void XoaNhanhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession(false);
        TaiKhoan tk = (TaiKhoan) session.getAttribute("account");
        if(tk == null){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return ;
        }
        if(!tk.getUserRole().equals("admin")){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return ;
        }
        String manv = request.getParameter("manv");
        if (manv == null || manv.isEmpty()){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        boolean  status = userService.xoaNV(manv);
        if (status) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
    public void UpLoadFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {

        Part part = request.getPart("fileexcel");
        try (InputStream fileContent = part.getInputStream();
             CSVReader csvReader = new CSVReaderBuilder(new StringReader(convertStreamToString(fileContent)))
                     .withSkipLines(1)
                     .build()) {
            List<String[]> allData = csvReader.readAll();
            List<NhanVien> lstNV = new ArrayList<>();
            for (String[] row : allData) {
                NhanVien nv = new NhanVien();
                nv.setMaPB(row[0]);
                nv.setIdBacLuong(Integer.parseInt(row[1]));
                nv.setIdChucVu(Integer.parseInt(row[2]));
                nv.setIdTrinhDo(Integer.parseInt(row[3]));
                nv.setHoTen(row[4]);
                nv.setCCCD(row[5]);
                nv.setDiaChi(row[6]);
                nv.setHinhAnh(row[7].isEmpty() ? null : row[7]);
                nv.setSdt(row[8]);
                String dateString = row[9];
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                nv.setNamSinh(LocalDate.parse(dateString, dateFormatter));
                nv.setGioiTinh(row[10]);
                lstNV.add(nv);
            }
            List<Boolean> lstCheck = new ArrayList<>();
            UserService user = new UserServiceImp();
            for (NhanVien nv : lstNV) {
                lstCheck.add(user.themnhanvien(nv));
            }

            String alert = "Thêm thành công!!!";
            if (lstCheck.contains(false)) {
                StringBuilder alertMessage = new StringBuilder("Không thêm được các dòng. Dòng không thành công: ");
                for (int i = 0; i < lstCheck.size(); i++) {
                    if (!lstCheck.get(i)) {
                        alertMessage.append(i).append(", ");
                    }
                }
                if (alertMessage.length() > 0) {
                    alertMessage.setLength(alertMessage.length() - 2);
                }
            }
            response.setContentType("text/plain");
            response.getWriter().println(alert);
            response.setStatus(HttpServletResponse.SC_ACCEPTED);

            // response.setContentType();
        } catch (Exception e) {
            response.setContentType("text/plain");
            response.getWriter().println("them khong thanh cong");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            e.printStackTrace();
            // Xử lý lỗi khi đọc CSV
        }
    }

    public void ThemNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        response.setCharacterEncoding("UTF-8");
        if (request.getMethod().equals("GET")) {
            request.setAttribute("lstPB", pb.getPhongBan());
            request.setAttribute("lstLuong", luong.getLuong());
            request.setAttribute("lstCV", cv.getChucVu());
            request.setAttribute("lstTD", td.getTrinhDo());
            request.getRequestDispatcher("/views/admin/QLNhanVien/ThemNhanVien.jsp").forward(request, response);
        } else {
            Part upload = request.getPart("fileexcel");
            if (upload != null) {
                String fileName = getFileName(upload);
                if (fileName != null && (fileName.endsWith(".csv") || fileName.endsWith(".xlsx"))) {
                    UpLoadFile(request, response);
                    return;
                } else {
                    response.getWriter().write("Invalid file format. Please upload an Excel file.");
                    return;
                }
            }
            Part part = request.getPart("image");
            NhanVien nv = getNV(request, response);
            UserService user = new UserServiceImp();
            if (user.themnhanvien(nv)) {
                String realpath = request.getServletContext().getRealPath("/uploads");
                if (!Files.exists(Paths.get(realpath))) {
                    System.out.println("khoi  tao thanh cong" + realpath);
                    Files.createDirectories(Paths.get(realpath));
                }
//                part.write(realpath + "/" + nv.getHinhAnh());
//                response.setContentType("text/html");
//                PrintWriter out = response.getWriter();
//                out.println("<h1>day la file</h1>");
//                try {
//                    out.println("<img src='" + request.getContextPath() + "/uploads/" + nv.getHinhAnh() + "'>");
//                } catch (Exception e) {
//                }
                request.setAttribute("TrangThai","Them thanh cong");
                request.getRequestDispatcher("/views/admin/QLNhanVien/ThemNhanVien.jsp").forward(request,response);
            }
            request.setAttribute("TrangThai","Them that bai");
            request.getRequestDispatcher("/views/admin/QLNhanVien/ThemNhanVien.jsp").forward(request,response);
        }
    }

    private String getFileName(Part part) {
        for (String contentDisposition : part.getHeader("content-disposition").split(";")) {
            if (contentDisposition.trim().startsWith("filename")) {
                return contentDisposition.substring(contentDisposition.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    private String convertStreamToString(InputStream is) {
        Scanner scanner = new Scanner(is, "UTF-8").useDelimiter("\\A");
        return scanner.hasNext() ? scanner.next() : "";
    }

    public void XemNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String manv = request.getParameter("manv");
        UserService user = new UserServiceImp();
        if (request.getMethod().equals("GET")) {
            Thongtinnhanvien ttnv = user.laythongtincanhan(manv);
            request.setAttribute("lstPB", pb.getPhongBan());
            request.setAttribute("lstLuong", luong.getLuong());
            request.setAttribute("lstCV", cv.getChucVu());
            request.setAttribute("lstTD", td.getTrinhDo());
            request.setAttribute("ttnv", ttnv);
            request.getRequestDispatcher("/views/admin/QLThongTinCaNhan/ThongTinCaNhan.jsp").forward(request, response);
        } else {
            Part part = request.getPart("image");
            NhanVien nv = getNV(request, response);
            nv.setMaNV(manv);
            if (user.UpdateNV(nv)) {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<h1>Them thanh cong</h1>");

            }
        }

    }

    private NhanVien getNV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {

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
        return new NhanVien(maphongban, idbacluong, idchucvu, idtrinhdo, hoten, cmnd, diachi, filename, sdt, namsinh, gioitinh);
    }
    public void KThuongKLuc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        // String maNV = request.getParameter("manv");
        HttpSession session = request.getSession();
        TaiKhoan tk = (TaiKhoan) session.getAttribute("account");
        List<KThuongKLuc> lstKtkl = null;
        if (tk != null && tk.getUserRole().equals("admin")) {
            lstKtkl = userService.getKThuongKLuat();
        }
        else {
            if (tk != null && tk.getUserRole().equals("giamdoc")) {
                lstKtkl= userService.getKThuongKLuatgiamdoc(tk.getMaNV());
            }
            else {
                if (tk != null && tk.getUserRole().equals("truongphong"))
                {
                    lstKtkl= userService.getKThuongKLuattruongphong(tk.getMaNV());
                    if (tk != null && tk.getUserRole().equals("totruong"))
                    {
                        lstKtkl= userService.getKThuongKLuattotruong(tk.getMaNV());

                    }
                    else  lstKtkl=null;
                }

            }
        }

        request.setAttribute("lstKtkl",lstKtkl);
        request.getRequestDispatcher("/views/admin/KhenThuong-KyLuat/KhenThuong-KyLuat.jsp").forward(request,response);
    }
    public void XuLyHopDong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String startRoute = "/hopdong";
        String action = request.getPathInfo().substring(startRoute.length());
        System.out.println(action);

        switch (action) {
            case "":
                request.getRequestDispatcher("/views/admin/QLHopDong/DanhSachHopDong.jsp").forward(request, response);
                break;
            case "/danhsach":
                XemDanhSachHopDong(request, response);
                break;
            case "/them":
                ThemHopDong(request, response);
                break;
            case "/sua":
                CapNhathopDong(request, response);
                break;
            case "/xoa":
                XoaHopDong(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath()+"/error/error.jsp");
                break;
        }
    }
    public void XemDanhSachHopDong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HopDongService hopDongService = new HopDongServiceImpl();
        HttpSession session = request.getSession();
        TaiKhoan tk = (TaiKhoan)session.getAttribute("account");
        Thongtinnhanvien user = (Thongtinnhanvien) session.getAttribute("user");
        List<HopDong> lstHopDong = new ArrayList<>();
        if(tk.getUserRole().equals("admin")){
            lstHopDong = hopDongService.findAll();;
        }
        else {
            if (user.getIDChucVu()==1) {
                lstHopDong =  hopDongService.findhopdongtheogiamdoc(tk.getMaNV());
            } else {
                if (user.getIDChucVu()==2) {
                    lstHopDong = hopDongService.findhopdongtheotruongphong(tk.getMaNV());
                } else {
                    if(user.getIDChucVu()==3) {
                        lstHopDong =  hopDongService.findhopdongtheototruong(tk.getMaNV());
                    }
                    else
                        response.sendRedirect(request.getContextPath()+"/nhanvien/thongtin?manv="+tk.getMaNV());
                }
            }
        }
        response.setCharacterEncoding("UTF-8");
        //Parse to JSON
        StringBuilder jsonString = new StringBuilder();
        jsonString.append("[");

        for (HopDong hopDong : lstHopDong) {
            jsonString.append("{");
            jsonString.append("\"maHopDong\": \"").append(hopDong.getMaHopDong()).append("\",");
            jsonString.append("\"maNV\": \"").append(hopDong.getMaNV()).append("\",");
            jsonString.append("\"ngayBD\": \"").append(hopDong.getNgayBD()).append("\",");
            jsonString.append("\"ngayKT\": \"").append(hopDong.getNgayKT()).append("\",");
            jsonString.append("\"noiDung\": \"").append(hopDong.getNoidung()).append("\"");
            jsonString.append("},");
        }

        if (!lstHopDong.isEmpty()) {
            jsonString.deleteCharAt(jsonString.length() - 1); // Remove the last comma
        }

        jsonString.append("]");

        response.setContentType("application/json");
        response.getWriter().println(jsonString);
        response.setStatus(HttpServletResponse.SC_ACCEPTED);

    }

    public void ThemHopDong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maHopDong = request.getParameter("maHopDong");
        String maNV = request.getParameter("maNV");
        LocalDate ngayBD = LocalDate.parse(request.getParameter("ngayBD"));
        LocalDate ngayKT = LocalDate.parse(request.getParameter("ngayKT"));
        String noiDung = request.getParameter("noiDung");

        HopDong hopDong = new HopDong(maHopDong, maNV, ngayBD, ngayKT, noiDung);
        HopDongService hopDongService = new HopDongServiceImpl();
        int status = hopDongService.themHopDong(hopDong);
        if (status != 0) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    public void CapNhathopDong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maHopDong = request.getParameter("maHopDong");
        String maNV = request.getParameter("maNV");
        LocalDate ngayBD = LocalDate.parse(request.getParameter("ngayBD"));
        LocalDate ngayKT = LocalDate.parse(request.getParameter("ngayKT"));
        String noiDung = request.getParameter("noiDung");

        HopDong hopDong = new HopDong(maHopDong, maNV, ngayBD, ngayKT, noiDung);
        HopDongService hopDongService = new HopDongServiceImpl();
        int status = hopDongService.suaHopDong(maHopDong, hopDong);
        if (status != 0) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    public void XoaHopDong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maHopDong = request.getParameter("maHopDong");
        HopDongService hopDongService = new HopDongServiceImpl();
        int status = hopDongService.xoaHopDong(maHopDong);

        if (status != 0) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    public void ThemChuongTrinh(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("Id"));
        LocalDate ngay = LocalDate.parse(request.getParameter("ngayApDung"));
        String noiDung = request.getParameter("noiDung");
        String soKTKL = request.getParameter("soKTKL");
        int loaiCT = Integer.parseInt(request.getParameter("loaiCT"));
        String maNV = request.getParameter("maNV");
        KThuongKLuc ktkl = new KThuongKLuc(id, maNV, noiDung, ngay, soKTKL, loaiCT);
        KThuongKyLuatService ktklservice = new KThuongKyLuatServiceImpl();
        int status = ktklservice.ThemChuongTrinh(ktkl);
        if (status != 0) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    public void CapNhatChuongTrinh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("Id"));
        LocalDate ngay = LocalDate.parse(request.getParameter("ngayApDung"));
        String noiDung = request.getParameter("noiDung");
        String soKTKL = request.getParameter("soKTKL");
        int loaiCT = Integer.parseInt(request.getParameter("loaiCT"));
        String maNV = request.getParameter("maNV");
        KThuongKLuc ktkl = new KThuongKLuc(id, maNV, noiDung, ngay, soKTKL, loaiCT);
        KThuongKyLuatService ktklservice = new KThuongKyLuatServiceImpl();
        int status = ktklservice.CapNhatChuongTrin(ktkl);
        if (status != 0) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    public void XoaChuongTrinh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("Id"));
        LocalDate ngay = LocalDate.parse(request.getParameter("ngayApDung"));
        String noiDung = request.getParameter("noiDung");
        String soKTKL = request.getParameter("soKTKL");
        int loaiCT = Integer.parseInt(request.getParameter("loaiCT"));
        String maNV = request.getParameter("maNV");
        KThuongKLuc ktkl = new KThuongKLuc(id, maNV, noiDung, ngay, soKTKL, loaiCT);
        KThuongKyLuatService ktklservice = new KThuongKyLuatServiceImpl();
        int status = ktklservice.XoaChuongTrinh(ktkl);
        if (status != 0) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    public void XuLyKTKL(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        final String startRoute = "/khenthuongkyluat";

        String action = request.getPathInfo().substring(startRoute.length());
        System.out.println(action);

        switch (action) {
            case "":
                request.getRequestDispatcher("/views/admin/KhenThuong-KyLuat/KhenThuong-KyLuat.jsp").forward(request, response);
                break;
            case "/danhsach":
                XemKThuongKLuc(request, response);
                break;
            case "/them":
                ThemChuongTrinh(request, response);
                break;
            case "/sua":
                CapNhatChuongTrinh(request, response);
                break;
            case "/xoa":
                XoaChuongTrinh(request, response);
                break;
            default:
        }
    }

    public void XemKThuongKLuc(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
        // String maNV = request.getParameter("manv");
        HttpSession session = request.getSession();
        TaiKhoan tk = (TaiKhoan)session.getAttribute("account");
        Thongtinnhanvien user = (Thongtinnhanvien)session.getAttribute("user");
        List<KThuongKLuc> lstKtkl = null;
        if(tk!= null && tk.getUserRole().equals("admin")){
            lstKtkl = userService.getKThuongKLuat();
        }
        else {
            if (user.getIDChucVu()==1) {
                lstKtkl =  userService.getKThuongKLuatgiamdoc(tk.getMaNV());
            } else {
                if (user.getIDChucVu()==2) {
                    lstKtkl = userService.getKThuongKLuattruongphong(tk.getMaNV());
                } else {
                    if(user.getIDChucVu()==3) {
                        lstKtkl =  userService.getKThuongKLuattotruong(tk.getMaNV());
                    }
                    else
                        response.sendRedirect(request.getContextPath()+"/nhanvien/thongtin?manv="+tk.getMaNV());
                }
            }
        }

        StringBuilder jsonString = new StringBuilder();
        jsonString.append("[");

        for (KThuongKLuc kt : lstKtkl) {
            jsonString.append("{");
            jsonString.append("\"id\": \"").append(kt.getId()).append("\",");
            jsonString.append("\"maNV\": \"").append(kt.getMaNV()).append("\",");
            jsonString.append("\"noiDung\": \"").append(kt.getNoiDung()).append("\",");
            jsonString.append("\"Ngay\": \"").append(kt.getNgay()).append("\",");
            jsonString.append("\"soKT_KL\": \"").append(kt.getSoKT_KL()).append("\",");
            jsonString.append("\"loai\": \"").append(kt.getLoai()).append("\"");
            jsonString.append("},");
    }

        if (!lstKtkl.isEmpty()) {
            jsonString.deleteCharAt(jsonString.length() - 1); // Remove the last comma
        }

        jsonString.append("]");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(jsonString);
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
    }
    public void XemDuAn (HttpServletRequest request, HttpServletResponse response) throws
    ServletException, IOException {

        List<DuAn> lstDA = duAnService.getDuAn();
        request.setAttribute("lstDA", lstDA);

        request.getRequestDispatcher("/views/admin/QLDuAn/DanhSachDuAn.jsp").forward(request, response);
    }
    public void XuLyDuAn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String startRoute = "/duan";
        String action = request.getPathInfo().substring(startRoute.length());
        System.out.println(action);

        if (action.startsWith("/chitiet")) {
            XuLyChiTietDuAn(request, response);
            return;
        }

        switch (action) {
            case "":
                request.getRequestDispatcher("/views/admin/QLDuAn/DanhSachDuAn.jsp").forward(request, response);
                break;
            case "/danhsach":
                XemDanhSachDuAn(request, response);
                break;
            case "/them":
                ThemDuAn(request, response);
                break;
            case "/sua":
                CapNhatDuAn(request, response);
                break;
            case "/xoa":
                XoaDuAn(request, response);
                break;
            default:
        }
    }

    public void ThemDuAn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maDuAn = request.getParameter("maDuAn");
        String tenDuAn = request.getParameter("tenDuAn");
        String trangThai = request.getParameter("trangThai");

        DuAn duAn = new DuAn(maDuAn, tenDuAn, trangThai);
        int status = duAnService.themDuAn(duAn);
        if (status != 0) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    public void CapNhatDuAn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maDuAnOld = request.getParameter("maDuAnCu");
        String maDuAnNew = request.getParameter("maDuAnMoi");
        String tenDuAn = request.getParameter("tenDuAn");
        String trangThai = request.getParameter("trangThai");

        DuAn duAn = new DuAn(maDuAnNew, tenDuAn, trangThai);

        int status = duAnService.suaByMaDuAn(maDuAnOld, duAn);

        if (status != 0) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    public void XoaDuAn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maDuAn = request.getParameter("maDuAn");

        int status = duAnService.xoaByMaDuAn(maDuAn);

        if (status != 0) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    public void XemDanhSachDuAn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<DuAn> lstDA = new ArrayList<>();

        HttpSession session = request.getSession();
        TaiKhoan tk = (TaiKhoan)session.getAttribute("account");

        if(tk.getUserRole().equals("admin"))
        {
                 lstDA = duAnService.getDuAn();
        }
        else
        {
            lstDA = duAnService.DuAnNhanVienthamgia(tk.getMaNV());
        }

        //Parse to JSON
        StringBuilder jsonString = new StringBuilder();
        jsonString.append("[");

        for (DuAn duAn : lstDA) {
            jsonString.append("{");
            jsonString.append("\"maDuAn\": \"").append(duAn.getMaDuAn()).append("\",");
            jsonString.append("\"tenDuAn\": \"").append(duAn.getTenDuAn()).append("\",");
            jsonString.append("\"trangThai\": \"").append(duAn.getTrangThai()).append("\"");
            jsonString.append("},");
        }

        if (!lstDA.isEmpty()) {
            jsonString.deleteCharAt(jsonString.length() - 1); // Remove the last comma
        }

        jsonString.append("]");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(jsonString);
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
    }

    public void XuLyChiTietDuAn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String startRoute = "/duan/chitiet";
        System.out.println(request.getPathInfo());
        String action = request.getPathInfo().substring(startRoute.length());
        System.out.println(action);

        switch (action) {
            case "":
                request.getRequestDispatcher("/views/admin/QLDuAn/NhanVien_DuAn.jsp").forward(request, response);
                break;
            case "/danhsach":
                DuAnChitiet(request, response);
                break;
            case "/them":
                ThemNhanVienVaoDuAn(request, response);
                break;
            case "/sua":
                CapNhatNhanVienTrongDuAn(request, response);
                break;
            case "/xoa":
                XoaNhanVienKhoiDuAn(request, response);
                break;
            default:
        }
    }

    public void DuAnChitiet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maDA = request.getParameter("maduan");
        if (maDA == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        List<DANhanVien> lstDanv = duAnService.getChiTietDA(maDA);



        //Parse to JSON
        StringBuilder jsonString = new StringBuilder();
        jsonString.append("[");

        for (DANhanVien daNhanVien : lstDanv) {
            jsonString.append("{");
            jsonString.append("\"maDuAn\": \"").append(daNhanVien.getMaDA()).append("\",");
            jsonString.append("\"tenDuAn\": \"").append(daNhanVien.getTenDA()).append("\",");
            jsonString.append("\"maNV\": \"").append(daNhanVien.getMaNV()).append("\",");
            jsonString.append("\"trangThaiLamViec\": \"").append(daNhanVien.getTrangThaiLamViec()).append("\"");
            jsonString.append("},");
        }

        if (!lstDanv.isEmpty()) {
            jsonString.deleteCharAt(jsonString.length() - 1); // Remove the last comma
        }

        jsonString.append("]");

        System.out.println(jsonString);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(jsonString);
        response.setStatus(HttpServletResponse.SC_ACCEPTED);

    }
    public void ThemNhanVienVaoDuAn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maDuAn = request.getParameter("maDuAn");
        String maNV = request.getParameter("maNV");
        String trangThaiLamViec = request.getParameter("trangThaiLamViec");

        DANhanVien daNhanVien = new DANhanVien();
        daNhanVien.setMaNV(maNV);
        daNhanVien.setTrangThaiLamViec(trangThaiLamViec);

        int status = duAnService.themNhanVienVaoDuAn(maDuAn, daNhanVien);

        if (status != 0) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
    public void CapNhatNhanVienTrongDuAn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maDuAn = request.getParameter("maDuAn");
        String maNV = request.getParameter("maNV");
        String trangThaiLamViec = request.getParameter("trangThaiLamViec");

        DANhanVien daNhanVien = new DANhanVien();
        daNhanVien.setMaNV(maNV);
        daNhanVien.setTrangThaiLamViec(trangThaiLamViec);

        int status = duAnService.capnhatNhanVienTrongDuAn(maDuAn, maNV, daNhanVien);

        if (status != 0) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
    public void XoaNhanVienKhoiDuAn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maDuAn = request.getParameter("maDuAn");
        String maNV = request.getParameter("maNV");

        int status = duAnService.xoaNhanVienKhoiDuAn(maDuAn, maNV);

        if (status != 0) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

}