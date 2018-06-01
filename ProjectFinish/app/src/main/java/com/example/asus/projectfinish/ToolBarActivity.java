package com.example.asus.projectfinish;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.view.Menu;
import android.view.MenuItem;

public class ToolBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);

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
                        Intent intent0 = new Intent(ToolBarActivity.this, HomeActivity.class);
                        startActivity(intent0);
                        break;

                    case R.id.ic_pemesanan:
                        Intent intent1 = new Intent(ToolBarActivity.this, PemesananActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_info:
                        Intent intent2 = new Intent(ToolBarActivity.this, InfoActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_profil:
                        Intent intent3 = new Intent(ToolBarActivity.this, ProfilActivity.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });
    }
}
