package com.rshealth.viewpagerdemo;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

/**
 *
 * @author gyw
 * @version 1.0
 * @time: 2015-8-19 上午11:47:27
 * @fun:
 */
public abstract class RsBaseActivity extends FragmentActivity implements View.OnClickListener{

	public static RsBaseActivity mActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mActivity = RsBaseActivity.this;
		initContentView();
		initView();
		initData();
		initListener();
		initFragment(savedInstanceState);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}

	//初始化Fragment
	public void initFragment(Bundle savedInstanceState) {
	}


	/**
	 * 设置布局文件
	 */
	public abstract void initContentView();

	public abstract void initView();

	/**
	 * 初始化数据
	 */
	public abstract void initData();

	/**
	 * 设置控件的监听
	 */
	public abstract void initListener();

	@Override
	public void onClick(View v) {

	}
}
