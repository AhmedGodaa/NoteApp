package com.examplez.noteapp.activities;

import static com.examplez.noteapp.activities.Godaa.implementTheme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.examplez.noteapp.databinding.ActivityForgetPasswordBinding;

public class ForgetPasswordActivity extends AppCompatActivity {
    private ActivityForgetPasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        implementTheme(ForgetPasswordActivity.this);
        super.onCreate(savedInstanceState);
        binding = ActivityForgetPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.imageBack.setOnClickListener(v -> onBackPressed());

    }
}