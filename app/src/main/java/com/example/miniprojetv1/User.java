package com.example.miniprojetv1;

import androidx.annotation.NonNull;

public class User {
    private String firstName, lastNmae, gender, city;

    public User(String firstName, String lastNmae, String gender, String city) {
        this.firstName = firstName;
        this.lastNmae = lastNmae;
        this.gender = gender;
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNmae() {
        return lastNmae;
    }

    public void setLastNmae(String lastNmae) {
        this.lastNmae = lastNmae;
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
        return String.format("%s %s", firstName, lastNmae);
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("%s\n%s\n%s ", fullName(), gender, city);
    }
}
