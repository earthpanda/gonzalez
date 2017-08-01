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
    private static final int GON_NO_VALUE = -9999;
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

        gonWidth = typedArray.getInt(R.styleable.GonView_gon_layout_width, GON_NO_VALUE);
        gonHeight = typedArray.getInt(R.styleable.GonView_gon_layout_height, GON_NO_VALUE);

        gonPaddingLeft = typedArray.getInt(R.styleable.GonView_gon_paddingLeft, GON_NO_VALUE);
        gonPaddingTop = typedArray.getInt(R.styleable.GonView_gon_paddingTop, GON_NO_VALUE);
        gonPaddingRight = typedArray.getInt(R.styleable.GonView_gon_paddingRight, GON_NO_VALUE);
        gonPaddingBottom = typedArray.getInt(R.styleable.GonView_gon_paddingBottom, GON_NO_VALUE);

        gonMarginLeft = typedArray.getInt(R.styleable.GonView_gon_layout_marginLeft, GON_NO_VALUE);
        gonMarginTop = typedArray.getInt(R.styleable.GonView_gon_layout_marginTop, GON_NO_VALUE);
        gonMarginRight = typedArray.getInt(R.styleable.GonView_gon_layout_marginRight, GON_NO_VALUE);
        gonMarginBottom = typedArray.getInt(R.styleable.GonView_gon_layout_marginBottom, GON_NO_VALUE);

        gonTextSize = typedArray.getInt(R.styleable.GonView_gon_textSize, GON_NO_VALUE);

        horizontalDrawablePadding = typedArray.getInt(R.styleable.GonView_gon_horizontalDrawablePadding, GON_NO_VALUE);
        verticalDrawablePadding = typedArray.getInt(R.styleable.GonView_gon_verticalDrawablePadding, GON_NO_VALUE);

        typedArray.recycle();
    }

    public void setLayoutParams() {
        setGonSize(gonWidth, gonHeight);
        setGonMargin(gonMarginLeft, gonMarginTop, gonMarginRight, gonMarginBottom);
        setGonPadding(gonPaddingLeft, gonPaddingTop, gonPaddingRight, gonPaddingBottom);

        if (view instanceof TextView) {
            setGonTextSize(gonTextSize);
            setHorizontalCompoundDrawablePadding(horizontalDrawablePadding);
            setVerticalCompoundDrawablePadding(verticalDrawablePadding);
        }
    }


    @Override
    public void setGonSize(int width, int height) {
        setGonWidth(width);
        setGonHeight(height);
    }

    @Override
    public void setGonWidth(int width) {
        if (width == GON_NO_VALUE) {
            return;
        }
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
        if (height == GON_NO_VALUE) {
            return;
        }
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
        setGonPaddingLeft(left);
        setGonPaddingTop(top);
        setGonPaddingRight(right);
        setGonPaddingBottom(bottom);
    }

    @Override
    public void setGonPaddingLeft(int paddingLeft) {
        if (paddingLeft == GON_NO_VALUE) {
            return;
        }
        view.setPadding(adapter.scaleX(paddingLeft), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    }

    @Override
    public void setGonPaddingTop(int paddingTop) {
        if (paddingTop == GON_NO_VALUE) {
            return;
        }
        view.setPadding(view.getPaddingLeft(), adapter.scaleY(paddingTop), view.getPaddingRight(), view.getPaddingBottom());
    }

    @Override
    public void setGonPaddingRight(int paddingRight) {
        if (paddingRight == GON_NO_VALUE) {
            return;
        }
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), adapter.scaleX(paddingRight), view.getPaddingBottom());
    }

    @Override
    public void setGonPaddingBottom(int paddingBottom) {
        if (paddingBottom == GON_NO_VALUE) {
            return;
        }
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), adapter.scaleY(paddingBottom));
    }

    @Override
    public void setGonMargin(int left, int top, int right, int bottom) {
        setGonMarginLeft(left);
        setGonMarginTop(top);
        setGonMarginRight(right);
        setGonMarginBottom(bottom);
    }

    @Override
    public void setGonMarginLeft(int marginLeft) {
        if (marginLeft == GON_NO_VALUE) {
            return;
        }
        ViewGroup.MarginLayoutParams params = null;
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        }
        if (params != null) {
            params.leftMargin = adapter.scaleX(marginLeft);
        }
    }

    @Override
    public void setGonMarginTop(int marginTop) {
        if (marginTop == GON_NO_VALUE) {
            return;
        }
        ViewGroup.MarginLayoutParams params = null;
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        }
        if (params != null) {
            params.topMargin = adapter.scaleY(marginTop);
        }
    }

    @Override
    public void setGonMarginRight(int marginRight) {
        if (marginRight == GON_NO_VALUE) {
            return;
        }
        ViewGroup.MarginLayoutParams params = null;
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        }
        if (params != null) {
            params.rightMargin = adapter.scaleX(marginRight);
        }
    }

    @Override
    public void setGonMarginBottom(int marginBottom) {
        if (marginBottom == GON_NO_VALUE) {
            return;
        }
        ViewGroup.MarginLayoutParams params = null;
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        }
        if (params != null) {
            params.bottomMargin = adapter.scaleY(marginBottom);
        }
    }

    @Override
    public void setGonTextSize(int textSize) {
        if (textSize == GON_NO_VALUE) {
            return;
        }
        if (view instanceof TextView) {
            adapter.scaleTextSize(view, textSize);
        }
    }

    @Override
    public void setHorizontalCompoundDrawablePadding(int padding) {
        if (padding == GON_NO_VALUE) {
            return;
        }
        if (view instanceof TextView) {
            ((TextView) view).setCompoundDrawablePadding(adapter.scaleX(padding));
        }
    }

    @Override
    public void setVerticalCompoundDrawablePadding(int padding) {
        if (padding == GON_NO_VALUE) {
            return;
        }
        if (view instanceof TextView) {
            ((TextView) view).setCompoundDrawablePadding(adapter.scaleY(padding));
        }
    }
}
