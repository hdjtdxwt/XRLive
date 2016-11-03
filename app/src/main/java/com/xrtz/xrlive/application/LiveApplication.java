package com.xrtz.xrlive.application;

import android.app.Application;

import com.xrtz.xrlive.handler.CrashHandler;

/**
 * Created by Administrator on 2016/11/2.
 */

public class LiveApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
    }
}
