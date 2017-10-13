package com.dangbei.gonzalez;

import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GonScreenAdapter {
    public static final int WRAP = RelativeLayout.LayoutParams.WRAP_CONTENT;
    public static final int MATCH = RelativeLayout.LayoutParams.MATCH_PARENT;
    public final int defaultWidth = 1920;
    public final int defaultHeight = 1080;
    public int screenWidth;
    public int screenHeight;
    private boolean isReset = false;

    private GonScreenAdapter() {
    }

    public static GonScreenAdapter getInstance() {
        return Holder.instance;
    }

    public void reset(DisplayMetrics displayMetrics) {
        if (!isReset) {
            isReset = true;
            screenWidth = displayMetrics.widthPixels;
            screenHeight = displayMetrics.heightPixels == 672 ? 720 : displayMetrics.heightPixels == 1008 ? 1080 : displayMetrics.heightPixels;
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

    private static class Holder {
        private static GonScreenAdapter instance = new GonScreenAdapter();
    }

}
