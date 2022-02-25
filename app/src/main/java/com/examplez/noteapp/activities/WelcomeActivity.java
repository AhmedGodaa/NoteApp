package com.examplez.noteapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

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
        super.onCreate(savedInstanceState);
        binding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_welcome);
        viewPager = findViewById(R.id.viewPager);


        dotIndicator = findViewById(R.id.dotIndicator);
        tabAccessorAdapter = new TabAccessorAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabAccessorAdapter);
        dotIndicator.setViewPager(viewPager);


    }
}