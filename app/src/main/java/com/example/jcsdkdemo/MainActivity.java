package com.example.jcsdkdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.jcsdk.gameadapter.listener.JCBannerListener;
import com.jcsdk.gameadapter.listener.JCInterstitialListener;

import com.jcsdk.gameadapter.listener.JCRewardVideoListener;
import com.jcsdk.plugin.JCSDKMainActivity;

import com.jcsdk.plugin.JCSDKSimpleProxy;
import com.jcsdk.plugin.listener.JCProxyNativeListener;



public class MainActivity extends JCSDKMainActivity implements View.OnClickListener{

    private static final String LOGGER_TAG = MainActivity.class.getSimpleName();

    int width, height;

    private static boolean canShowAd = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();

        JCSDKSimpleProxy.initInter(mInterListener);
        JCSDKSimpleProxy.initRewardVideo(mRewordListener);

        //Log.e("JCDemoActivity", "JCDemoActivity onCreate");
    }

    private void initView() {
        Button showBannerBtn = findViewById(R.id.show_banner_btn);
        showBannerBtn.setOnClickListener(this);
        Button visibleBannerBtn = findViewById(R.id.visible_banner_btn);
        visibleBannerBtn.setOnClickListener(this);
        Button goneBannerBtn = findViewById(R.id.gone_banner_btn);
        goneBannerBtn.setOnClickListener(this);
        Button showInterBtn = findViewById(R.id.show_inter_btn);
        showInterBtn.setOnClickListener(this);
        Button showVideoBtn = findViewById(R.id.show_rewardvVideo_btn);
        showVideoBtn.setOnClickListener(this);
        Button showNativeBtn = findViewById(R.id.show_native_btn);
        showNativeBtn.setOnClickListener(this);
        Button destroyNativeBtn = findViewById(R.id.destroy_native_btn);
        destroyNativeBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.show_banner_btn:
                JCSDKSimpleProxy.loadBanner(mBannerListener);
                break;
            case R.id.visible_banner_btn:
                JCSDKSimpleProxy.visibleBanner();
                break;
            case R.id.gone_banner_btn:
                JCSDKSimpleProxy.goneBanner();
                break;
            case R.id.show_inter_btn:
                if (JCSDKSimpleProxy.isInterReady()) {
                    JCSDKSimpleProxy.showInter();
                }
                break;
            case R.id.show_rewardvVideo_btn:
                if (JCSDKSimpleProxy.isRewardVideoReady()) {
                    JCSDKSimpleProxy.showRewardVideo();
                }
                break;
            case R.id.show_native_btn:
                width = (int) (getScreenWidth(MainActivity.this) * 0.9);
                height = (int) (getScreenHeight(MainActivity.this) * 0.4);
                JCSDKSimpleProxy.loadNativeAd(width, height,mNativeListener);
                break;
            case R.id.destroy_native_btn:
                JCSDKSimpleProxy.destroyNativeAd();
                break;
            default:
                break;
        }
    }

    private JCBannerListener mBannerListener = new JCBannerListener() {
        @Override
        public void onRequestBannerSuccess() {
            Log.e(LOGGER_TAG, "In-app request banner success.");
        }

        @Override
        public void onRequestBannerFailure(String pCode, String pErrorMsg) {
            Log.e(LOGGER_TAG, "In-app request banner failure.【ErrCode: " + pCode + "=>ErrMsg: " + pErrorMsg + "】");
        }

        @Override
        public void onShowBannerSuccess() {
            Log.e(LOGGER_TAG, "In-app show banner success.");
        }

        @Override
        public void onShowBannerFailure(String pCode, String pErrorMsg) {
            Log.e(LOGGER_TAG, "In-app show banner failure.【ErrCode: " + pCode + "=>ErrMsg: " + pErrorMsg + "】");
        }

        @Override
        public void onRefreshBannerSuccess() {
            Log.e(LOGGER_TAG, "In-app refresh banner success.");
        }

        @Override
        public void onRefreshBannerFailure(String pCode, String pErrorMsg) {
            Log.e(LOGGER_TAG, "In-app refresh banner failure.【ErrCode: " + pCode + "=>ErrMsg: " + pErrorMsg + "】");
        }

        @Override
        public void onClickBanner(String s) {
            Log.i(LOGGER_TAG, "In-app click banner.");
        }
    };

    private JCRewardVideoListener mRewordListener = new JCRewardVideoListener() {
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

    private JCInterstitialListener mInterListener = new JCInterstitialListener() {
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

    private JCProxyNativeListener mNativeListener = new JCProxyNativeListener() {
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