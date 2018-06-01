package com.example.asus.projectfinish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    Button login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton();
    }

    public void LoginButton(){
        username = findViewById(R.id.editusername);
        password = findViewById(R.id.editpassword);
        login_btn = findViewById(R.id.login);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("user") && password.getText().toString().equals("pass")){
                    Toast.makeText(LoginActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();

                    Intent i1 = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(i1);

                }
                else {
                    Toast.makeText(LoginActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    }