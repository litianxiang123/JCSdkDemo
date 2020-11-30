package com.example.jcsdkdemo;

import com.jcsdk.plugin.JCSDKSimpleProxy;
import com.jcsdk.plugin.listener.JCProxyNativeListener;

public class JCNativeAdDemo {

    private static boolean canShowAd = false;

    public void loadNativeAd() {
        JCSDKSimpleProxy.loadNativeAd(100, 200, new JCProxyNativeListener() {
            @Override
            public void onShowNativeSuccess() {

            }

            @Override
            public void onShowNativeFailure(String pCode, String pErrorMsg) {

            }

            @Override
            public void onRequestNativeSuccess() {
                JCSDKSimpleProxy.renderNativeAd();
            }

            @Override
            public void onRequestNativeFailure(String pCode, String pErrorMsg) {

            }

            @Override
            public void onRenderSuccess() {
                canShowAd = true;
            }

            @Override
            public void onRenderFailure(String pCode, String pErrorMsg) {

            }

            @Override
            public void onNativeClose() {

            }

            @Override
            public void onNativeClicked() {

            }
        });
    }

    public void showNativeAd() {
        if (canShowAd) {
            JCSDKSimpleProxy.showNativeAd(20, 30);
        }
    }

    public void destroyNativeAd() {
        JCSDKSimpleProxy.destroyNativeAd();
        canShowAd = false;
    }

}
