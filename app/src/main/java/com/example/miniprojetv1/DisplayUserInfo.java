package com.example.miniprojetv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayUserInfo extends AppCompatActivity {

    TextView tvFirstName, tvLastName, tvGender, tvCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_user_info);

        tvFirstName = findViewById(R.id.tvFirstName);
        tvLastName = findViewById(R.id.tvLastName);
        tvGender = findViewById(R.id.tvGender);
        tvCity = findViewById(R.id.tvCity);

        Intent intent = getIntent();
        String firstName = intent.getStringExtra("firstName");
        String lastName = intent.getStringExtra("lastName");
        String gender = intent.getStringExtra("gender");
        String city = intent.getStringExtra("city");

        tvFirstName.setText(firstName);
        tvLastName.setText(lastName);
        tvCity.setText(city);

        if (gender.equals("male")) {
            tvGender.setText("♂ ");
        }
        else{
            tvGender.setText("♀");
        }
    }
}