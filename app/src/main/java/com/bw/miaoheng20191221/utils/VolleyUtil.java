package com.bw.miaoheng20191221.utils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bw.miaoheng20191221.app.App;

/**
 * 时间 :2019/12/21  8:40
 * 作者 :苗恒
 * 功能 :
 */
public class VolleyUtil {
    private static VolleyUtil volleyUtil;
    private final RequestQueue requestQueue;

    private VolleyUtil() {
        requestQueue = Volley.newRequestQueue(App.getContext());
    }

    public static VolleyUtil getInstance() {
        if(volleyUtil==null){
            synchronized (VolleyUtil.class){
                if(volleyUtil==null){
                    volleyUtil=new VolleyUtil();
                }
            }
        }
        return volleyUtil;
    }
    public void doGet(String url, final VolleyCallBack volleyCallBack){
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                 volleyCallBack.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                 volleyCallBack.error(error);
            }
        });
        requestQueue.add(stringRequest);
    }
    public interface VolleyCallBack{
        void success(String response);
        void error(Throwable throwable);
    }
}
