package com.dangbei.gonzalez;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GonScreenAdapter {
    private boolean isReset = false;

    private static class Holder {
        private static GonScreenAdapter instance = new GonScreenAdapter();
    }

    public static GonScreenAdapter getInstance() {
        return Holder.instance;
    }

    public static final int WRAP = RelativeLayout.LayoutParams.WRAP_CONTENT;
    public static final int MATCH = RelativeLayout.LayoutParams.MATCH_PARENT;
    private final int defaultWidth = 1920;
    private final int defaultHeight = 1080;
    private int screenWidth;
    private int screenHeight;
    private float scaledDensity;

    private GonScreenAdapter() {
    }

    public void reset(DisplayMetrics displayMetrics) {
        if (!isReset) {
            isReset = true;
            scaledDensity = displayMetrics.scaledDensity;
            screenWidth = displayMetrics.widthPixels;
            screenHeight = displayMetrics.heightPixels == 672 ? 720 : displayMetrics.heightPixels == 1008 ? 1080 : displayMetrics.heightPixels;
        }
    }

    /**
     * 字体适配(只适配TextView及TextView的子类)
     */
    public void scaleTxtSize(View v, float size) {
        if (v instanceof TextView) {
            float txtSize = size / Math.min(defaultWidth, defaultHeight) * Math.min(screenWidth, screenHeight) / scaledDensity;
            ((TextView) v).setTextSize(txtSize);
        }
    }

    /**
     * 控件适配(动态添加的控件要先自己添加LayoutParams)
     */
    public void scaleView(View v, int w, int h, int l, int t, int r, int b) {
        if (WRAP != w && MATCH != w) {
            w = scaleX(w);
        }
        if (WRAP != h && MATCH != h) {
            h = scaleY(h);
        }
        l = scaleX(l);
        t = scaleY(t);
        r = scaleX(r);
        b = scaleY(b);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
        if (params != null) {
            params.width = w;
            params.height = h;
            params.setMargins(l, t, r, b);
        }
    }

    /**
     * 控件适配(动态添加的控件要先自己添加LayoutParams)
     */
    public void scaleView(View v, int w, int h, int l, int t) {
        scaleView(v, w, h, l, t, 0, 0);
    }

    /**
     * 控件适配(动态添加的控件要先自己添加LayoutParams)
     */
    public void scaleView(View v, int w, int h) {
        scaleView(v, w, h, 0, 0);
    }

    /**
     * @return !=0
     */
    public int scaleX(int x) {
        int scaleX = Math.round(x * screenWidth / (float) defaultWidth);

        if (scaleX == 0 && x != 0) {
            scaleX = x < 0 ? -1 : 1;
        }

        return scaleX;
    }

    /**
     * @return !=0
     */
    public int scaleY(int y) {
        int scaleY = Math.round(y * screenHeight / (float) defaultHeight);

        if (scaleY == 0 && y != 0) {
            scaleY = y < 0 ? -1 : 1;
        }

        return scaleY;
    }

}
