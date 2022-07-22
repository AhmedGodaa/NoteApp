package com.examplez.noteapp.presentation.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.examplez.noteapp.presentation.forgetpassword.ForgetPasswordActivity;
import com.examplez.noteapp.common.Godaa;
import com.examplez.noteapp.presentation.activities.MainActivity;
import com.examplez.noteapp.databinding.ActivitySignInBinding;
import com.examplez.noteapp.domain.model.User;
import com.examplez.noteapp.common.Constants;
import com.examplez.noteapp.common.PreferencesManager;

import androidx.lifecycle.ViewModelProvider;

public class SignInActivity extends AppCompatActivity {
    private ActivitySignInBinding binding;
    private SignInViewModel signInViewModel;
    private PreferencesManager preferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        firstOpen();
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
        binding.btnSignIn.setOnClickListener(v -> {

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });
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
