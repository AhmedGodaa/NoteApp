package com.examplez.noteapp.data.remote;

import com.examplez.noteapp.domain.model.User;
import com.examplez.noteapp.data.remote.dto.SignInDto;
import com.examplez.noteapp.data.remote.dto.SignUpDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("auth/signin")
    Call<SignInDto> signIn(@Body User user);

    @POST("auth/signup")
    Call<SignUpDto> signUp(@Body User user);

}
