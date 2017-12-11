package com.dangbei.gonzalez.delegate;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dangbei.gonzalez.IGonTextView;
import com.dangbei.gonzalez.R;

/**
 * Created by guoxiaodong on 2017/8/4
 */
public class GonTextViewDelegate extends GonViewDelegate implements IGonTextView {
    private int gonTextSize;
    private int drawableWidth;
    private int drawableHeight;
    private int drawablePadding;
    private Drawable drawableLeft;
    private Drawable drawableTop;
    private Drawable drawableRight;
    private Drawable drawableBottom;
    private int gonMaxWidth;
    private int gonMaxHeight;

    public GonTextViewDelegate(View view) {
        super(view);
    }

    @Override
    public void initAttributes(Context context, AttributeSet attrs) {
        super.initAttributes(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.GonView);

        gonTextSize = typedArray.getInt(R.styleable.GonView_gon_textSize, GON_NO_VALUE);
        drawableWidth = typedArray.getInt(R.styleable.GonView_gon_drawableWidth, GON_NO_VALUE);
        drawableHeight = typedArray.getInt(R.styleable.GonView_gon_drawableHeight, GON_NO_VALUE);
        drawablePadding = typedArray.getInt(R.styleable.GonView_gon_drawablePadding, GON_NO_VALUE);

        drawableLeft = typedArray.getDrawable(R.styleable.GonView_android_drawableLeft);
        drawableTop = typedArray.getDrawable(R.styleable.GonView_android_drawableTop);
        drawableRight = typedArray.getDrawable(R.styleable.GonView_android_drawableRight);
        drawableBottom = typedArray.getDrawable(R.styleable.GonView_android_drawableBottom);

        gonMaxWidth = typedArray.getInt(R.styleable.GonView_gon_layout_max_width, GON_NO_VALUE);
        gonMaxHeight = typedArray.getInt(R.styleable.GonView_gon_layout_max_height, GON_NO_VALUE);

        typedArray.recycle();
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);

        if (view instanceof TextView) {
            setGonTextSize(gonTextSize);
            if (drawableLeft != null) {
                setGonDrawableLeft(drawableLeft, drawablePadding, drawableWidth, drawableHeight);
            }
            if (drawableTop != null) {
                setGonDrawableTop(drawableTop, drawablePadding, drawableWidth, drawableHeight);
            }
            if (drawableRight != null) {
                setGonDrawableRight(drawableRight, drawablePadding, drawableWidth, drawableHeight);
            }
            if (drawableBottom != null) {
                setGonDrawableBottom(drawableBottom, drawablePadding, drawableWidth, drawableHeight);
            }
            setGonMaxWidth(gonMaxWidth);
            setGonMaxHeight(gonMaxHeight);
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
    public void setGonMaxWidth(int maxWidth) {
        if (maxWidth == GON_NO_VALUE) {
            return;
        }
        if (view instanceof TextView) {
            ((TextView) view).setMaxWidth(adapter.scaleX(maxWidth));
        }
    }

    @Override
    public void setGonMaxHeight(int maxHeight) {
        if (maxHeight == GON_NO_VALUE) {
            return;
        }
        if (view instanceof TextView) {
            ((TextView) view).setMaxHeight(adapter.scaleY(maxHeight));
        }
    }

    @Override
    public void setGonDrawableLeft(Drawable drawable, int padding, int width, int height) {
        if (padding == GON_NO_VALUE || width == GON_NO_VALUE || height == GON_NO_VALUE) {
            return;
        }
        if (view instanceof TextView) {
            ((TextView) view).setCompoundDrawablePadding(adapter.scaleX(padding));
            ((TextView) view).setCompoundDrawables(drawable, null, null, null);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, adapter.scaleX(width), adapter.scaleY(height));
        }
    }

    @Override
    public void setGonDrawableTop(Drawable drawable, int padding, int width, int height) {
        if (padding == GON_NO_VALUE || width == GON_NO_VALUE || height == GON_NO_VALUE) {
            return;
        }
        if (view instanceof TextView) {
            ((TextView) view).setCompoundDrawablePadding(adapter.scaleY(padding));
            ((TextView) view).setCompoundDrawables(null, drawable, null, null);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, adapter.scaleX(width), adapter.scaleY(height));
        }
    }

    @Override
    public void setGonDrawableRight(Drawable drawable, int padding, int width, int height) {
        if (padding == GON_NO_VALUE || width == GON_NO_VALUE || height == GON_NO_VALUE) {
            return;
        }
        if (view instanceof TextView) {
            ((TextView) view).setCompoundDrawablePadding(adapter.scaleX(padding));
            ((TextView) view).setCompoundDrawables(null, null, drawable, null);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, adapter.scaleX(width), adapter.scaleY(height));
        }
    }

    @Override
    public void setGonDrawableBottom(Drawable drawable, int padding, int width, int height) {
        if (padding == GON_NO_VALUE || width == GON_NO_VALUE || height == GON_NO_VALUE) {
            return;
        }
        if (view instanceof TextView) {
            ((TextView) view).setCompoundDrawablePadding(adapter.scaleY(padding));
            ((TextView) view).setCompoundDrawables(null, null, null, drawable);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, adapter.scaleX(width), adapter.scaleY(height));
        }
    }
}
