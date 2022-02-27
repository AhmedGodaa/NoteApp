package com.examplez.noteapp.activities;

import static com.examplez.noteapp.activities.Godaa.openActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.examplez.noteapp.R;
import com.examplez.noteapp.databinding.ActivitySignInBinding;

public class SignInActivity extends AppCompatActivity {
    private ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Godaa.implementTheme(SignInActivity.this);
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.textForgetPassword.setOnClickListener(v -> openActivity(SignInActivity.this, ForgetPasswordActivity.class));
        binding.btnSignIn.setOnClickListener(v -> openActivity(SignInActivity.this, MainActivity.class));
    }
}