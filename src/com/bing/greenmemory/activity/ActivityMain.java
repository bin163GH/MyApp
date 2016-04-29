package com.bing.greenmemory.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.bing.greenmemory.R;
import com.bing.greenmemory.fragment.FragmentCategory;
import com.bing.greenmemory.fragment.FragmentMy;
import com.bing.greenmemory.fragment.FragmentRecommend;
import com.bing.greenmemory.fragment.FragmentSearch;

public class ActivityMain extends ActivityFrame implements OnClickListener{

	private Button btnRecommend, btnChannel, btnSearch, btnMy;
	
	/** 保存上次加载的fragment，加载新fragment前先把老的删除 */
	private Fragment mLastFrament;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initVariable();
		initListeners();
		setupFragment(0); // 默认安装推荐Fragment
	}

	/**
	 * 初始化变量
	 */
	private void initVariable() {
		btnRecommend = (Button) findViewById(R.id.btnRecommend);
		btnChannel = (Button) findViewById(R.id.btnChannel);
		btnMy = (Button) findViewById(R.id.btnMy);
		btnSearch = (Button) findViewById(R.id.btnSearch);
	}

	/**
	 * 初始化  事件
	 */
	private void initListeners() {
		btnChannel.setOnClickListener(this);
		btnMy.setOnClickListener(this);
		btnRecommend.setOnClickListener(this);
		btnSearch.setOnClickListener(this);
	}
	/**
	 * 安装Fragment
	 * 
	 * @param pIndex 索引
	 */
	private void setupFragment(int pIndex) {
		/*btnRecommend.setBackgroundResource(R.drawable.activity_frame_bottom_bar_recommend_btn_selector);
		btnChannel.setBackgroundResource(R.drawable.activity_frame_bottom_bar_channel_btn_selector);
		btnSearch.setBackgroundResource(R.drawable.activity_frame_bottom_bar_search_btn_selector);
		btnMy.setBackgroundResource(R.drawable.activity_frame_bottom_bar_my_btn_selector);*/
		
 		FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
 		Fragment fragment;
		switch (pIndex) {
		case 0:
			fragment = new FragmentRecommend();
//			btnRecommend.setBackgroundResource(R.drawable.common_recommend_select);
			break;
		case 1:
			fragment = new FragmentCategory();
//			btnChannel.setBackgroundResource(R.drawable.common_channel_select);
			break;
		case 2:
			fragment = new FragmentSearch();
//			btnSearch.setBackgroundResource(R.drawable.common_search_select);
			break;
		case 3:
			fragment = new FragmentMy();
//			fragment = new FragmentMyFavoriteOrMyDownload_();
//			btnMy.setBackgroundResource(R.drawable.common_my_select);
			break;
		default:
			fragment = new FragmentRecommend();
//			btnRecommend.setBackgroundResource(R.drawable.common_recommend_select);
			break;
		}
		
		//如果两次加载的fragment都一样则不要重复加载了，保持原样不变
		if (mLastFrament != null && mLastFrament.getClass().toString().equals(fragment.getClass().toString())) { //本次加载的fragment如果不为空并且和上次一样，就直接退出不重新加载了
			return;
		}
		if (mLastFrament != null) { //上次加载的fragment不为空才移除上次加载的fragment
			fragmentTransaction.remove(mLastFrament);
		}
		mLastFrament = fragment;
		fragmentTransaction.replace(R.id.rellayBody, fragment);
		fragmentTransaction.commit();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnRecommend:
			setupFragment(0);
			break;
		case R.id.btnChannel:
			setupFragment(1);
			break;
		case R.id.btnSearch:
			setupFragment(2);
			break;
		case R.id.btnMy:
			setupFragment(3);
			break;
		default:
			break;
		}
	}
}
