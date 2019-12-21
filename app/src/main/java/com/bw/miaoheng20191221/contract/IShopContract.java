package com.bw.miaoheng20191221.contract;

import com.bumptech.glide.signature.ObjectKey;
import com.bw.miaoheng20191221.base.mvp.IBaseModel;
import com.bw.miaoheng20191221.base.mvp.IBaseView;

/**
 * 时间 :2019/12/21  8:44
 * 作者 :苗恒
 * 功能 :
 */
public interface IShopContract {
    interface IModel extends IBaseModel {
        void getShopData(String url,ModelCallBack modelCallBack);
        void getTagData(String url,ModelCallBack modelCallBack);
        interface ModelCallBack{
            void success(Object data);
            void error(Throwable throwable);
        }
    }
    interface IPresenter {
        void getShopData(String url );
        void getTagData(String url);
    }
    interface IView extends IBaseView {
         void success(Object data);
         void error(Throwable throwable);
    }
}
