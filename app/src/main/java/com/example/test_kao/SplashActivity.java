package com.example.test_kao;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

import com.example.test_kao.adapter.splash.SplashVP;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class SplashActivity extends AppCompatActivity {
    @BindView(R.id.ll_splash)
    ConstraintLayout llSplash;
    //        @BindView(R.id.vp_splash)
//    ViewPager vpSplash;
    private ArrayList<View> views;
    Disposable disposable;
    private TextView tv_timer;
    private ViewPager vpSpash;
    private TextView jump;
    private List<Integer> integerList;
    private PopupWindow pw;
    private boolean aBoolean = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        initView();
    }

    private void initView() {
//        views = new ArrayList<View>();
//        View p1 = LayoutInflater.from(this).inflate(R.layout.page1, null);
//        View p2 = LayoutInflater.from(this).inflate(R.layout.page2, null);
//        View p3 = LayoutInflater.from(this).inflate(R.layout.page3, null);
//        views.add(p1);
//        views.add(p2);
//        views.add(p3);

        integerList = new ArrayList<>();
        integerList.add(R.drawable.a5);
        integerList.add(R.drawable.a6);
        integerList.add(R.drawable.f);

        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_pop, null);
        vpSpash = inflate.findViewById(R.id.vp_splash);
//        vpSpash = findViewById(R.id.vp_splash);
        tv_timer = inflate.findViewById(R.id.tv_timer);
        //点按钮跳转
        jump = inflate.findViewById(R.id.jump);

        pw = new PopupWindow(inflate, -1, -1);
        SplashVP splashVP = new SplashVP(this, views, integerList);
        vpSpash.setAdapter(splashVP);
        addPageClick();

        pw.showAsDropDown(this.findViewById(R.id.ll_splash));

    }


    private void addPageClick() {


        //页码的点击监听
        vpSpash.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 2) {//在最后一页执行倒计时
                    jump.setVisibility(View.VISIBLE);
                    tv_timer.setVisibility(View.VISIBLE);
                    jump.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v){
                            startActivity(new Intent(SplashActivity.this, MainActivity.class));
                            cancelCallback();
                            pw.dismiss();
                        }
                    });


                    //TODO            Interval操作符(有范围)：创建一个按照固定时间发射整数序列的Observable
                    disposable = Observable.intervalRange(0, 4, 0, 1, TimeUnit.SECONDS) //起始值，发送总数量，初始延迟，固定延迟
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            //两种写法    1. lambda表达式写法：
//                            .subscribe(time -> tv_timer.setText((10 - time) + "s"),
//                                    Throwable::printStackTrace,
//                                    () -> {
//                                        startActivity(new Intent(SplashActivity.this,MainActivity.class));
//                                    }
//                            );

                            .subscribe(new Consumer<Long>() {
                                @Override
                                public void accept(Long aLong) throws Exception {
                                    long time = 3 - aLong;
                                    tv_timer.setText(time + "s");
                                    if (time == 0) {
                                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                                        pw.dismiss();
                                    }
                                }
                            });
                } else {
                    cancelCallback();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (aBoolean) {
            initView();
            aBoolean = false;

        }

    }

    //取消订阅的方法
    private void cancelCallback() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
