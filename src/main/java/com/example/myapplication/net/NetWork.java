package com.example.myapplication.net;

public interface NetWork {
    public <T> void getLogin(String url,CallBackInterface<T> callBack);
}
