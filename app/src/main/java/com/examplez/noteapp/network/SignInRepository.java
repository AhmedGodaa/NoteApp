package com.examplez.noteapp.network;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.examplez.noteapp.entities.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInRepository {

    private static final String TAG = SignInRepository.class.getSimpleName();

    private ApiService apiService;


    public SignInRepository() {
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<SignInResponse> getSignInResponseData(User user) {
        final MutableLiveData<SignInResponse> mutableLiveData = new MutableLiveData<>();

        apiService.signIn(user).enqueue(new Callback<SignInResponse>() {
            @Override
            public void onResponse(Call<SignInResponse> call, Response<SignInResponse> response) {
                Log.d(TAG, "onResponse: Succeeded");
                mutableLiveData.setValue(response.body());


            }

            @Override
            public void onFailure(Call<SignInResponse> call, Throwable t) {
                Log.d(TAG, t.getMessage());



            }
        });
        return mutableLiveData;
    }
}
