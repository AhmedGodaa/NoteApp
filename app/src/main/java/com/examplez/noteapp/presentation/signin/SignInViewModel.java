package com.examplez.noteapp.presentation.signin;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.examplez.noteapp.domain.model.User;
import com.examplez.noteapp.data.remote.dto.SignInDto;


public class SignInViewModel extends ViewModel {
    private final SignInRepository signInRepository;

    public SignInViewModel(){
        signInRepository = new SignInRepository();
    }


    public LiveData<SignInDto> getLoginResponseLiveData(User user) {
        return signInRepository.getSignInResponseData(user);
    }


}
