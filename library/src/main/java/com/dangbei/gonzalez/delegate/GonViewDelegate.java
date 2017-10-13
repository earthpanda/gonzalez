package com.dangbei.gonzalez.delegate;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.dangbei.gonzalez.GonScreenAdapter;
import com.dangbei.gonzalez.IGonView;
import com.dangbei.gonzalez.R;

/**
 * Created by guoxiaodong on 2017/8/1
 */
public class GonViewDelegate implements IGonView {
    static final int GON_NO_VALUE = Integer.MIN_VALUE;
    protected View view;
    protected GonScreenAdapter adapter;

    private int gonWidth = GON_NO_VALUE;
    private int gonHeight = GON_NO_VALUE;

    private int gonPaddingLeft = GON_NO_VALUE;
    private int gonPaddingTop = GON_NO_VALUE;
    private int gonPaddingRight = GON_NO_VALUE;
    private int gonPaddingBottom = GON_NO_VALUE;

    private int gonMarginLeft = GON_NO_VALUE;
    private int gonMarginTop = GON_NO_VALUE;
    private int gonMarginRight = GON_NO_VALUE;
    private int gonMarginBottom = GON_NO_VALUE;

    public GonViewDelegate(View view) {
        this.view = view;
        adapter = GonScreenAdapter.getInstance();
    }

    public void initAttributes(Context context, AttributeSet attrs) {
        GonScreenAdapter.getInstance().reset(context.getResources().getDisplayMetrics());

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.GonView);

        gonWidth = typedArray.getInt(R.styleable.GonView_gon_layout_width, GON_NO_VALUE);
        gonHeight = typedArray.getInt(R.styleable.GonView_gon_layout_height, GON_NO_VALUE);

        int padding = typedArray.getInt(R.styleable.GonView_gon_padding, GON_NO_VALUE);

        gonPaddingLeft = typedArray.getInt(R.styleable.GonView_gon_paddingLeft, padding);
        gonPaddingTop = typedArray.getInt(R.styleable.GonView_gon_paddingTop, padding);
        gonPaddingRight = typedArray.getInt(R.styleable.GonView_gon_paddingRight, padding);
        gonPaddingBottom = typedArray.getInt(R.styleable.GonView_gon_paddingBottom, padding);

        int margin = typedArray.getInt(R.styleable.GonView_gon_layout_margin, GON_NO_VALUE);

        gonMarginLeft = typedArray.getInt(R.styleable.GonView_gon_layout_marginLeft, margin);
        gonMarginTop = typedArray.getInt(R.styleable.GonView_gon_layout_marginTop, margin);
        gonMarginRight = typedArray.getInt(R.styleable.GonView_gon_layout_marginRight, margin);
        gonMarginBottom = typedArray.getInt(R.styleable.GonView_gon_layout_marginBottom, margin);

        typedArray.recycle();
    }

    public void setLayoutParams(ViewGroup.LayoutParams params) {
        if (params == null) {
            throw new NullPointerException("Layout parameters cannot be null");
        }

        setGonWidth(params, gonWidth);
        setGonHeight(params, gonHeight);

        setGonMarginLeft(params, gonMarginLeft);
        setGonMarginTop(params, gonMarginTop);
        setGonMarginRight(params, gonMarginRight);
        setGonMarginBottom(params, gonMarginBottom);

        setGonPadding(gonPaddingLeft, gonPaddingTop, gonPaddingRight, gonPaddingBottom);
    }


    @Override
    public void setGonSize(int width, int height) {
        setGonWidth(width);
        setGonHeight(height);
    }

    @Override
    public void setGonWidth(int width) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params != null) {
            setGonWidth(params, width);
        }
    }

    public void setGonWidth(@NonNull ViewGroup.LayoutParams params, int width) {
        if (width == GON_NO_VALUE) {
            return;
        }
        if (GonScreenAdapter.WRAP != width && GonScreenAdapter.MATCH != width) {
            width = adapter.scaleX(width);
        }
        params.width = width;
    }

    @Override
    public void setGonHeight(int height) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params != null) {
            setGonHeight(params, height);
        }
    }

    @Override
    public void setGonPadding(int padding) {
        setGonPadding(padding, padding, padding, padding);
    }

    public void setGonHeight(@NonNull ViewGroup.LayoutParams params, int height) {
        if (height == GON_NO_VALUE) {
            return;
        }
        if (GonScreenAdapter.WRAP != height && GonScreenAdapter.MATCH != height) {
            height = adapter.scaleY(height);
        }
        params.height = height;
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
    public void setGonMargin(int margin) {
        setGonMargin(margin, margin, margin, margin);
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
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params != null) {
            setGonMarginLeft(params, marginLeft);
        }
    }

    private void setGonMarginLeft(@NonNull ViewGroup.LayoutParams params, int marginLeft) {
        if (marginLeft == GON_NO_VALUE) {
            return;
        }
        if (params instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) params).leftMargin = adapter.scaleX(marginLeft);
        }
    }

    @Override
    public void setGonMarginTop(int marginTop) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params != null) {
            setGonMarginTop(params, marginTop);
        }
    }

    private void setGonMarginTop(@NonNull ViewGroup.LayoutParams params, int marginTop) {
        if (marginTop == GON_NO_VALUE) {
            return;
        }
        if (params instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) params).topMargin = adapter.scaleY(marginTop);
        }
    }

    @Override
    public void setGonMarginRight(int marginRight) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params != null) {
            setGonMarginRight(params, marginRight);
        }
    }

    private void setGonMarginRight(@NonNull ViewGroup.LayoutParams params, int marginRight) {
        if (marginRight == GON_NO_VALUE) {
            return;
        }
        if (params instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) params).rightMargin = adapter.scaleX(marginRight);
        }
    }

    @Override
    public void setGonMarginBottom(int marginBottom) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params != null) {
            setGonMarginBottom(params, marginBottom);
        }
    }

    private void setGonMarginBottom(@NonNull ViewGroup.LayoutParams params, int marginBottom) {
        if (marginBottom == GON_NO_VALUE) {
            return;
        }
        if (params instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) params).bottomMargin = adapter.scaleY(marginBottom);
        }
    }
}
