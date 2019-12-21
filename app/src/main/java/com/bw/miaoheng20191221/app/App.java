package com.bw.miaoheng20191221.app;

import android.app.Application;
import android.content.Context;

/**
 * 时间 :2019/12/21  8:41
 * 作者 :苗恒
 * 功能 :
 */
public class App extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        MyCrashHandler myCrashHandler = new MyCrashHandler();
        Thread.setDefaultUncaughtExceptionHandler(myCrashHandler);
    }

    public static Context getContext() {
        return context;
    }
}
