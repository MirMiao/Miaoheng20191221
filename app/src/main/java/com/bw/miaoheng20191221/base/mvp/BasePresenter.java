package com.bw.miaoheng20191221.base.mvp;

import java.lang.ref.WeakReference;

/**
 * 时间 :2019/12/21  8:35
 * 作者 :苗恒
 * 功能 :
 */
public abstract class BasePresenter<M extends IBaseModel,V extends IBaseView> {
    public M model;
    public WeakReference<V> weakReference;

    public BasePresenter() {
        model=initModel();
    }
    public void attach(V v){
        weakReference=new WeakReference<>(v);
    }
    public void deattach(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference=null;
        }
    }
    public V getView(){
        return weakReference.get();
    }
    protected abstract M initModel();
}
