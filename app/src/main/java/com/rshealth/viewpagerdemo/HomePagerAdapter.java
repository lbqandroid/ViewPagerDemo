package com.rshealth.viewpagerdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 百强 on 2017/1/5.
 */

public class HomePagerAdapter extends FragmentPagerAdapter {
    private List<RsBaseFragment> fragmentList;

    public HomePagerAdapter(FragmentManager fm, List<RsBaseFragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        if (fragmentList == null) {
            return 0;
        } else {
            return fragmentList.size();
        }
    }

//    FragmentPagerAdapter里在根据getItemId(int position)来判断当前position里Fragment是否存在
//    ，如果存在，则不会创建亦不会更新，那么要让FragmentPagerAdapter的更新生效，
//    那在getItemId(int)里根据数据返回一个唯一的数据ID
//    ，当FragmentPagerAdapter更新时，数据ID改变了，
//    那么Fragment就会调用getItem(int)去获取新Fragment
//    ，达到更新效果
    @Override

    public long getItemId(int position) {
        // 获取当前数据的hashCode
        int hashCode = fragmentList.get(position).hashCode();
        return hashCode;
    }
}
