package com.example.asus.projectfinish;

/**
 * Created by user on 15/05/2018.
 */

public class Barang {
    public String namabarang;
    public String harga;
    public int thumbnail;

    public Barang() {
    }

    public Barang(String namabarang, String harga, int thumbnail) {
        this.namabarang = namabarang;
        this.harga = harga;
        this.thumbnail = thumbnail;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public String getHarga() {
        return harga;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }


}
