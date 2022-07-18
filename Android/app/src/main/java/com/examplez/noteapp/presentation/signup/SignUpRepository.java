package com.examplez.noteapp.presentation.signup;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.examplez.noteapp.domain.model.User;
import com.examplez.noteapp.data.remote.dto.SignUpDto;
import com.examplez.noteapp.data.remote.ApiClient;
import com.examplez.noteapp.data.remote.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpRepository {
    private static final String TAG = SignUpRepository.class.getSimpleName();
    private ApiService apiService;


    public SignUpRepository() {
        apiService = ApiClient.getRetrofit().create(ApiService.class);

    }
    public LiveData<SignUpDto> signUp(User user) {
        final MutableLiveData<SignUpDto> mutableLiveData = new MutableLiveData<>();
        apiService.signUp(user).enqueue(new Callback<SignUpDto>() {
            @Override
            public void onResponse(Call<SignUpDto> call, Response<SignUpDto> response) {
                Log.d(TAG, "onResponse: Registered Successfully");
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<SignUpDto> call, Throwable t) {
                Log.d(TAG, t.getMessage());

            }
        });
        return mutableLiveData;
    }
}
