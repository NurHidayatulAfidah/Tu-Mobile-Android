package com.example.asus.projectfinish;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    List<Barang> lstBarang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lstBarang = new ArrayList<>();
        lstBarang.add(new Barang("Aqua Galon", "Rp. 16.000", R.drawable.aqua_galon));
        lstBarang.add(new Barang("Cleo Galon", "Rp. 13.000", R.drawable.cleo_galon));
        lstBarang.add(new Barang("Aqua Kemasan 600 ml", "Rp. 40.000", R.drawable.aqua_600ml));
        lstBarang.add(new Barang("LPG 3kg", "Rp. 16.000", R.drawable.lpg));
        lstBarang.add(new Barang("Aqua Galon", "Rp. 16.000", R.drawable.aqua_galon));
        lstBarang.add(new Barang("Cleo Galon", "Rp. 13.000", R.drawable.cleo_galon));
        lstBarang.add(new Barang("Aqua Kemasan 600 ml", "Rp. 40.000", R.drawable.aqua_600ml));
        lstBarang.add(new Barang("LPG 3kg", "Rp. 16.000", R.drawable.lpg));
        lstBarang.add(new Barang("Aqua Galon", "Rp. 16.000", R.drawable.aqua_galon));
        lstBarang.add(new Barang("Cleo Galon", "Rp. 13.000", R.drawable.cleo_galon));
        lstBarang.add(new Barang("Aqua Kemasan 600 ml", "Rp. 40.000", R.drawable.aqua_600ml));
        lstBarang.add(new Barang("LPG 3kg", "Rp. 16.000", R.drawable.lpg));
        lstBarang.add(new Barang("Aqua Kemasan 600 ml", "Rp. 40.000", R.drawable.aqua_600ml));
        lstBarang.add(new Barang("LPG 3kg", "Rp. 16.000", R.drawable.lpg));;

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, lstBarang);
        myrv.setLayoutManager(new GridLayoutManager(this, 2));
        myrv.setAdapter(myAdapter);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavMenu);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

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
