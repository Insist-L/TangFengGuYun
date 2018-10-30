package com.hongsou.insist.tangfengguyun;


import android.content.Intent;


import com.hongsou.insist.tangfengguyun.base.BaseActivity;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * 欢迎页面
 */
public class WelcomeActivity extends BaseActivity {


    @Override
    protected void init() {
        initView();
        initData();
    }

    @Override
    public int initLayout() {
        return R.layout.module_activity_welcome;
    }

    @Override
    public void initView() {
        initTimer();

    }

    private ScheduledExecutorService mScheduledExecutorService = Executors.newScheduledThreadPool(4);

    /**
     * 设置延时时间
     */
    private void initTimer() {
        mScheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                intentMainAct();
            }
        }, 3, TimeUnit.SECONDS);
    }

    //跳转方向
    private void intentMainAct() {
        Intent mainIntent = null;

        mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
        finish();
    }

    @Override
    public void initData() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
