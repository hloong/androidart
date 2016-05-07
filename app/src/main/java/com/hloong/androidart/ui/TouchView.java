package com.hloong.androidart.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;

/**
 * Created by hl on 16/5/7.
 */
public class TouchView extends View{
    private int touchslop;//滑动常量
    public TouchView(Context context) {
        super(context);
        touchslop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public TouchView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
