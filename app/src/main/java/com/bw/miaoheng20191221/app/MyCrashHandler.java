package com.bw.miaoheng20191221.app;

import android.util.Log;

import androidx.annotation.NonNull;

/**
 * 时间 :2019/12/21  9:48
 * 作者 :苗恒
 * 功能 :
 */
public class MyCrashHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable throwable) {
        Log.e("error-----",throwable.getMessage());
    }
}
