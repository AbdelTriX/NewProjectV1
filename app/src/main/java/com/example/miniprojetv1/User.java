package com.example.miniprojetv1;

import android.widget.ImageView;

import androidx.annotation.NonNull;

public class User {
    private String firstName, lastName, gender, city, imageView;

    public User(String firstName, String lastName, String gender, String city, String imageView) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.imageView = imageView;
        this.city = city;
    }

    public String getImageView() {
        return imageView;
    }

    public void setImageView(String imageView) {
        this.imageView = imageView;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String fullName() {
        return String.format("%s %s", firstName, lastName);
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("Hi, I'm %s, I'm %s\nI live in %s", fullName(),
                gender.equals("male") ? "♂" : "♀",
                city);
    }
}
