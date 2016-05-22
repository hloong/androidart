package com.hloong.androidart.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

/**
 * Created by hl on 16/5/7.
 */
public class TouchView extends View{
    private int touchslop;//滑动常量
    GestureDetector mGestureDetector;
    public TouchView(Context context) {
        super(context);
        touchslop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public TouchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public TouchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        VelocityTracker velocityTracker = VelocityTracker.obtain();//追踪当前单机时间的速度
        velocityTracker.addMovement(event);

        velocityTracker.computeCurrentVelocity(1000);//set time 1000ms
        int xVelocity = (int) velocityTracker.getXVelocity();
        int yVelocity = (int) velocityTracker.getYVelocity();
        // reback memory
        velocityTracker.clear();
        velocityTracker.recycle();


        boolean consume = mGestureDetector.onTouchEvent(event);
        return consume;

//        return super.onTouchEvent(event);
    }

    private void initView(Context context) {
        mGestureDetector = new GestureDetector(context,new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                return false;
            }
        });
        mGestureDetector.setIsLongpressEnabled(false);
    }
}
