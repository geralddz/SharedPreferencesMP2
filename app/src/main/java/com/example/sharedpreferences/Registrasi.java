package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Registrasi extends AppCompatActivity {
    Button Register;
    EditText user, mail, etpw, etcpw;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
        user = findViewById(R.id.etUsername);
        mail = findViewById(R.id.etEmail);
        etpw = findViewById(R.id.etPassword);
        etcpw = findViewById(R.id.etKonfirm);
        Register = findViewById(R.id.btRegister);

        preferences = getSharedPreferences("Userinfo", 0);

        Register.setOnClickListener(v -> {
            String uservalue = user.getText().toString();
            String mailvalue = mail.getText().toString();
            String pwvalue = etpw.getText().toString();
            String cpwvalue = etcpw.getText().toString();

            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("Username", uservalue);
            editor.putString("Email", mailvalue);
            editor.putString("Password", pwvalue);
            editor.putString("Confirm Password", cpwvalue);
            editor.commit();
            editor.apply();

            if (uservalue.length()==0) {
                Toast.makeText(Registrasi.this, "Masukkan Username", Toast.LENGTH_SHORT).show();
                }
                    else if (mailvalue.length() == 0) {
                        Toast.makeText(Registrasi.this, "Masukkan Email", Toast.LENGTH_SHORT).show();
                    }
                    else if (etpw.getText().toString().length() == 0 && (etcpw.getText().toString().length() == 0)) {
                        etpw.setError("Password Tidak Boleh Kosong");
                    }

                    else if (etpw.getText().toString().length() != 0 && cpwvalue.equals(pwvalue)) {
                        Toast.makeText(Registrasi.this, "Akun Terdaftar", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Registrasi.this, Login.class);
                        startActivity(intent);
                    }

                    else {
                        etcpw.setError("Konfirmasi Password Anda Salah");
                    }

        });

    }
}