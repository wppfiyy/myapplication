package com.example.myapplication.net;

import com.example.myapplication.Ben.BannerBen;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitUtils implements NetWork{
    public static RetrofitUtils retrofitUtils;
    private final ApiService apiService;

    private RetrofitUtils(){
        Retrofit build = new Retrofit.Builder()
                .baseUrl(UrlConstant.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = build.create(ApiService.class);
    }


    public static RetrofitUtils getInstance(){
        if(retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if (retrofitUtils==null){
                     retrofitUtils=new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    @Override
    public <T> void getLogin(String url, CallBackInterface<T> callBack) {
        apiService.getBanner(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] typeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type typeArgument = typeArguments[0];
                            Gson gson = new Gson();
                            gson.fromJson(string,typeArgument);
                            T result = gson.fromJson(string, typeArgument);
                            callBack.onSuccess(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
