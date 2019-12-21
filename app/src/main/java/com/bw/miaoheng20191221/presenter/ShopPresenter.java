package com.bw.miaoheng20191221.presenter;

import com.bw.miaoheng20191221.base.mvp.BasePresenter;
import com.bw.miaoheng20191221.contract.IShopContract;
import com.bw.miaoheng20191221.model.ShopModel;

/**
 * 时间 :2019/12/21  8:50
 * 作者 :苗恒
 * 功能 :
 */
public class ShopPresenter extends BasePresenter<ShopModel, IShopContract.IView> implements IShopContract.IPresenter {
    @Override
    protected ShopModel initModel() {
        return new ShopModel();
    }

    @Override
    public void getShopData(String url) {
          model.getShopData(url, new IShopContract.IModel.ModelCallBack() {
              @Override
              public void success(Object data) {
                  getView().success(data);
              }

              @Override
              public void error(Throwable throwable) {
                 getView().error(throwable);
              }
          });
    }

    @Override
    public void getTagData(String url) {
         model.getTagData(url, new IShopContract.IModel.ModelCallBack() {
             @Override
             public void success(Object data) {
                 getView().success(data);
             }

             @Override
             public void error(Throwable throwable) {
                getView().error(throwable);
             }
         });
    }
}
