package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button Registrasi, Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Registrasi = findViewById(R.id.btRegistrasi);
        Login = findViewById(R.id.btLogin);

        Registrasi.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this,Registrasi.class);
            startActivity(i);
        });

        Login.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this,Login.class);
            startActivity(i);
        });
    }
}