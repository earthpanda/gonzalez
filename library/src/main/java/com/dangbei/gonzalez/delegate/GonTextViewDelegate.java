package com.dangbei.gonzalez.delegate;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dangbei.gonzalez.R;

/**
 * Created by guoxiaodong on 2017/8/4
 */
public class GonTextViewDelegate extends GonViewDelegate {
    private int gonTextSize;

    private int horizontalDrawablePadding;
    private int verticalDrawablePadding;

    public GonTextViewDelegate(View view) {
        super(view);
    }

    @Override
    public void initAttributes(Context context, AttributeSet attrs) {
        super.initAttributes(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.GonView);

        gonTextSize = typedArray.getInt(R.styleable.GonView_gon_textSize, GON_NO_VALUE);

        horizontalDrawablePadding = typedArray.getInt(R.styleable.GonView_gon_horizontalDrawablePadding, GON_NO_VALUE);
        verticalDrawablePadding = typedArray.getInt(R.styleable.GonView_gon_verticalDrawablePadding, GON_NO_VALUE);

        typedArray.recycle();
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);

        if (view instanceof TextView) {
            setGonTextSize(gonTextSize);
            setHorizontalCompoundDrawablePadding(horizontalDrawablePadding);
            setVerticalCompoundDrawablePadding(verticalDrawablePadding);
        }
    }
}
