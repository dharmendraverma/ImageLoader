package com.example.dharmendraverma.imageloader.interfaces;

public interface ApiResponseListener {

    void onSuccess(String key, String jsonObject);
    void onFailure();
}
