package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {
    Button logout;
    TextView tvUser, tvMail;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        logout = findViewById(R.id.btLOGOUT);
        tvUser = findViewById(R.id.tvUsername);
        tvMail = findViewById(R.id.tvEmail);
        preferences = getSharedPreferences("Userinfo", 0);

        tvUser.setText(preferences.getString("Username", ""));
        tvMail.setText(preferences.getString("Email", ""));

        logout.setOnClickListener(v -> {
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.apply();
            Toast.makeText(this, "LOG-OUT Berhasil!!!", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Profile.this, MainActivity.class);
            startActivity(i);
        });
    }
}