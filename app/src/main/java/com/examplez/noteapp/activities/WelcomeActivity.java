package com.examplez.noteapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.examplez.noteapp.R;
import com.examplez.noteapp.adapters.TabAccessorAdapter;
import com.examplez.noteapp.databinding.ActivityWelcomeBinding;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;


public class WelcomeActivity extends AppCompatActivity {
    private ActivityWelcomeBinding binding;
    private DotsIndicator dotIndicator;
    private ViewPager viewPager;
    private TabAccessorAdapter tabAccessorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.Theme_Night);
        } else {
            setTheme(R.style.Theme_Light);
        }
        super.onCreate(savedInstanceState);
        binding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewPager = findViewById(R.id.viewPager);
        dotIndicator = findViewById(R.id.dotIndicator);
        tabAccessorAdapter = new TabAccessorAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabAccessorAdapter);
        dotIndicator.setViewPager(viewPager);
        setListeners();


    }

    private void setListeners() {
        binding.btnSkip.setOnClickListener(v -> openActivity(SignInActivity.class));

    }

    private void openActivity(Class<?> activity) {
        Intent intent = new Intent(getApplicationContext(), activity);
        startActivity(intent);

    }
}