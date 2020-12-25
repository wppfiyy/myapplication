package com.example.myapplication.model;

import com.example.myapplication.contract.MyContract;

public class Mymodel implements MyContract.IMainModel {
    private MyContract.IMainPresenter iMainPresenter;

    public Mymodel(MyContract.IMainPresenter iMainPresenter) {
        this.iMainPresenter = iMainPresenter;
    }
}
