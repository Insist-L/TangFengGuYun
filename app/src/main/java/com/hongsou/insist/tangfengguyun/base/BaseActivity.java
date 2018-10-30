package com.hongsou.insist.tangfengguyun.base;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * 文件描述：new！！com.example.administrator.myapplication.app.base  Activity基类
 * 作者：fh
 * 创建时间：2018/6/12
 * 更改时间：2018/6/12
 * 版本号：1
 */


public abstract class BaseActivity extends AppCompatActivity {

    public Typeface typeface;
    private TextView finish_back;
    private TextView title;
    /***获取TAG的activity名称**/
    protected final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置布局
        setContentView(initLayout());
        ButterKnife.bind(this);
        init();
    }



    public void setIconFont(TextView[] tv) {
        for (int i = 0; i < tv.length; i++) {
            tv[i].setTypeface(typeface);
        }
    }

    /**
     * 设置布局
     *
     * @return
     */
    public abstract int initLayout();

    //初始化
    protected abstract void init();

    /**
     * 初始化布局
     */
    public void initView(){}

    /**
     * 设置数据
     */
    public abstract void initData();

    public void showToast(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
