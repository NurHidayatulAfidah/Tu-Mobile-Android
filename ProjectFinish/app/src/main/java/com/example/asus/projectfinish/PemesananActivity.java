package com.example.asus.projectfinish;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class PemesananActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<ModelPemesanan> pemesananList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemesanan);

        recyclerView = findViewById(R.id.rv);
        pemesananList = new ArrayList<>();
        pemesananList.add(new ModelPemesanan(R.drawable.aqua_600ml,"Aqua 600 ML", "27/05/2018", "2 dus", "Proses dikirim"));
        pemesananList.add(new ModelPemesanan(R.drawable.cleo_galon,"Cleo Galon", "27/05/2018", "2", "Menunggu"));
        pemesananList.add(new ModelPemesanan(R.drawable.cleo_550ml,"Cleo 550 ML", "27/05/2018", "2 dus", "Proses dikirim"));
        pemesananList.add(new ModelPemesanan(R.drawable.aqua_galon,"Aqua Galon", "27/05/2018", "2", "Terkirim"));


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLiLayoutManager = layoutManager;
        recyclerView.setLayoutManager(rvLiLayoutManager);

        PemesananAdapter adapter = new PemesananAdapter(this,pemesananList);

        recyclerView.setAdapter(adapter);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavMenu);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.ic_home:
                        Intent intent0 = new Intent(PemesananActivity.this, HomeActivity.class);
                        startActivity(intent0);
                        break;

                    case R.id.ic_pemesanan:
                        Intent intent1 = new Intent(PemesananActivity.this, PemesananActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_info:
                        Intent intent2 = new Intent(PemesananActivity.this, InfoActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_profil:
                        Intent intent3 = new Intent(PemesananActivity.this, ProfilActivity.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });
    }
}
