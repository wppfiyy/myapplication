package com.example.myapplication.net;

import com.example.myapplication.Ben.BannerBen;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String bannerUrl="https://cdwan.cn/";
    @GET("api/index")
    Observable<BannerBen> getBanner();
}
