package com.bw.miaoheng20191221;

import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.bw.miaoheng20191221.app.App;

/**
 * 时间 :2019/12/21  9:43
 * 作者 :苗恒
 * 功能 :
 */
public class JsToAndroid {
    @JavascriptInterface
    public void getData(){
        Toast.makeText(App.getContext(), "无参调用gandroid方法", Toast.LENGTH_SHORT).show();
    }
    @JavascriptInterface
    public void getData(String s){
        Toast.makeText(App.getContext(), s, Toast.LENGTH_SHORT).show();
    }
}
