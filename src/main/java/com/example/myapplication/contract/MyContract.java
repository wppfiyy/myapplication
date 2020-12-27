package com.example.myapplication.contract;

import com.example.myapplication.Ben.BannerBen;
import com.example.myapplication.base.BaseModel;
import com.example.myapplication.base.BaseView;
import com.example.myapplication.net.CallBackInterface;

public class MyContract {
    public interface IMainView extends BaseView {
        void onInit(BannerBen bannerBen);

    }

    public interface IMainPresenter{

        void fun();
    }

    public interface IMainModel extends BaseModel {

        <T>void getLogin(String newlist, CallBackInterface<T> callBackInterface);
    }
}
