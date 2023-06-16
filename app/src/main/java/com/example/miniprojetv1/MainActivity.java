package com.example.miniprojetv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLoadUsers, btnQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoadUsers = findViewById(R.id.btnLoadUsers);
        btnQuit = findViewById(R.id.btnQuit);

        btnQuit.setOnClickListener(this);
        btnLoadUsers.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLoadUsers) {
            Toast.makeText(this, "Load users", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnQuit) {
            finish();
        }
    }
}