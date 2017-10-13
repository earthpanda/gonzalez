package com.dangbei.gonzalez.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.dangbei.gonzalez.IGonView;
import com.dangbei.gonzalez.delegate.GonViewDelegate;

/**
 * Created by guoxiaodong on 2017/8/3
 */
public class GonScrollView extends ScrollView implements IGonView {
    private GonViewDelegate delegate;

    public GonScrollView(Context context) {
        super(context);
        init();
    }

    public GonScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        delegate.initAttributes(context, attrs);
    }

    public GonScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        delegate.initAttributes(context, attrs);
    }

    private void init() {
        delegate = new GonViewDelegate(this);
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        delegate.setLayoutParams(params);
        super.setLayoutParams(params);
    }

    @Override
    public void setGonSize(int width, int height) {
        delegate.setGonSize(width, height);
    }

    @Override
    public void setGonWidth(int width) {
        delegate.setGonWidth(width);
    }

    @Override
    public void setGonHeight(int height) {
        delegate.setGonHeight(height);
    }

    @Override
    public void setGonPadding(int padding) {
        delegate.setGonPadding(padding);
    }

    @Override
    public void setGonPadding(int left, int top, int right, int bottom) {
        delegate.setGonPadding(left, top, right, bottom);
    }

    @Override
    public void setGonPaddingLeft(int paddingLeft) {
        delegate.setGonPaddingLeft(paddingLeft);
    }

    @Override
    public void setGonPaddingTop(int paddingTop) {
        delegate.setGonPaddingTop(paddingTop);
    }

    @Override
    public void setGonPaddingRight(int paddingRight) {
        delegate.setGonPaddingRight(paddingRight);
    }

    @Override
    public void setGonPaddingBottom(int paddingBottom) {
        delegate.setGonPaddingBottom(paddingBottom);
    }

    @Override
    public void setGonMargin(int margin) {
        delegate.setGonMargin(margin);
    }

    @Override
    public void setGonMargin(int left, int top, int right, int bottom) {
        delegate.setGonMargin(left, top, right, bottom);
    }

    @Override
    public void setGonMarginLeft(int marginLeft) {
        delegate.setGonMarginLeft(marginLeft);
    }

    @Override
    public void setGonMarginTop(int marginTop) {
        delegate.setGonMarginTop(marginTop);
    }

    @Override
    public void setGonMarginRight(int marginRight) {
        delegate.setGonPaddingRight(marginRight);
    }

    @Override
    public void setGonMarginBottom(int marginBottom) {
        delegate.setGonMarginBottom(marginBottom);
    }
}
