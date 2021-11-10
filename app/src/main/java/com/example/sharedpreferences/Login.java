package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button login;
    EditText username, pass;
    CheckBox checkBox;
    boolean remember = false;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.etUser);
        pass = findViewById(R.id.etPass);
        login = findViewById(R.id.btLOGIN);
        checkBox = findViewById(R.id.checkBox);
        preferences = getSharedPreferences("Userinfo", 0); //0 (mode privat)

        remember = preferences.getBoolean("checkbox", false);

        if (remember) {
            Intent intent = new Intent(Login.this, Profile.class);
            startActivity(intent);
            finish();
        }


        login.setOnClickListener(v -> {
            String uservalue = username.getText().toString();
            String pwvalue = pass.getText().toString();
            String registereduser = preferences.getString("Username", "");
            String registeredpass = preferences.getString("Password", "");

            boolean checked = checkBox.isChecked();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("checkbox", checked);
            editor.commit();
            editor.apply();

            if (uservalue.length()>1 && pwvalue.length()>1) {
                if (uservalue.equals(registereduser) && pwvalue.equals(registeredpass)) {
                    Toast.makeText(Login.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, Profile.class);
                    startActivity(intent);
                    finish();
                }
            }else {
                Toast.makeText(Login.this, "Username dan Password Salah!!!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}