package com.example.miniprojetv1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
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
        ImageButton btnDetails = convertView.findViewById(R.id.btnDetails);

        User user = users.get(position);
        tvUserItmFullName.setText(user.fullName());
        tvUserItmCity.setText(user.getCity());

        btnDetails.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, DisplayUserInfo.class);
            intent.putExtra("firstName",user.getFirstName());
            intent.putExtra("lastName",user.getLastNmae());
            intent.putExtra("city",user.getCity());
            intent.putExtra("gender",user.getGender());
            mContext.startActivity(intent);
        });



        return convertView;
    }
}
