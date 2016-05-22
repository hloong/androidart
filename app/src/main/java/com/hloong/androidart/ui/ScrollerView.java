package com.hloong.androidart.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Scroller;

/**
 * Created by hl on 16/5/22.
 */
public class ScrollerView extends View {
    private Scroller mScroller;

    public ScrollerView(Context context) {
        super(context);
        initView(context);
    }

    public ScrollerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

    public ScrollerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        mScroller = new Scroller(context);


    }

    private void smoothScrollTo(int destX,int destY){
        int scrollX = getScrollX();
        int delta = destX -scrollX;

        mScroller.startScroll(scrollX,0,delta,0,1000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            postInvalidate();
        }
    }
}
