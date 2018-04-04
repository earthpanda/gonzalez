package com.dangbei.gonzalez;

/**
 * Created by guoxiaodong on 2017/8/1
 */
public interface IGonView {
    void setGonSize(int width, int height);

    int getGonWidth();

    void setGonWidth(int width);

    int getGonHeight();

    void setGonHeight(int height);

    void setGonPadding(int padding);

    void setGonPadding(int left, int top, int right, int bottom);

    int getGonPaddingLeft();

    void setGonPaddingLeft(int paddingLeft);

    int getGonPaddingTop();

    void setGonPaddingTop(int paddingTop);

    int getGonPaddingRight();

    void setGonPaddingRight(int paddingRight);

    int getGonPaddingBottom();

    void setGonPaddingBottom(int paddingBottom);

    void setGonMargin(int margin);

    void setGonMargin(int left, int top, int right, int bottom);

    int getGonMarginLeft();

    void setGonMarginLeft(int marginLeft);

    int getGonMarginTop();

    void setGonMarginTop(int marginTop);

    int getGonMarginRight();

    void setGonMarginRight(int marginRight);

    int getGonMarginBottom();

    void setGonMarginBottom(int marginBottom);
}
