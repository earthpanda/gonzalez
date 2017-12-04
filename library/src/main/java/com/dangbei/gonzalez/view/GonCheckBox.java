package com.dangbei.gonzalez.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.dangbei.gonzalez.IGonTextView;
import com.dangbei.gonzalez.IGonView;
import com.dangbei.gonzalez.delegate.GonTextViewDelegate;

/**
 * Created by guoxiaodong on 2017/8/3
 */
public class GonCheckBox extends AppCompatCheckBox implements IGonView, IGonTextView {
    private GonTextViewDelegate delegate;

    public GonCheckBox(Context context) {
        super(context);
        init();
    }

    public GonCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        delegate.initAttributes(context, attrs);
    }

    public GonCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public void setGonPadding(int padding) {
        delegate.setGonPadding(padding);
    }

    @Override
    public void setGonPadding(int left, int top, int right, int bottom) {
        delegate.setGonPadding(left, top, right, bottom);
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
    public int getGonPaddingTop() {
        return delegate.getGonPaddingTop();
    }

    @Override
    public void setGonPaddingTop(int paddingTop) {
        delegate.setGonPaddingTop(paddingTop);
    }

    @Override
    public int getGonMarginBottom() {
        return delegate.getGonMarginBottom();
    }

    @Override
    public void setGonMarginBottom(int marginBottom) {
        delegate.setGonMarginBottom(marginBottom);
    }

    @Override
    public int getGonWidth() {
        return delegate.getGonWidth();
    }

    @Override
    public void setGonWidth(int width) {
        delegate.setGonWidth(width);
    }

    @Override
    public int getGonHeight() {
        return delegate.getGonHeight();
    }

    @Override
    public void setGonHeight(int height) {
        delegate.setGonHeight(height);
    }

    @Override
    public int getGonPaddingLeft() {
        return delegate.getGonPaddingLeft();
    }

    @Override
    public void setGonPaddingLeft(int paddingLeft) {
        delegate.setGonPaddingLeft(paddingLeft);
    }

    @Override
    public int getGonPaddingRight() {
        return delegate.getGonPaddingRight();
    }

    @Override
    public void setGonPaddingRight(int paddingRight) {
        delegate.setGonPaddingRight(paddingRight);
    }

    @Override
    public int getGonPaddingBottom() {
        return delegate.getGonPaddingBottom();
    }

    @Override
    public void setGonPaddingBottom(int paddingBottom) {
        delegate.setGonPaddingBottom(paddingBottom);
    }

    @Override
    public int getGonMarginLeft() {
        return delegate.getGonMarginLeft();
    }

    @Override
    public void setGonMarginLeft(int marginLeft) {
        delegate.setGonMarginLeft(marginLeft);
    }

    @Override
    public int getGonMarginTop() {
        return delegate.getGonMarginTop();
    }

    @Override
    public void setGonMarginTop(int marginTop) {
        delegate.setGonMarginTop(marginTop);
    }

    @Override
    public int getGonMarginRight() {
        return delegate.getGonMarginRight();
    }

    @Override
    public void setGonMarginRight(int marginRight) {
        delegate.setGonPaddingRight(marginRight);
    }

    @Override
    public void setGonTextSize(int textSize) {
        delegate.setGonTextSize(textSize);
    }

    @Override
    public void setGonMaxWidth(int maxWidth) {
        delegate.setGonMaxWidth(maxWidth);
    }

    @Override
    public void setGonMaxHeight(int maxHeight) {
        delegate.setGonMaxHeight(maxHeight);
    }

    @Override
    public void setGonDrawableLeft(Drawable drawable, int padding, int width, int height) {
        delegate.setGonDrawableLeft(drawable, padding, width, height);
    }

    @Override
    public void setGonDrawableTop(Drawable drawable, int padding, int width, int height) {
        delegate.setGonDrawableTop(drawable, padding, width, height);
    }

    @Override
    public void setGonDrawableRight(Drawable drawable, int padding, int width, int height) {
        delegate.setGonDrawableRight(drawable, padding, width, height);
    }

    @Override
    public void setGonDrawableBottom(Drawable drawable, int padding, int width, int height) {
        delegate.setGonDrawableBottom(drawable, padding, width, height);
    }
}