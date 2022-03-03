package com.examplez.noteapp.activities;

import static com.examplez.noteapp.activities.Godaa.openActivity;

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
        Godaa.getTheme(WelcomeActivity.this);
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
        binding.btnSkip.setOnClickListener(v -> openActivity(getApplicationContext(), SignInActivity.class));
    }


}