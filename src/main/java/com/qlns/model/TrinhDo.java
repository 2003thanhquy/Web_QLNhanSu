package com.qlns.model;

public class TrinhDo {
    int idTrinhDo;
    String tenTrinhDo;

    public TrinhDo() {
    }

    public TrinhDo(String tenTrinhDo) {
        this.tenTrinhDo = tenTrinhDo;
    }

    public TrinhDo(int idTrinhDo, String tenTrinhDo) {
        this.idTrinhDo = idTrinhDo;
        this.tenTrinhDo = tenTrinhDo;
    }

    public int getIdTrinhDo() {
        return idTrinhDo;
    }

    public void setIdTrinhDo(int idTrinhDo) {
        this.idTrinhDo = idTrinhDo;
    }

    public String getTenTrinhDo() {
        return tenTrinhDo;
    }

    public void setTenTrinhDo(String tenTrinhDo) {
        this.tenTrinhDo = tenTrinhDo;
    }
}
