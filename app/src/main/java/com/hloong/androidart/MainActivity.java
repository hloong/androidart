package com.hloong.androidart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hloong.androidart.utils.LogUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.d("onStart->表示Activity正在被启动，已经可见，但没出现在前台，无法与用户交互；虽然显示出来但是我们不可见");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.d("onResume->表示Activity启动并出现在前台，和onStart的区别就是已经可见了");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.d("onPause->暂停，和onStop一般同时执行，不能执行太耗时的操作");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.d("onStop->表示Activity停止，可以做一些重量级的回收工作，不能执行太耗时的操作");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d("onDestroy->表示Activity销毁，做一些回收工作，和最终的资源释放");
    }
}
