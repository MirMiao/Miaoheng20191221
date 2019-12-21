package com.bw.miaoheng20191221.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bw.miaoheng20191221.JsToAndroid;
import com.bw.miaoheng20191221.R;

public class Main2Activity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/hello.html");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                webView.loadUrl("file:///android_asset/hello.html");
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        webView.addJavascriptInterface(new JsToAndroid(),"jsToAndroid");
    }

    public void qu(View view) {
        String s="我是android过来的";
          webView.loadUrl("javascript:name('"+s+"')");
    }
}
