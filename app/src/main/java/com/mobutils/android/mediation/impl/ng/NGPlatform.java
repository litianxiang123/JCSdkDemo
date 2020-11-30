package com.mobutils.android.mediation.impl.ng;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;

import com.jcsdk.gameadapter.listener.JCInterstitialListener;
import com.jcsdk.gameadapter.listener.JCRewardVideoListener;
import com.jcsdk.plugin.JCSDKSimpleProxy;
import com.jcsdk.plugin.listener.JCProxyNativeListener;

/**
 * Created by Administrator
 * on 2020/10/31
 */
public class NGPlatform {
    private static boolean canShowAd = false;
    private static final String LOGGER_TAG = "xxNGPlatform";
    private JCRewardVideoListener mRewordListener;
    private JCInterstitialListener mInterListener;
    private JCProxyNativeListener mNativeListener;
    int width, height;

    public void init(){

        JCSDKSimpleProxy.initInter(mInterListener);
        JCSDKSimpleProxy.initRewardVideo(mRewordListener);
        JCSDKSimpleProxy.loadNativeAd(width, height,mNativeListener);

        JCSDKSimpleProxy.showInter();
        JCSDKSimpleProxy.showRewardVideo();

    }



    public NGPlatform(){

        this.mRewordListener = new JCRewardVideoListener() {
            @Override
            public void onShowVideoSuccess() {
                Log.e(LOGGER_TAG, "In-app show rv success.");
            }

            @Override
            public void onShowVideoFailure(String pCode, String pErrorMsg) {
                Log.e(LOGGER_TAG, "In-app show rv failure.【ErrCode: " + pCode + "=>ErrMsg: " + pErrorMsg + "】");
            }

            @Override
            public void onShowVideoEnd() {
                Log.e(LOGGER_TAG, "In-app show rv end.");
            }

            @Override
            public void onRequestVideoSuccess() {
                Log.e(LOGGER_TAG, "In-app request rv success.");
            }

            @Override
            public void onRequestVideoFailure(String pCode, String pErrorMsg) {
                Log.e(LOGGER_TAG, "In-app request rv failure.【ErrCode: " + pCode + "=>ErrMsg: " + pErrorMsg + "】");
            }

            @Override
            public void onRewarded(boolean b) {
                Log.e(LOGGER_TAG, "In-app rv rewarded.");
            }

            @Override
            public void onVideoClosed() {
                Log.e(LOGGER_TAG, "In-app close rv.");
            }

            @Override
            public void onVideoClick() {
                Log.e(LOGGER_TAG, "In-app click rv.");
            }
        };

        this.mInterListener = new JCInterstitialListener() {
            @Override
            public void onRequestInterSuccess() {
                Log.e(LOGGER_TAG, "In-app request inter success.");
            }

            @Override
            public void onRequestInterFailure(String pCode, String pErrorMsg) {
                Log.e(LOGGER_TAG, "In-app request inter failure.【ErrCode: " + pCode + "=>ErrMsg: " + pErrorMsg + "】");
            }

            @Override
            public void onShowInterSuccess() {
                Log.e(LOGGER_TAG, "In-app show inter success.");
            }

            @Override
            public void onShowInterFailure(String pCode, String pErrorMsg) {
                Log.e(LOGGER_TAG, "In-app show inter failure.【ErrCode: " + pCode + "=>ErrMsg: " + pErrorMsg + "】");
            }

            @Override
            public void onShowInterVideoSuccess() {
                Log.e(LOGGER_TAG, "In-app show inter video success.");
            }

            @Override
            public void onShowInterVideoFailure(String pCode, String pErrorMsg) {
                Log.e(LOGGER_TAG, "In-app show inter video failure.【ErrCode: " + pCode + "=>ErrMsg: " + pErrorMsg + "】");
            }

            @Override
            public void onClosedInter(boolean isClosed) {
                Log.e(LOGGER_TAG, "In-app close inter.");
            }

            @Override
            public void onClickInter() {
                Log.e(LOGGER_TAG, "In-app click inter.");
            }
        };

        this.mNativeListener = new JCProxyNativeListener() {
            @Override
            public void onShowNativeSuccess() {
                Log.e(LOGGER_TAG, "jc native onShowNativeSuccess.");
            }

            @Override
            public void onShowNativeFailure(String s, String s1) {
                Log.e(LOGGER_TAG, "jc native onShowNativeFailure.");
            }

            @Override
            public void onRequestNativeSuccess() {
                JCSDKSimpleProxy.renderNativeAd();
            }

            @Override
            public void onRequestNativeFailure(String s, String s1) {

            }

            @Override
            public void onRenderSuccess() {
                canShowAd = true;
            }

            @Override
            public void onRenderFailure(String s, String s1) {

            }

            @Override
            public void onNativeClose() {

            }

            @Override
            public void onNativeClicked() {

            }
        };
    }


    public int getScreenWidth(Activity activity) {
        DisplayMetrics outMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    public int getScreenHeight(Activity activity) {
        DisplayMetrics outMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }
}
