package com.examplez.noteapp.presentation.welcome;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.examplez.noteapp.R;
import com.examplez.noteapp.common.Godaa;


public class WelcomeFragmentFirst extends Fragment {

    public WelcomeFragmentFirst() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Godaa.Companion.getTheme(requireContext());

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome_first, container, false);
    }
}