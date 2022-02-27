package com.examplez.noteapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.examplez.noteapp.activities.Godaa;
import com.examplez.noteapp.activities.SignInActivity;
import com.examplez.noteapp.activities.SignUpActivity;
import com.examplez.noteapp.databinding.FragmentWelcomeThirdBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WelcomeFragmentThird#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WelcomeFragmentThird extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentWelcomeThirdBinding binding;

    public WelcomeFragmentThird() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WelcomeFragmentThird.
     */
    // TODO: Rename and change types and number of parameters
    public static WelcomeFragmentThird newInstance(String param1, String param2) {
        WelcomeFragmentThird fragment = new WelcomeFragmentThird();
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
        Godaa.implementTheme(getContext());
        binding = FragmentWelcomeThirdBinding.inflate(getLayoutInflater());
        binding.btnSignIn.setOnClickListener(v -> openActivity(getContext(), SignInActivity.class));
        binding.btnSignUp.setOnClickListener(v -> openActivity(getContext(), SignUpActivity.class));
        return binding.getRoot();
    }

    private void openActivity(Context context, Class activity) {
        Intent intent = new Intent(context, activity);
        startActivity(intent);


    }
}