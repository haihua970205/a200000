package com.example.test_kao.ui.me;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.test_kao.MainActivity;
import com.example.test_kao.R;
import com.example.test_kao.adapter.me.MeAdapter;
import com.example.test_kao.base.BaseFragment;
import com.example.test_kao.base.BasePresenter;
import com.example.test_kao.ui.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MeFrag extends BaseFragment {

    @BindView(R.id.login_head)
    ImageView loginHead;
    @BindView(R.id.login_name)
    TextView loginName;
    @BindView(R.id.jump_login)
    ImageView jumpLogin;
    @BindView(R.id.line1)
    RelativeLayout line1;
    @BindView(R.id.channel)
    GridView channel;

    @Override
    public int getLayout(){
        return R.layout.me_frag;
    }

    @Override
    public void initView(){
        loginName.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivityForResult(intent,200);
            }
        });
        jumpLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        loginHead.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //图片二次采样，图片上传
                makeImage();
            }
        });
    }

    private void makeImage(){

    }

    @Override
    public BasePresenter createPersenter(){
        return null;
    }

    @Override
    public void initData(){
        inintNineData();


    }

    private void inintNineData(){
        int [] img = new int[]{
                R.mipmap.dingdan,
                R.mipmap.youhui,
                R.mipmap.lipin,
                R.mipmap.ic_menu_shopping_nor,
                R.mipmap.anquan,
                R.mipmap.kefu,
                R.mipmap.dingwei,
                R.mipmap.anquan,
                R.mipmap.denglu,
                R.mipmap.bangzhu,
                R.mipmap.yijian
        };
        String [] title = new String []{
                "我的订单",
                "优惠券",
                "礼品卡",
                "我的收藏",
                "我的足迹",
                "会员福利",
                "地址管理",
                "账号安全",
                "联系客服",
                "帮助中心",
                "意见反馈"
        };
        List<MyBean> list = new ArrayList<MyBean>();
        for(int i=0;i<title.length;i++){
            MyBean myBean = new MyBean(title[i],img[i]);
            list.add(myBean);
        }
        MeAdapter meAdapter = new MeAdapter(getActivity(), list);
        channel.setAdapter(meAdapter);

       meAdapter.setMyList(new MeAdapter.MyList(){
           @Override
           public void setOnClick(int position){
               //收藏页面
               if(position == 3){
                   Intent intent = new Intent(getActivity(), FavoritesActivity.class);
                   startActivity(intent);
               }
           }
       });

    }
}
