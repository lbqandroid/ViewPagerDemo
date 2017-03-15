package com.rshealth.viewpagerdemo;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 百强 on 2017/1/6.
 */

public class HomeFragment extends RsBaseFragment {
    private static final String TYPE = "homelist";
    private List<HomeModel> homeList;
    HomeGridViewAdapter adapter;
    @Bind(R.id.gv_home)
    MyGridView gvHome;

    public static HomeFragment instance(List<HomeModel> homelist) {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("homelist", (ArrayList<? extends Parcelable>) homelist);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected View initContentView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_home, null);
        return view;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this, view);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        setData();
    }

    private void setData(){
        homeList = getArguments().getParcelableArrayList(TYPE);
        if(adapter != null){
            adapter.notifyDataSetChanged();
        } else {
            adapter = new HomeGridViewAdapter(mActivity, homeList);
            gvHome.setAdapter(adapter);
        }
    }

}
