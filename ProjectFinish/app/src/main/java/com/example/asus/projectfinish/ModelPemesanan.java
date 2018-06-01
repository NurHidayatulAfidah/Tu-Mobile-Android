package com.example.asus.projectfinish;

/**
 * Created by user on 24/05/2018.
 */

public class ModelPemesanan {

    private int image;
    private String nama, tanggal, jumlah, status;

    public ModelPemesanan(int image, String nama, String tanggal, String jumlah, String status) {
        this.image = image;
        this.nama = nama;
        this.tanggal = tanggal;
        this.jumlah = jumlah;
        this.status = status;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
