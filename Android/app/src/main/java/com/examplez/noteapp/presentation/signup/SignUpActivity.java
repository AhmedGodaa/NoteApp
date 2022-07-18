package com.examplez.noteapp.presentation.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Toast;

import com.examplez.noteapp.R;
import com.examplez.noteapp.common.Godaa;
import com.examplez.noteapp.domain.model.User;
import com.examplez.noteapp.presentation.signin.SignInActivity;

public class SignUpActivity extends AppCompatActivity {
    private ActivitySignUpBinding binding;
    private SignUpViewModel signUpViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Godaa.Companion.getTheme(SignUpActivity.this);
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.Theme_Night);
        } else {
            setTheme(R.style.Theme_Light);
        }
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        signUpViewModel = new ViewModelProvider(this).get(SignUpViewModel.class);
        setListeners();

    }

    private void setListeners() {
        binding.layoutHaveAccount.setOnClickListener(v -> Godaa.Companion.openActivity(getApplicationContext(), SignInActivity.class));
        binding.btnSignUp.setOnClickListener(v -> {
            if (isValidSignUpDetails()) {
                signUp();
            }
        });

    }

    private Boolean isValidSignUpDetails() {
        if (binding.inputUsername.getText().toString().trim().isEmpty()) {
            showToast("Enter Name");
            return false;
        } else if (binding.inputEmail.getEditableText().toString().trim().isEmpty()) {
            showToast("Enter Email");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.inputEmail.getEditableText().toString()).matches()) {
            showToast("Enter valid Email");
            return false;
        } else if (binding.inputPassword.getEditableText().toString().trim().isEmpty()) {
            showToast("Enter Password");
            return false;
        }
//        else if (binding.inputConfirmPassword.getText().toString().trim().isEmpty()) {
//            showToast("Confirm Your Password");
//            return false;
//        }
//        else if (!binding.inputPassword.getText().toString().equals(binding.inputConfirmPassword.toString())) {
//            showToast("Password & Confirm must be Same");
//            return false;
//        }
        else {
            return true;

        }
    }


    private void signUp() {
        signUpViewModel.signUp(new User(
                binding.inputUsername.getText().toString(),
                binding.inputEmail.getEditableText().toString(),
                binding.inputPassword.getEditableText().toString(),
                "user"

        ));
        Godaa.Companion.openActivity(this,SignInActivity.class);


    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}