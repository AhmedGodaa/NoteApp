package com.examplez.noteapp.network;

import com.examplez.noteapp.entities.Role;
import com.google.gson.annotations.SerializedName;

import java.util.HashSet;
import java.util.Set;

public class SignInResponse {
    @SerializedName("id")
    private int id;

    @SerializedName("username")
    private String username;

    @SerializedName("email")
    private String email;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }


}
