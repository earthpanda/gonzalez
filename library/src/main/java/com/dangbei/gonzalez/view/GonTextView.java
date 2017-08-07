package com.dangbei.gonzalez.view;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.dangbei.gonzalez.IGonView;
import com.dangbei.gonzalez.delegate.GonTextViewDelegate;

/**
 * Created by guoxiaodong on 2017/7/28
 */
public class GonTextView extends AppCompatTextView implements IGonView {
    private GonTextViewDelegate delegate;

    public GonTextView(Context context) {
        super(context);
        init();
    }

    public GonTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        delegate.initAttributes(context, attrs);
    }

    public GonTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        delegate.initAttributes(context, attrs);
    }

    private void init() {
        delegate = new GonTextViewDelegate(this);
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
        delegate.setGonPadding(padding, padding, padding, padding);
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

    @Override
    public void setGonTextSize(int textSize) {
        delegate.setGonTextSize(textSize);
    }

    @Override
    public void setHorizontalCompoundDrawablePadding(int padding) {
        delegate.setHorizontalCompoundDrawablePadding(padding);
    }

    @Override
    public void setVerticalCompoundDrawablePadding(int padding) {
        delegate.setVerticalCompoundDrawablePadding(padding);
    }
}
