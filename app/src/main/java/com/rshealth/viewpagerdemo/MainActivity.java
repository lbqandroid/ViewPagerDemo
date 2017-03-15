package com.rshealth.viewpagerdemo;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends RsBaseActivity implements ViewPager.OnPageChangeListener {
    private final String TAG = "MainActivity";
    private int pagerNum;
    private int currentNum = 0;

    @Bind(R.id.pager)
    ViewPager pager;
    @Bind(R.id.btn_pre)
    ImageView btnPre;
    @Bind(R.id.btn_next)
    ImageView btnNext;

    private List<HomeModel> homeList;

    @Override
    public void initContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        homeList = new ArrayList<>();
        // 初始化数据
        for (int i = 0; i < 12; i++) {
            HomeModel homeModel = new HomeModel();
            homeModel.name = "名字" + i;
            homeModel.name_en = "中文名字" + i;
            homeList.add(homeModel);
        }
        Log.d(TAG, "homeList: " + homeList.toString());

        int size = 5;
        List<RsBaseFragment> fragmentList = new ArrayList<>();
        fragmentList.clear();

        //获取被拆分的个数
        pagerNum = homeList.size() % size == 0 ? homeList.size() / size : homeList.size() / size + 1;
        for (int i = 0; i < pagerNum; i++) {
            List<HomeModel> list = new ArrayList<>();
            //把指定索引数据放入到list中
            for (int j = i * size; j <= size * (i + 1) - 1; j++) {
                if (j <= homeList.size() - 1) {
                    list.add(homeList.get(j));
                }
            }
            fragmentList.add(HomeFragment.instance(list));
        }
        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(
                getSupportFragmentManager(), fragmentList);

        pager.setAdapter(homePagerAdapter);

        if (pagerNum > 1) {
            btnPre.setVisibility(View.VISIBLE);
            btnNext.setVisibility(View.VISIBLE);
        } else {
            btnPre.setVisibility(View.INVISIBLE);
            btnNext.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void initListener() {
        pager.setOnPageChangeListener(this);
    }

    @OnClick({R.id.btn_pre, R.id.btn_next})
    void operate(View view) {
        switch (view.getId()) {
            // 向前
            case R.id.btn_pre:
                if (currentNum > 0) {
                    currentNum -= 1;
                    pager.setCurrentItem(currentNum);
                }
                break;
            // 向后
            case R.id.btn_next:
                if (currentNum < pagerNum - 1) {
                    currentNum += 1;
                    pager.setCurrentItem(currentNum);
                }
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        currentNum = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

}
