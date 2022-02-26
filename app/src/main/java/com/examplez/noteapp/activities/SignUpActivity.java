package com.examplez.noteapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.examplez.noteapp.R;
import com.examplez.noteapp.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {
    private ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.Theme_Night);
        } else {
            setTheme(R.style.Theme_Light);
        }
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();

    }

    private void setListeners() {
        binding.layoutHaveAccount.setOnClickListener(v -> openActivity(SignInActivity.class));

    }

    private void openActivity( Class<?> activity) {
        Intent intent = new Intent(getApplicationContext(), activity);
        startActivity(intent);

    }
}