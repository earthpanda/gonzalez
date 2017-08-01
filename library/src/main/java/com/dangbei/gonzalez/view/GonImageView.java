package com.dangbei.gonzalez.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dangbei.gonzalez.GonViewDelegate;
import com.dangbei.gonzalez.IGonView;

/**
 * Created by guoxiaodong on 2017/8/1
 */
public class GonImageView extends ImageView implements IGonView {
    private GonViewDelegate delegate;

    public GonImageView(Context context) {
        super(context);
        init();
    }

    public GonImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        delegate.initAttributes(context, attrs);
    }

    public GonImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        delegate.initAttributes(context, attrs);
    }

    private void init() {
        delegate = new GonViewDelegate(this);
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);
        delegate.setLayoutParams();
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
    public void setGonPadding(int left, int top, int right, int bottom) {
        delegate.setGonPadding(left, top, right, bottom);
    }

    @Override
    public void setGonMargin(int left, int top, int right, int bottom) {
        delegate.setGonMargin(left, top, right, bottom);
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
