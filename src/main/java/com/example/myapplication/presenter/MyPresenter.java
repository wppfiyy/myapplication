package com.example.myapplication.presenter;

import android.util.Log;

import com.example.myapplication.Ben.BannerBen;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.base.BaseView;
import com.example.myapplication.contract.MyContract;
import com.example.myapplication.model.Mymodel;
import com.example.myapplication.net.CallBackInterface;
import com.example.myapplication.net.UrlConstant;

public class MyPresenter extends BasePresenter<MyContract.IMainView,MyContract.IMainModel> implements MyContract.IMainPresenter{

    @Override
    public Mymodel getiModel() {
        return new Mymodel(this);
    }


    @Override
    public void fun() {
        iModel.getLogin(UrlConstant.NEWLIST, new CallBackInterface<BannerBen>() {
            @Override
            public void onSuccess(BannerBen bannerBen) {
                iView.onInit(bannerBen);
            }

            @Override
            public void onFail(String s) {

            }
        });
    }
}
