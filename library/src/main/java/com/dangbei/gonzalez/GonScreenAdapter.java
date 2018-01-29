package com.dangbei.gonzalez;

import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GonScreenAdapter {
    public static final int WRAP = RelativeLayout.LayoutParams.WRAP_CONTENT;
    public static final int MATCH = RelativeLayout.LayoutParams.MATCH_PARENT;
    private int defaultWidth;
    private int defaultHeight;
    private int screenWidth;
    private int screenHeight;
    private boolean isInit = false;

    private GonScreenAdapter() {
    }

    public static GonScreenAdapter getInstance() {
        return Holder.instance;
    }

    public int getDefaultWidth() {
        return defaultWidth;
    }

    public void setDefaultWidth(int defaultWidth) {
        this.defaultWidth = defaultWidth;
    }

    public int getDefaultHeight() {
        return defaultHeight;
    }

    public void setDefaultHeight(int defaultHeight) {
        this.defaultHeight = defaultHeight;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public void init(DisplayMetrics displayMetrics) {
        if (!isInit) {
            isInit = true;
            reset(displayMetrics);
        }
    }

    public void reset(DisplayMetrics displayMetrics) {
        if (screenWidth == 0) {
            screenWidth = displayMetrics.widthPixels;
        }
        if (screenHeight == 0) {
            screenHeight = displayMetrics.heightPixels == 672 ? 720 : displayMetrics.heightPixels == 1008 ? 1080 : displayMetrics.heightPixels;
        }
        if (defaultWidth == 0) {
            defaultWidth = screenWidth > screenHeight ? 1920 : 1080;
        }
        if (defaultHeight == 0) {
            defaultHeight = screenWidth > screenHeight ? 1080 : 1920;
        }
    }

    /**
     * 字体适配(只适配TextView及TextView的子类)
     */
    public void scaleTextSize(View v, float size) {
        if (v instanceof TextView) {
            int txtSize = (int) (size / defaultHeight * screenHeight);
            ((TextView) v).setTextSize(TypedValue.COMPLEX_UNIT_PX, txtSize);
        }
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

    private static class Holder {
        private static GonScreenAdapter instance = new GonScreenAdapter();
    }

}
