package com.example.myapplication.net;

import com.example.myapplication.Ben.BannerBen;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {
    @GET
    Observable<ResponseBody> getBanner(@Url String surl);
}
