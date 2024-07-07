package com.example.spotify_encore;

interface ApiCallback {
    void onSuccess();
    void onFailure(String errorMessage);
}