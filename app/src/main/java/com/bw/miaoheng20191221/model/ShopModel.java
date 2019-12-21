package com.bw.miaoheng20191221.model;

import com.bw.miaoheng20191221.contract.IShopContract;
import com.bw.miaoheng20191221.entity.ShopEntity;
import com.bw.miaoheng20191221.entity.TagEntity;
import com.bw.miaoheng20191221.utils.VolleyUtil;
import com.google.gson.Gson;

/**
 * 时间 :2019/12/21  8:46
 * 作者 :苗恒
 * 功能 :
 */
public class ShopModel implements IShopContract.IModel {
    @Override
    public void getShopData(String url, final ModelCallBack modelCallBack) {
        VolleyUtil.getInstance().doGet(url, new VolleyUtil.VolleyCallBack() {
            @Override
            public void success(String response) {
                ShopEntity shopEntity = new Gson().fromJson(response, ShopEntity.class);
                modelCallBack.success(shopEntity);
            }

            @Override
            public void error(Throwable throwable) {
                  modelCallBack.error(throwable);
            }
        });
    }

    @Override
    public void getTagData(String url, final ModelCallBack modelCallBack) {
           VolleyUtil.getInstance().doGet(url, new VolleyUtil.VolleyCallBack() {
               @Override
               public void success(String response) {
                   TagEntity tagEntity = new Gson().fromJson(response, TagEntity.class);
                   modelCallBack.success(tagEntity);
               }

               @Override
               public void error(Throwable throwable) {
                       modelCallBack.error(throwable);
               }
           });
    }
}
