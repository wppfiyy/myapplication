package com.example.myapplication.model;

import com.example.myapplication.Ben.BannerBen;
import com.example.myapplication.base.BaseModel;
import com.example.myapplication.contract.MyContract;
import com.example.myapplication.net.CallBackInterface;
import com.example.myapplication.net.RetrofitUtils;
import com.example.myapplication.net.UrlConstant;

public class Mymodel implements MyContract.IMainModel {
    @Override
    public <T>void getData(CallBackInterface<T> callback) {
        RetrofitUtils.getInstance().getLogin(UrlConstant.BASEURL,callback);
    }
}