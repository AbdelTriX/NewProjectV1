package com.example.miniprojetv1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends BaseAdapter {
    ArrayList<User> users;
    LayoutInflater inflater;

    public UsersAdapter(Context context, ArrayList<User> users) {
        this.users = users;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_user, null);

        TextView tvUserItmFullName = convertView.findViewById(R.id.tvUserItmFullName);
        TextView tvUserItmGender = convertView.findViewById(R.id.tvUserItmGender);
        TextView tvUserItmCity = convertView.findViewById(R.id.tvUserItmCity);

        User user = users.get(position);
        int id = position + 1; // Auto-incremented ID starting from 1


        tvUserItmFullName.setText(user.fullName());
        tvUserItmCity.setText(user.getCity());
        tvUserItmGender.setText("#"+id);

        if (user.getGender().equalsIgnoreCase("male")) {
            convertView.setBackgroundColor(convertView.getResources().getColor(R.color.primary_color));
        } else if (user.getGender().equalsIgnoreCase("female")) {
            convertView.setBackgroundColor(convertView.getResources().getColor(R.color.baby_pink));
        }

        return convertView;
    }
}
