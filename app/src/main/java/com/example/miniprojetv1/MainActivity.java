package com.example.miniprojetv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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
    @SuppressLint("ClickableViewAccessibility")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoadUsers = findViewById(R.id.btnLoadUsers);
        tvQuit = findViewById(R.id.tvQuit);
        lvUsers = findViewById(R.id.lvUsers);

        tvQuit.setOnClickListener(this);
        btnLoadUsers.setOnClickListener(this);


        // For swipe
        GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onFling(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
                if (e1.getX() - e2.getX() >= 100) {
                    finish();
                }

                return super.onFling(e1, e2, velocityX, velocityY);
            }
        });
        tvQuit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLoadUsers) {
            UsersAdapter usersAdapter = new UsersAdapter(this, getUsers());

            lvUsers.setAdapter(usersAdapter);

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
