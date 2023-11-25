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
}
