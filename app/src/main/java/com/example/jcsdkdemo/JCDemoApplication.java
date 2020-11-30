package com.example.jcsdkdemo;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

import com.jcsdk.plugin.JCSDKApplication;

/**
 * Created by Administrator
 * on 2020/10/21
 */
public class JCDemoApplication extends JCSDKApplication {

    @Override
    protected void attachBaseContext(Context base) {
        Log.e("JCDemoApplication", "Application attachBaseContext.");
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        Log.e("JCDemoApplication", "Application onCreate.");
        super.onCreate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.e("JCDemoApplication", "Application onConfigurationChanged.");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onTerminate() {
        Log.e("JCDemoApplication", "Application onTerminate.");
        super.onTerminate();
    }

}
