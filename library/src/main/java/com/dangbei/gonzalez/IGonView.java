package com.dangbei.gonzalez;

/**
 * Created by guoxiaodong on 2017/8/1
 */
public interface IGonView {
    void setGonSize(int width, int height);

    void setGonWidth(int width);

    void setGonHeight(int height);

    void setGonPadding(int left, int top, int right, int bottom);

    void setGonMargin(int left, int top, int right, int bottom);

    void setGonTextSize(int textSize);

    void setHorizontalCompoundDrawablePadding(int padding);

    void setVerticalCompoundDrawablePadding(int padding);
}
