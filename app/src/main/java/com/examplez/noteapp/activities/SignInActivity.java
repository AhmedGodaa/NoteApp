package com.examplez.noteapp.activities;

import static com.examplez.noteapp.activities.Godaa.openActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.examplez.noteapp.databinding.ActivitySignInBinding;

public class SignInActivity extends AppCompatActivity {
    private ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Godaa.implementTheme(SignInActivity.this);
        firstOpen();
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();

    }

    private void setListeners() {
        binding.textForgetPassword.setOnClickListener(v -> openActivity(SignInActivity.this, ForgetPasswordActivity.class));
        binding.btnSignIn.setOnClickListener(v -> openActivity(SignInActivity.this, MainActivity.class));
    }

    private void firstOpen() {
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                    .putBoolean("isFirstRun", false).commit();
            openActivity(this, WelcomeActivity.class);
            finish();
        }

    }


}
