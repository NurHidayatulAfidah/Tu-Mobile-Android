package com.example.asus.projectfinish;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Asus on 06/06/2018.
 */

public class form_pemesanan extends AppCompatActivity{
    TextView id_pemesanan, nama_brg, id_brg, hrg, total_hrg;
    EditText jumlah, alamat;
    Button btn_pesan;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_pemesanan);

        id_pemesanan = (TextView) findViewById(R.id.id_pemesanan);
        nama_brg = (TextView) findViewById(R.id.nama_barang);
        jumlah = (EditText) findViewById(R.id.jumlah);
        alamat = (EditText) findViewById(R.id.alamat);
        btn_pesan = (Button) findViewById(R.id.btn_pesan);
        id_brg = (TextView) findViewById(R.id.id_brg);
        hrg = (TextView) findViewById(R.id.hrg_satuan);
        total_hrg = (TextView) findViewById(R.id.hrg_total);

    }
}
