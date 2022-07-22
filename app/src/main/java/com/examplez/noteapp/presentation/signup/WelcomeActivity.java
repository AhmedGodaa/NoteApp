package com.examplez.noteapp.presentation.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.examplez.noteapp.R;
import com.examplez.noteapp.common.Godaa;
import com.examplez.noteapp.presentation.activities.MainActivity;
import com.examplez.noteapp.presentation.welcome.TabAccessorAdapter;
import com.examplez.noteapp.databinding.ActivityWelcomeBinding;
import com.examplez.noteapp.common.Constants;
import com.examplez.noteapp.common.PreferencesManager;
import com.examplez.noteapp.presentation.signin.SignInActivity;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;


public class WelcomeActivity extends AppCompatActivity {
    private ActivityWelcomeBinding binding;
    private DotsIndicator dotIndicator;
    private ViewPager viewPager;
    private TabAccessorAdapter tabAccessorAdapter;
    private PreferencesManager preferencesManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Godaa.Companion.getTheme(WelcomeActivity.this);
        super.onCreate(savedInstanceState);
        binding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferencesManager = new PreferencesManager(this);
        viewPager = findViewById(R.id.viewPager);
        dotIndicator = findViewById(R.id.dotIndicator);
        tabAccessorAdapter = new TabAccessorAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabAccessorAdapter);
        dotIndicator.setViewPager(viewPager);
        setListeners();
        checkLoginStatus();


    }
        private void checkLoginStatus() {
        if (preferencesManager.getBoolean(Constants.KEY_IS_SIGNED_IN)) {
            Godaa.Companion.openActivity(this, MainActivity.class);
            finish();
        }

    }

    private void setListeners() {
        binding.btnSkip.setOnClickListener(v -> Godaa.Companion.openActivity(getApplicationContext(), SignInActivity.class));

    }


}