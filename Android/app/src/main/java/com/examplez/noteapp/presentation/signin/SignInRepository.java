package com.examplez.noteapp.presentation.signin;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.examplez.noteapp.domain.model.User;
import com.examplez.noteapp.data.remote.dto.SignInDto;
import com.examplez.noteapp.data.remote.ApiClient;
import com.examplez.noteapp.data.remote.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInRepository {

    private static final String TAG = SignInRepository.class.getSimpleName();

    private ApiService apiService;


    public SignInRepository() {
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<SignInDto> getSignInResponseData(User user) {
        final MutableLiveData<SignInDto> mutableLiveData = new MutableLiveData<>();

        apiService.signIn(user).enqueue(new Callback<SignInDto>() {
            @Override
            public void onResponse(Call<SignInDto> call, Response<SignInDto> response) {
                Log.d(TAG, "onResponse: Succeeded");
                mutableLiveData.setValue(response.body());


            }

            @Override
            public void onFailure(Call<SignInDto> call, Throwable t) {
                Log.d(TAG, t.getMessage());



            }
        });
        return mutableLiveData;
    }
}
