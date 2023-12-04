package com.qlns.model;

public class TaiKhoan {
    int userID;
    String userName;
    String password;
    String userRole;
    String maNV;

    public TaiKhoan() {
    }

    public TaiKhoan(String userName, String password, String userRole, String maNV) {
        this.userName = userName;
        this.password = password;
        this.userRole = userRole;
        this.maNV = maNV;
    }

    public TaiKhoan(int userID, String userName, String password, String userRole, String maNV) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.userRole = userRole;
        this.maNV = maNV;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
}
