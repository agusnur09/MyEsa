package com.assyfa.latihan.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.assyfa.latihan.api.ApiClient;
import com.assyfa.latihan.api.ApiInterface;

public class BaseActivity extends AppCompatActivity {

    public static ApiInterface apiService;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        apiService = ApiClient.getClient().create(ApiInterface.class);

    }


}
