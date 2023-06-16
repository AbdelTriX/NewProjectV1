package com.example.miniprojetv1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

        User user = users.get(position);
        tvUserItmFullName.setText(user.fullName());
        tvUserItmCity.setText(user.getCity());

        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle(String.format("Details of user %d", position +1))
                        .setMessage(user.toString())
                        .show();

                return false;
            }
        });
        
        convertView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Toast.makeText(mContext, "Down", Toast.LENGTH_SHORT).show();
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Toast.makeText(mContext, "up", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });






        return convertView;
    }
}
