package com.bing.greenmemory.fragment;

import com.bing.greenmemory.R;
import com.bing.greenmemory.activity.ActivityCtripHotelWeb;
import com.iflytek.voiceads.AdError;
import com.iflytek.voiceads.AdKeys;
import com.iflytek.voiceads.IFLYAdListener;
import com.iflytek.voiceads.IFLYAdSize;
import com.iflytek.voiceads.IFLYBannerAd;
import com.iflytek.voiceads.f.i;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

/**
 * 推荐
 * @author rocky
 *
 */
public class FragmentCategory extends FragmentFrame implements OnClickListener{
	
	private FragmentCategory mSelf = FragmentCategory.this;
	private boolean mIsLoadData;
	private int mFristLoading = 0;
	
	private LinearLayout layout_ads;
	private IFLYBannerAd bannerView;
	private ImageView ivCtripto, ivMeituan;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment_category_layout, null);
		ivCtripto = ((ImageView)view.findViewById(R.id.ivCtripto));
		layout_ads = (LinearLayout)view.findViewById(R.id.layout_adview);
		ivMeituan = (ImageView) view.findViewById(R.id.ivMeituan);
		
		initListeners();
	   	bindData();
		
		return view;
	}
	
    
    /**
	 * 初始化变量
	 */
	private void initVariable() {
	}
    
    /**
	 * 初始化IOC框架不支持的事件
	 */
	private void initListeners() {
		ivCtripto.setOnClickListener(this);
		ivMeituan.setOnClickListener(this);
	}
	
	/**
	 * 绑定数据
	 */
	private void bindData() {
		mIsLoadData = true;
//		mLoadingDialog.showCircleLoadingDialog(true);
		
	    createBannerAd();
	}
    
	public void createBannerAd() {
		//此广告位为Demo专用，广告的展示不产生费用
		String adUnitId = "11819693146FB55C35F127ABC8CD2BC9";
		//创建旗帜广告，传入广告位ID
		bannerView = IFLYBannerAd.createBannerAd(getActivity(), adUnitId);
		//设置请求的广告尺寸
		bannerView.setAdSize(IFLYAdSize.BANNER);
		//设置下载广告前，弹窗提示
		bannerView.setParameter(AdKeys.DOWNLOAD_ALERT, "true");
		
		//请求广告，添加监听器
		bannerView.loadAd(mAdListener);
		//将广告添加到布局
		layout_ads.removeAllViews();
		layout_ads.addView(bannerView);
		
	}
	
	IFLYAdListener mAdListener = new IFLYAdListener(){

		/**
		 * 广告请求成功
		 */
		@Override
		public void onAdReceive() {
			//展示广告
		    bannerView.showAd();
		    
		    Log.d("TAG", "onAdReceive");
		}
		
		/**
		 * 广告请求失败
		 */
		@Override
		public void onAdFailed(AdError error) {
		    Log.d("TAG", "onAdFailed"+error.getErrorCode()+","+
					error.getErrorDescription());
		}

		/**
		 * 广告被点击
		 */
		@Override
		public void onAdClick() {
		    Log.d("TAG", "onAdClick");
		}

		/**
		 * 广告被关闭
		 */
		@Override
		public void onAdClose() {
		    Log.d("TAG", "onAdClose");
		}
    };
    
    /**
     * 绑定一个gridview的点击事件
     * @param pGridView 要绑定的gridview
     */
    private void bindOnItemClick(GridView pGridView) {
    	pGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
			}

			
		});
    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ivCtripto:
			Intent intent = new Intent();
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            intent.putExtra("type", "Ctrip");
            intent.setClass(getActivity(), ActivityCtripHotelWeb.class);
            startActivity(intent);
			break;
		case R.id.ivMeituan:
			Intent iM = new Intent();
            iM.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            iM.putExtra("type", "Meituan");
            iM.setClass(getActivity(), ActivityCtripHotelWeb.class);
            startActivity(iM);
			break;

		default:
			break;
		}
	}
    

}
