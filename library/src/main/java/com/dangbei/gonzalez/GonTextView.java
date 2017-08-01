package com.dangbei.gonzalez;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by guoxiaodong on 2017/7/28
 */
public class GonTextView extends TextView {

    private static final String TAG = GonTextView.class.getSimpleName();
    private int width;
    private int height;

    public GonTextView(Context context) {
        this(context, null);
    }

    public GonTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttributes(context, attrs);
    }

    public GonTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttributes(context, attrs);
    }

    private void initAttributes(Context context, AttributeSet attrs) {
        GonScreenAdapter.getInstance().reset(getResources().getDisplayMetrics());
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.GonTextView);
        width = typedArray.getInt(R.styleable.GonTextView_gon_layout_width, -1);
        height = typedArray.getInt(R.styleable.GonTextView_gon_layout_height, -1);
        typedArray.recycle();
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);
        if (null != params) {
            params.width = GonScreenAdapter.getInstance().scaleX(width);
            params.height = GonScreenAdapter.getInstance().scaleY(height);
        }
        Log.i(TAG, "setLayoutParams...params: " + params);
    }


}
