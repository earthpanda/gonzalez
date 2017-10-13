package com.dangbei.gonzalez;

/**
 * Created by guoxiaodong on 2017/8/1
 */
public interface IGonView {
    void setGonSize(int width, int height);

    void setGonWidth(int width);

    void setGonHeight(int height);

    void setGonPadding(int padding);

    void setGonPadding(int left, int top, int right, int bottom);

    void setGonPaddingLeft(int paddingLeft);

    void setGonPaddingTop(int paddingTop);

    void setGonPaddingRight(int paddingRight);

    void setGonPaddingBottom(int paddingBottom);

    void setGonMargin(int margin);

    void setGonMargin(int left, int top, int right, int bottom);

    void setGonMarginLeft(int marginLeft);

    void setGonMarginTop(int marginTop);

    void setGonMarginRight(int marginRight);

    void setGonMarginBottom(int marginBottom);
}
