package com.examplez.noteapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.examplez.noteapp.databinding.ActivityForgetPasswordBinding;

public class ForgetPasswordActivity extends AppCompatActivity {
    private ActivityForgetPasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Godaa.getTheme(ForgetPasswordActivity.this);
        super.onCreate(savedInstanceState);
        binding = ActivityForgetPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.imageBack.setOnClickListener(v -> onBackPressed());

    }
}