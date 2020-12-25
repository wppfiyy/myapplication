package com.example.myapplication.net;

public interface CallBackInterface<T> {
    void onSuccess(T t);
    void onFail(String s);
}
