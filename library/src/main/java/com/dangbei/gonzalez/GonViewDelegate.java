package com.dangbei.gonzalez;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by guoxiaodong on 2017/8/1
 */
public class GonViewDelegate implements IGonView {
    private View view;
    private GonScreenAdapter adapter;

    private int gonWidth;
    private int gonHeight;

    private int gonPaddingLeft;
    private int gonPaddingTop;
    private int gonPaddingRight;
    private int gonPaddingBottom;

    private int gonMarginLeft;
    private int gonMarginTop;
    private int gonMarginRight;
    private int gonMarginBottom;
    private int gonTextSize;

    public GonViewDelegate(View view) {
        this.view = view;
        adapter = GonScreenAdapter.getInstance();
    }

    public void initAttributes(Context context, AttributeSet attrs) {
        GonScreenAdapter.getInstance().reset(context.getResources().getDisplayMetrics());

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.GonView);

        gonWidth = typedArray.getInt(R.styleable.GonView_gon_layout_width, -1);
        gonHeight = typedArray.getInt(R.styleable.GonView_gon_layout_height, -1);

        gonPaddingLeft = typedArray.getInt(R.styleable.GonView_gon_paddingLeft, -1);
        gonPaddingTop = typedArray.getInt(R.styleable.GonView_gon_paddingTop, -1);
        gonPaddingRight = typedArray.getInt(R.styleable.GonView_gon_paddingRight, -1);
        gonPaddingBottom = typedArray.getInt(R.styleable.GonView_gon_paddingBottom, -1);

        gonMarginLeft = typedArray.getInt(R.styleable.GonView_gon_layout_marginLeft, -1);
        gonMarginTop = typedArray.getInt(R.styleable.GonView_gon_layout_marginTop, -1);
        gonMarginRight = typedArray.getInt(R.styleable.GonView_gon_layout_marginRight, -1);
        gonMarginBottom = typedArray.getInt(R.styleable.GonView_gon_layout_marginBottom, -1);

        gonTextSize = typedArray.getInt(R.styleable.GonView_gon_textSize, -1);

        typedArray.recycle();
    }

    public void initLayoutParams() {
        setGonWidthHeight(gonWidth, gonHeight);
        setGonMargin(gonMarginLeft, gonMarginTop, gonMarginRight, gonMarginBottom);
        setGonPadding(gonPaddingLeft, gonPaddingTop, gonPaddingRight, gonPaddingBottom);
        if (view instanceof TextView) {
            adapter.scaleTxtSize(view, gonTextSize);
        }
    }


    @Override
    public void setGonWidthHeight(int width, int height) {
        if (GonScreenAdapter.WRAP != width && GonScreenAdapter.MATCH != width) {
            width = adapter.scaleX(width);
        }
        if (GonScreenAdapter.WRAP != height && GonScreenAdapter.MATCH != height) {
            height = adapter.scaleY(height);
        }
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (params != null) {
            params.width = width;
            params.height = height;
        }
    }

    @Override
    public void setGonPadding(int left, int top, int right, int bottom) {
        view.setPadding(adapter.scaleX(left), adapter.scaleY(top), adapter.scaleX(right), adapter.scaleY(bottom));
    }

    @Override
    public void setGonMargin(int left, int top, int right, int bottom) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (params != null) {
            params.setMargins(adapter.scaleX(left), adapter.scaleY(top), adapter.scaleX(right), adapter.scaleY(bottom));
        }
    }

    @Override
    public void setGonTextSize(int textSize) {
        if (view instanceof TextView) {
            adapter.scaleTxtSize(view, textSize);
        }
    }
}
