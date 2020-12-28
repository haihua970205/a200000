package com.example.test_kao;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.test_kao.frag.CateFrag;
import com.example.test_kao.ui.home.HomeFrag;
import com.example.test_kao.ui.me.MeFrag;
import com.example.test_kao.ui.shop.ShopFrag;
import com.example.test_kao.ui.sort.SortFrag;
import com.example.test_kao.ui.topic.TopicFrag;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab;
    private FragmentManager manager;
    private ViewPager vpm;
    private ArrayList<Fragment> flist;
    private String []arr = {"首页","专题","分类","购物车","我的"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        initData();
        initVp();
    }

    private void initVp() {
        flist = new ArrayList<>();
        flist.add(new HomeFrag());
        flist.add(new TopicFrag());
        flist.add(new CateFrag());
        flist.add(new ShopFrag());
        flist.add(new MeFrag());
        if (isChild()){
            return;
        }
        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager());
        vpm.setAdapter(vpAdapter);
        tab.setupWithViewPager(vpm);

        Objects.requireNonNull(tab.getTabAt(0)).setIcon(R.drawable.home_sel);
        Objects.requireNonNull(tab.getTabAt(1)).setIcon(R.drawable.topic_sel);
        Objects.requireNonNull(tab.getTabAt(2)).setIcon(R.drawable.sort_sel);
        Objects.requireNonNull(tab.getTabAt(3)).setIcon(R.drawable.shop_sel);
        Objects.requireNonNull(tab.getTabAt(4)).setIcon(R.drawable.me_sel);

        Intent intent = getIntent();
        int posit = intent.getIntExtra("posit", 0);
        tab.getTabAt(posit).select();
    }



    class VpAdapter extends FragmentStatePagerAdapter {

        public VpAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return flist.get(position);
        }

        @Override
        public int getCount() {
            return flist.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return arr[position];
        }
    }

    private void initView() {
        vpm = (ViewPager) findViewById(R.id.vpm);
        tab = (TabLayout) findViewById(R.id.tab);
    }

}