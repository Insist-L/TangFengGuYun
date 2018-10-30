package com.hongsou.insist.tangfengguyun.base;

import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * 文件描述：new！！com.example.administrator.myapplication.app.base
 * 作者：fh
 * 创建时间：2018/6/13
 * 更改时间：2018/6/13
 * 版本号：1
 * 作用：fragment基类
 */


public abstract class BaseFragment extends Fragment {
    public Typeface typeface;
    private Dialog mLoadingDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layoutView=inflater.inflate(getLayoutId(),container,false);
        ButterKnife.bind(this,layoutView);

        init();

        // 点击空白区域，关闭软键盘
        layoutView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                getActivity().onTouchEvent(event);
                return false;
            }
        });
        return layoutView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // super.onSaveInstanceState(outState);
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    /**
     * 添加布局
     * @return
     */
    public abstract int getLayoutId();

    public abstract void init();


    public void showToast(String str){
        Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
    }

    /**
     * 解除绑定、以免发生内存泄漏
     */
    public void onMyDestroy(){

    }
    @Override
    public void onDestroy() {
        super.onDestroy();

        onMyDestroy();
    }


}