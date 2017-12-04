package com.dangbei.gonzalez;

import android.graphics.drawable.Drawable;

/**
 * Created by guoxiaodong on 2017/10/13 09:47
 */
public interface IGonTextView {
    void setGonTextSize(int textSize);

    void setGonMaxWidth(int maxWidth);

    void setGonMaxHeight(int maxHeight);

    void setGonDrawableLeft(Drawable drawable, int padding, int width, int height);

    void setGonDrawableTop(Drawable drawable, int padding, int width, int height);

    void setGonDrawableRight(Drawable drawable, int padding, int width, int height);

    void setGonDrawableBottom(Drawable drawable, int padding, int width, int height);
}
