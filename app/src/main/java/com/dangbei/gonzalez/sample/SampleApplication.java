package com.dangbei.gonzalez.sample;

import android.app.Application;

import com.dangbei.gonzalez.GonScreenAdapter;

/**
 * Created by guoxiaodong on 2017/7/28
 */
public class SampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        GonScreenAdapter.getInstance().reset(getResources().getDisplayMetrics());
    }
}
