package com.example.asus.projectfinish;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomnavMenu);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.ic_home:
                        Intent intent1 = new Intent(InfoActivity.this, HomeActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_pemesanan:
                        Intent intent2 = new Intent(InfoActivity.this, PemesananActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_info:
                        Intent intent3 = new Intent(InfoActivity.this, InfoActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.ic_profil:
                        Intent intent4 = new Intent(InfoActivity.this, ProfilActivity.class);
                        startActivity(intent4);
                        break;
                }
                return false;
            }
        });
    }
}
