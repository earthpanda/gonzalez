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

    private int horizontalDrawablePadding;
    private int verticalDrawablePadding;

    public GonViewDelegate(View view) {
        this.view = view;
        adapter = GonScreenAdapter.getInstance();
    }

    public void initAttributes(Context context, AttributeSet attrs) {
        GonScreenAdapter.getInstance().reset(context.getResources().getDisplayMetrics());

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.GonView);

        gonWidth = typedArray.getInt(R.styleable.GonView_gon_layout_width, 0);
        gonHeight = typedArray.getInt(R.styleable.GonView_gon_layout_height, 0);

        gonPaddingLeft = typedArray.getInt(R.styleable.GonView_gon_paddingLeft, 0);
        gonPaddingTop = typedArray.getInt(R.styleable.GonView_gon_paddingTop, 0);
        gonPaddingRight = typedArray.getInt(R.styleable.GonView_gon_paddingRight, 0);
        gonPaddingBottom = typedArray.getInt(R.styleable.GonView_gon_paddingBottom, 0);

        gonMarginLeft = typedArray.getInt(R.styleable.GonView_gon_layout_marginLeft, 0);
        gonMarginTop = typedArray.getInt(R.styleable.GonView_gon_layout_marginTop, 0);
        gonMarginRight = typedArray.getInt(R.styleable.GonView_gon_layout_marginRight, 0);
        gonMarginBottom = typedArray.getInt(R.styleable.GonView_gon_layout_marginBottom, 0);

        gonTextSize = typedArray.getInt(R.styleable.GonView_gon_textSize, 0);

        horizontalDrawablePadding = typedArray.getInt(R.styleable.GonView_gon_horizontalDrawablePadding, 0);
        verticalDrawablePadding = typedArray.getInt(R.styleable.GonView_gon_verticalDrawablePadding, 0);

        typedArray.recycle();
    }

    public void setLayoutParams() {
        setGonSize(gonWidth, gonHeight);
        setGonMargin(gonMarginLeft, gonMarginTop, gonMarginRight, gonMarginBottom);
        setGonPadding(gonPaddingLeft, gonPaddingTop, gonPaddingRight, gonPaddingBottom);

        if (view instanceof TextView) {
            adapter.scaleTextSize(view, gonTextSize);

            int drawablePadding = 0;
            if (horizontalDrawablePadding != -1) {
                drawablePadding = adapter.scaleX(horizontalDrawablePadding);
            } else if (verticalDrawablePadding != -1) {
                drawablePadding = adapter.scaleY(verticalDrawablePadding);
            }
            if (drawablePadding != 0) {
                ((TextView) view).setCompoundDrawablePadding(drawablePadding);
            }
        }
    }


    @Override
    public void setGonSize(int width, int height) {
        if (GonScreenAdapter.WRAP != width && GonScreenAdapter.MATCH != width) {
            width = adapter.scaleX(width);
        }
        if (GonScreenAdapter.WRAP != height && GonScreenAdapter.MATCH != height) {
            height = adapter.scaleY(height);
        }
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params != null) {
            params.width = width;
            params.height = height;
        }
    }

    @Override
    public void setGonWidth(int width) {
        if (GonScreenAdapter.WRAP != width && GonScreenAdapter.MATCH != width) {
            width = adapter.scaleX(width);
        }
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params != null) {
            params.width = width;
        }
    }

    @Override
    public void setGonHeight(int height) {
        if (GonScreenAdapter.WRAP != height && GonScreenAdapter.MATCH != height) {
            height = adapter.scaleY(height);
        }
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params != null) {
            params.height = height;
        }
    }

    @Override
    public void setGonPadding(int left, int top, int right, int bottom) {
        view.setPadding(adapter.scaleX(left), adapter.scaleY(top), adapter.scaleX(right), adapter.scaleY(bottom));
    }

    @Override
    public void setGonMargin(int left, int top, int right, int bottom) {
        ViewGroup.MarginLayoutParams params = null;
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        }
        if (params != null) {
            params.setMargins(adapter.scaleX(left), adapter.scaleY(top), adapter.scaleX(right), adapter.scaleY(bottom));
        }
    }

    @Override
    public void setGonTextSize(int textSize) {
        if (view instanceof TextView) {
            adapter.scaleTextSize(view, textSize);
        }
    }

    @Override
    public void setHorizontalCompoundDrawablePadding(int padding) {
        if (view instanceof TextView) {
            ((TextView) view).setCompoundDrawablePadding(adapter.scaleX(padding));
        }
    }

    @Override
    public void setVerticalCompoundDrawablePadding(int padding) {
        if (view instanceof TextView) {
            ((TextView) view).setCompoundDrawablePadding(adapter.scaleY(padding));
        }
    }
}
