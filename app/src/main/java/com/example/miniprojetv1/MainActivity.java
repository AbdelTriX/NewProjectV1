package com.example.miniprojetv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLoadUsers, btnQuit;
    ListView lvUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoadUsers = findViewById(R.id.btnLoadUsers);
        btnQuit = findViewById(R.id.btnQuit);
        lvUsers = findViewById(R.id.lvUsers);

        btnQuit.setOnClickListener(this);
        btnLoadUsers.setOnClickListener(this);

        ArrayList<String> names = new ArrayList<>();
        names.add("Ahmed");
        names.add("Mohamed");
        names.add("Islam");

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLoadUsers) {
            ArrayAdapter<User> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getUsers());

            lvUsers.setAdapter(adapter);

        } else if (v.getId() == R.id.btnQuit) {
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
