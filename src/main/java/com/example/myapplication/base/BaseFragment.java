package com.example.myapplication.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseFragment<P extends BasePresenter>extends Fragment implements BaseView{
    public P per;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutID(), container, false);
        if(per==null){
            createPersnter();
        }
        initData();
        initView(inflate);
        return inflate;
    }

    protected abstract int getLayoutID();

    public abstract void initData();
    protected abstract void initView(View inflate);
    public void createPersnter(){
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        Type[] typeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        Class<P> p = ((Class<P>) typeArguments[0]);
        try {
            per=p.newInstance();
            per.attachView(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(per!=null){
            per.detachView();
        }
    }
}
