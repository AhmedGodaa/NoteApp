package com.examplez.noteapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.examplez.noteapp.databinding.ActivitySignInBinding;
import com.examplez.noteapp.utilities.Constants;

public class SignInActivity extends AppCompatActivity {
    private ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        firstOpen();
        Godaa.Companion.getTheme(SignInActivity.this);
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();

    }

    private void setListeners() {
        binding.textForgetPassword.setOnClickListener(v -> Godaa.Companion.openActivity(SignInActivity.this, ForgetPasswordActivity.class));
        binding.btnSignIn.setOnClickListener(v -> Godaa.Companion.openActivity(SignInActivity.this, MainActivity.class));
    }

//    private void firstOpen() {
//        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
//                .getBoolean("isFirstRun", true);
//
//        if (isFirstRun) {
//            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
//                    .putBoolean("isFirstRun", false).commit();
//            openActivity(this, WelcomeActivity.class);
//            finish();
//        }
//
//    }


}
