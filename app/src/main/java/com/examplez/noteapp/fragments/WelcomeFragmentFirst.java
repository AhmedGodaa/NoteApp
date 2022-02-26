package com.examplez.noteapp.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.examplez.noteapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WelcomeFragmentFirst#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WelcomeFragmentFirst extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WelcomeFragmentFirst() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WelcomeFragmentFirst.
     */
    // TODO: Rename and change types and number of parameters
    public static WelcomeFragmentFirst newInstance(String param1, String param2) {
        WelcomeFragmentFirst fragment = new WelcomeFragmentFirst();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            getContext().getTheme().applyStyle(R.style.Theme_Night, true);
        } else {
            getContext().getTheme().applyStyle(R.style.Theme_Light, true);
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome_first, container, false);
    }
}