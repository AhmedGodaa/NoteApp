package com.examplez.noteapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.examplez.noteapp.entities.User;
import com.examplez.noteapp.network.SignInRepository;
import com.examplez.noteapp.network.SignInResponse;


public class SignInViewModel extends ViewModel {
    private final SignInRepository signInRepository;

    public SignInViewModel(){
        signInRepository = new SignInRepository();
    }


    public LiveData<SignInResponse> getLoginResponseLiveData(User user) {
        return signInRepository.getSignInResponseData(user);
    }


}
