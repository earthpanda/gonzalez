package com.dangbei.gonzalez;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by guoxiaodong on 2017/7/28
 */
public class GonTextView extends TextView implements IGonView {
    private GonViewDelegate delegate;

    public GonTextView(Context context) {
        this(context, null);
    }

    public GonTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GonTextView(Context context, AttributeSet attrs, int defStyleAttr) {
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
        delegate.initLayoutParams();
    }

    @Override
    public void setGonWidthHeight(int width, int height) {
        delegate.setGonWidthHeight(width, height);
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
}
