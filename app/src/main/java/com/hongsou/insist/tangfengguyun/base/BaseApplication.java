package com.hongsou.insist.tangfengguyun.base;

import android.app.Application;
import android.content.Context;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

/**
 * 文件描述：new！！com.example.administrator.myapplication.app.base
 * 作者：fh
 * 创建时间：2018/6/13
 * 更改时间：2018/6/13
 * 版本号：1
 * 用途：
 */
public class BaseApplication extends Application {

    public static BaseApplication app;


    @Override
    public void onCreate() {
        super.onCreate();

        initApp();

        SpeechUtility.createUtility(this, SpeechConstant.APPID + "=5b934a84");
    }

    private void initApp() {
        app = this;
    }

    public static synchronized Application getInstance() {
        return app;
    }


    public static Context getAppContext() {
        return app.getApplicationContext();
    }

    public static BaseApplication getApplication() {
        return app;
    }

}