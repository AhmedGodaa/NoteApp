package com.examplez.noteapp.adapters;

import androidx.annotation.NonNull;
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
                return new WelcomeFragmentFirst();
            case 1:
                return new WelcomeFragmentSecond();
            case 2:
                return new WelcomeFragmentThird();

            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return 3;
    }


}
