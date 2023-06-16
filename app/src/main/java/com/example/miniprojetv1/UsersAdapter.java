package com.example.miniprojetv1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends BaseAdapter {
    ArrayList<User> users;
    LayoutInflater inflater;
    Context mContext;

    public UsersAdapter(Context context, ArrayList<User> users) {
        this.users = users;
        this.mContext = context;
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
        TextView tvUserItmCity = convertView.findViewById(R.id.tvUserItmCity);
        Button btnDetails = convertView.findViewById(R.id.btnDetails);

        tvUserItmFullName.setText(users.get(position).fullName());
        tvUserItmCity.setText(users.get(position).getCity());

        btnDetails.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            builder.setTitle("Title")
                    .setMessage("msg")
                    .show();
        });



        return convertView;
    }
}
