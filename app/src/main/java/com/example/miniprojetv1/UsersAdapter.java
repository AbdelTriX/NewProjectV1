package com.example.miniprojetv1;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends BaseAdapter {
    final static int DOUBLE_CLICK_TIMEOUT = 500;

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
        ImageView ivUserItemCheck = convertView.findViewById(R.id.ivUserItmChecked);

        User user = users.get(position);
        tvUserItmFullName.setText(user.fullName());
        tvUserItmCity.setText(user.getCity());

        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

//                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
//                builder.setTitle(String.format("Details of user %d", position +1))
//                        .setMessage(user.toString())
//                        .show();

                return false;
            }
        });


        final View finalConvertView = convertView;
        final int originalColor = convertView.getDrawingCacheBackgroundColor();
        convertView.setOnTouchListener(new OnSwipeTouchListener(mContext) {
        @Override
        public void swipeLeft() {
            finalConvertView.setBackgroundColor(Color.parseColor("#FFC0CB")); // Pink color

            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            builder.setTitle("Confirmation")
                    .setMessage("Are you sure u want to delete ?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            users.remove(position);
                            notifyDataSetChanged(); // Refresh the adapter after removing the item
                            Toast.makeText(mContext, "Deleted", Toast.LENGTH_SHORT).show();

                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finalConvertView.setBackgroundColor(originalColor); // Revert to original color
                }
            })
                    .show();

        }
    });
        return convertView;
    }
}
