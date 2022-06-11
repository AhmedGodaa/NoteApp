package com.examplez.noteapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.examplez.noteapp.databinding.ActivitySignInBinding;
import com.examplez.noteapp.entities.User;
import com.examplez.noteapp.utilities.Constants;
import com.examplez.noteapp.utilities.PreferencesManager;
import com.examplez.noteapp.viewmodels.SignInViewModel;

import androidx.lifecycle.ViewModelProvider;

public class SignInActivity extends AppCompatActivity {
    private ActivitySignInBinding binding;
    private SignInViewModel signInViewModel;
    private PreferencesManager preferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Godaa.Companion.getTheme(SignInActivity.this);
        super.onCreate(savedInstanceState);
        signInViewModel = new ViewModelProvider(this).get(SignInViewModel.class);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferencesManager = new PreferencesManager(this);
        setListeners();

    }

    private void setListeners() {
        binding.textForgetPassword.setOnClickListener(v -> Godaa.Companion.openActivity(SignInActivity.this, ForgetPasswordActivity.class));
        binding.btnSignIn.setOnClickListener(v -> Godaa.Companion.openActivity(SignInActivity.this,MainActivity.class));
    }

    private void signIn() {

        String password = binding.inputPassword.getText().toString();
        String username = binding.inputEmail.getText().toString();
        User user = new User(username, password);

        signInViewModel.getLoginResponseLiveData(user).observe(this, signInResponse -> {
            preferencesManager.putString(Constants.KEY_USERNAME, signInResponse.getUsername());
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();

        });


    }




}
