package com.qlns.service;

import com.qlns.model.*;

import java.util.List;

public interface UserService {

    Thongtinnhanvien laythongtincanhan(String MaNV);
    boolean themnhanvien(NhanVien nv);
    List<Thongtinnhanvien> laydanhsachnhanvienadmin();
    List<Thongtinnhanvien> laydanhsachnhanviengiamdoc(String MaGiamDoc);
    List<Thongtinnhanvien> laydanhsachnhanvientruongphong(String MaTruongPhong);

    List<Thongtinnhanvien> laydanhsachnhanvientheophongban(String MaPB);



    Boolean UpdateNV(NhanVien nv);
    List<KThuongKLuc> getKThuongKLuat();
    List<KThuongKLuc> getKThuongKLuat(String manv);

    List<PhongBan> getPhongBan();
    List<Luong> getLuong();
    List<ChucVu> getChucVu();
    List<TrinhDo> getTrinHDo();
    public boolean capnhatnhanvientruockhilenchuc(String manv, String mapb,int bacluong,int chucvu);


}
