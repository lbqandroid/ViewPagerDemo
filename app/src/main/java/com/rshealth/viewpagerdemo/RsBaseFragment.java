package com.rshealth.viewpagerdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public abstract class RsBaseFragment extends Fragment implements View.OnClickListener {

	
	protected RsBaseActivity mActivity;
	protected View view = null;
	protected Context mContext;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mActivity = (RsBaseActivity) activity;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (view == null) {
			view = initContentView(inflater, container);
			initView();
			initData();
			initListener();
		} else {
			ViewParent parent = view.getParent();
			if (parent != null && parent instanceof ViewGroup) {
				ViewGroup group = (ViewGroup) parent;
				group.removeView(view);
			}
		}
		return view;
	}

	/**
	 * 设置布局文件
	 */
	protected abstract View initContentView(LayoutInflater inflater, ViewGroup container);

	/**
	 * 初始化布局文件中的控件
	 */
	protected abstract void initView();

	/**
	 * 设置控件的监听
	 */
	protected abstract void initListener();

	/**
	 * 初始化数据 
	 */
	protected abstract void initData();

	@Override
	public void onClick(View v) {

	}
}
