package com.examplez.noteapp.network;

import com.examplez.noteapp.entities.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("auth/signin")
    Call<SignInResponse> signIn(@Body User user);

}
