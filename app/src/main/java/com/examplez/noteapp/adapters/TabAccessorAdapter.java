package com.examplez.noteapp.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.examplez.noteapp.fragments.WelcomeFragmentFirst;
import com.examplez.noteapp.fragments.WelcomeFragmentSecond;
import com.examplez.noteapp.fragments.WelcomeFragmentThird;


public class TabAccessorAdapter extends FragmentPagerAdapter {
    public TabAccessorAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                WelcomeFragmentFirst welcomeFragmentFirst = new WelcomeFragmentFirst();
                return welcomeFragmentFirst;
            case 1:
                WelcomeFragmentSecond welcomeFragmentSecond = new WelcomeFragmentSecond();
                return welcomeFragmentSecond;
            case 2:
                WelcomeFragmentThird welcomeFragmentThird = new WelcomeFragmentThird();
                return welcomeFragmentThird;

            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Login";
            case 1:
                return "Register";
            default:
                return null;
        }

    }
}
