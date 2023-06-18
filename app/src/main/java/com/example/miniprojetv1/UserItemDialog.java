package com.example.miniprojetv1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

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

        tvFirstNameDialog.setText(user.getFirstName());
        tvLastNameDialog.setText(user.getLastNmae());
        tvCity.setText(user.getCity());

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
