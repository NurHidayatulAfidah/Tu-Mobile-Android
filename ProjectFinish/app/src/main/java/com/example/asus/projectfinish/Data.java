package com.example.asus.projectfinish;

/**
 * Created by Asus on 07/06/2018.
 */

public class Data {
    private String ID_BARANG, NAMA_BARANG, HARGA_SATUAN, JUMLAH;

    public Data() {
    }

    public Data(String id_barang, String nama_barang, String harga_satuan, String jumlah) {
        this.ID_BARANG = id_barang;
        this.NAMA_BARANG = nama_barang;
        this.HARGA_SATUAN = harga_satuan;
        this.JUMLAH = jumlah;
    }

    public String getID_BARANG() {
        return ID_BARANG;
    }

    public void setID_BARANG(String id_barang) {
        this.ID_BARANG = id_barang;
    }

    public String getNAMA_BARANG() {
        return NAMA_BARANG;
    }

    public void setNAMA_BARANG(String nama_barang) {
        this.NAMA_BARANG = nama_barang;
    }

    public String getHARGA_SATUAN() {
        return HARGA_SATUAN;
    }

    public void setHARGA_SATUAN(String harga_satuan) {
        this.HARGA_SATUAN = harga_satuan;
    }

    public String getJUMLAH() {
        return JUMLAH;
    }

    public void setJUMLAH(String jumlah) {
        this.JUMLAH = jumlah;
    }
}
