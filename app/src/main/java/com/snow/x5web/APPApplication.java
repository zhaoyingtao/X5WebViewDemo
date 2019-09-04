package com.snow.x5web;

import android.content.Context;
import android.os.Environment;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.snow.common.CommonLibConstant;
import com.tencent.smtt.sdk.QbSdk;

import me.jessyan.autosize.AutoSizeConfig;
import me.jessyan.autosize.unit.Subunits;
import me.jessyan.autosize.utils.LogUtils;

/**
 * author : zyt
 * e-mail : 632105276@qq.com
 * date   : 2019-09-03
 * desc   :
 */
public class APPApplication extends MultiDexApplication {
    private String LOCAL_PATH = Environment.getExternalStorageDirectory().getAbsolutePath()
            + "/Android/data/";

    @Override
    public void onCreate() {
        super.onCreate();
        LOCAL_PATH = LOCAL_PATH + this.getPackageName() + "/";
        init();
    }

    private void init() {
        //今日头条适配配置
        AutoSizeConfig.getInstance().getUnitsManager()
                .setSupportDP(false)
                .setSupportSP(false)
                .setSupportSubunits(Subunits.NONE);
        //common依赖库的相关初始化
        CommonLibConstant.init()
                .setAppContext(this)
                .setNoNetWorkRemind("无网络")
                //存储权限别忘了，别忘记修改存储的数据库名
                .setSharedPreferencesName("x5webview_db")
                .setCrashSavePath(LOCAL_PATH)
                .setExternalNetworkIP();//要设置这个必有连网权限
        //打印的tag搜索：AndroidAutoSize
        LogUtils.e("LOCAL_PATH===" + LOCAL_PATH);
//        QbSdk.setDownloadWithoutWifi(true);
        QbSdk.initX5Environment(this, new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {
                Log.e("snow", "========onCoreInitFinished===");
            }

            @Override
            public void onViewInitFinished(boolean b) {
                Log.e("snow", "x5初始化结果====" + b);
            }
        });
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}