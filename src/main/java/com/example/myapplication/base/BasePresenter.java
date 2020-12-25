package com.example.myapplication.base;

public abstract class BasePresenter<V extends BaseView,M extends BaseModel> {
    private V iView;
    private M iModel;
    public void attachView(V v){
        iView=v;
        iModel=getiModel();
    }

    public void detachView(){
        if(iView!=null){
            iView=null;
        }
        if(iModel!=null){
            iModel=null;
        }
    }

    protected abstract M getiModel();
}
