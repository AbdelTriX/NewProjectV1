package com.example.miniprojetv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLoadUsers;
    TextView tvQuit;
    ListView lvUsers;
    ProgressBar progressBar;
    @SuppressLint("ClickableViewAccessibility")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoadUsers = findViewById(R.id.btnLoadUsers);
        tvQuit = findViewById(R.id.tvQuit);
        lvUsers = findViewById(R.id.lvUsers);
        progressBar = findViewById(R.id.progressBar);

        tvQuit.setOnClickListener(this);
        btnLoadUsers.setOnClickListener(this);


        // For swipe

        tvQuit.setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void swipeRight() {
                Toast.makeText(MainActivity.this, "This action is not yet inplemented !!! if u want to quit the app please" +
                        "swipe left!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void swipeLeft() {
                finish();
            }
        });
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLoadUsers) {
            // Show ProgressBar
            progressBar.setVisibility(View.VISIBLE);

            // Delay for 2 seconds before loading the users
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Load users
                    UsersAdapter usersAdapter = new UsersAdapter(MainActivity.this, getUsers());
                    lvUsers.setAdapter(usersAdapter);

                    // Hide ProgressBar after loading the users
                    progressBar.setVisibility(View.GONE);
                }
            }, 1000); // 2 seconds delay
        } else if (v.getId() == R.id.tvQuit) {
            finish();
        }
    }


    public ArrayList<User> getUsers() {
        ArrayList<User> usersFullName = new ArrayList<>();
        try {
            InputStream inputStream = getAssets().open("users.json");
            int code;
            StringBuilder stringBuilder = new StringBuilder();
            String jsonString;

            code = inputStream.read(); // Read from JSON
            while (code != -1) {
                stringBuilder.append((char) code);

                code = inputStream.read();
            }
            jsonString = stringBuilder.toString();



            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = jsonObject.getJSONArray("users");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject user = jsonArray.getJSONObject(i);
                JSONObject userName = user.getJSONObject("name");

                usersFullName.add(new User(
                        userName.getString("first"),
                        userName.getString("last"),
                        user.getString("gender"),
                        user.getString("city")));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return usersFullName;
    }
}
