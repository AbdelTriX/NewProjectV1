package com.example.miniprojetv1;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.io.IOException;
import java.io.InputStream;

public class UserItemDialog extends DialogFragment {
    User user;

    public UserItemDialog(User user) {
        this.user = user;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_user_dialog, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        TextView tvFirstNameDialog = view.findViewById(R.id.tvFirstNameDialog);
        TextView tvLastNameDialog = view.findViewById(R.id.tvLastNameDialog);
        TextView tvCity = view.findViewById(R.id.tvCityDialog);
        ImageView imgViewUserDetails = view.findViewById(R.id.imgViewUserDetails);

        tvFirstNameDialog.setText(user.getFirstName());
        tvLastNameDialog.setText(user.getLastName());
        tvCity.setText(user.getCity());


        // Load image from assets folder
        AssetManager assetManager = requireContext().getAssets();
        try {
            InputStream inputStream = assetManager.open(user.getImageView());
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            imgViewUserDetails.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (user.getGender().equals("male")) {
            view.setBackgroundColor(Color.parseColor("#ADD8EA"));
        }
        else {
            view.setBackgroundColor(Color.parseColor("#ffb7c1"));
        }
        super.onViewCreated(view, savedInstanceState);


        super.onViewCreated(view, savedInstanceState);
    }
}
