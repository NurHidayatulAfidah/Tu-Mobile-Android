package com.example.asus.projectfinish;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import com.android.volley.toolbox.Volley;

public class HomeActivity extends AppCompatActivity {
    private ImageView img_brng;
    private TextView txt_nama_brg, txt_harga, txt_stok, id;
    Button btn_pesan;

    private RecyclerView data_barang;
    private StringRequest stringRequest;
    private RequestQueue requestQueue;

    ArrayList<HashMap<String, String>> list_data;
    String url = Server.URL + "home.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_recycler_view);

        txt_harga = (TextView) findViewById(R.id.harga);
        txt_nama_brg = (TextView) findViewById(R.id.nama_barang);
        txt_stok = (TextView) findViewById(R.id.stok);
        id = (TextView) findViewById(R.id.id_barang);
        btn_pesan = (Button) findViewById(R.id.btn_pesan);

        data_barang = (RecyclerView) findViewById(R.id.data_barang);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        data_barang.setLayoutManager(llm);

        requestQueue = Volley.newRequestQueue(HomeActivity.this);

        list_data = new ArrayList<HashMap<String, String>>();

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("barang");
                    for (int a = 0; a < jsonArray.length(); a++) {
                        JSONObject json = jsonArray.getJSONObject(a);
                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put("id", json.getString("ID_BARANG"));
                        map.put("nama", json.getString("NAMA_BARANG"));
                        map.put("harga", json.getString("HARGA_SATUAN"));
                        map.put("stok", json.getString("JUMLAH"));
                        map.put("gambar", json.getString("file"));
                        list_data.add(map);
                        adapter_home adapter = new adapter_home(HomeActivity.this, list_data);
                        data_barang.setAdapter(adapter);

                    }
                /*Glide.with(getApplicationContext())
                        .load("https://databases-auth.000webhost.com/id6017007_daml/data_barang" + list_data.get(0).get("file"))
                        .into(img_brng);
                    txt_nama_brg.setText(list_data.get(0).get("nama"));
                    txt_harga.setText(list_data.get(0).get("harga"));
                    txt_stok.setText(list_data.get(0).get("stok"));
                    id.setText(list_data.get(0).get("id"));*/
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HomeActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(stringRequest);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavMenu);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.ic_home:
                        Intent intent0 = new Intent(HomeActivity.this, HomeActivity.class);
                        startActivity(intent0);
                        break;

                    case R.id.ic_pemesanan:
                        Intent intent1 = new Intent(HomeActivity.this, PemesananActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_info:
                        Intent intent2 = new Intent(HomeActivity.this, InfoActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_profil:
                        Intent intent3 = new Intent(HomeActivity.this, ProfilActivity.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });
    }
}