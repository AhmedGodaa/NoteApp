package com.examplez.noteapp.presentation.signup;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.examplez.noteapp.domain.model.User;
import com.examplez.noteapp.data.remote.dto.SignUpDto;

public class SignUpViewModel extends ViewModel {


    private final SignUpRepository signUpRepository;

    public SignUpViewModel() {
        signUpRepository = new SignUpRepository();
    }

    public LiveData<SignUpDto> signUp(User user) {
        return signUpRepository.signUp(user);
    }


}
