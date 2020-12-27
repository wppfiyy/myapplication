package com.example.myapplication.model;

import com.example.myapplication.contract.MyContract;
import com.example.myapplication.net.CallBackInterface;
import com.example.myapplication.net.RetrofitUtils;


public class Mymodel implements MyContract.IMainModel {

    private MyContract.IMainPresenter mainPresenter;

    public Mymodel(MyContract.IMainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
    }

    @Override
    public <T> void getLogin(String newlist, CallBackInterface<T> callBackInterface) {
        RetrofitUtils.getInstance().getLogin(newlist,callBackInterface);
    }
}