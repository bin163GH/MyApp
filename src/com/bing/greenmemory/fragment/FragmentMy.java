package com.bing.greenmemory.fragment;

import com.bing.greenmemory.R;
import com.iflytek.voiceads.AdError;
import com.iflytek.voiceads.AdKeys;
import com.iflytek.voiceads.IFLYAdListener;
import com.iflytek.voiceads.IFLYAdSize;
import com.iflytek.voiceads.IFLYBannerAd;
import com.iflytek.voiceads.IFLYInterstitialAd;
import com.iflytek.voiceads.f.i;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

/**
 * 推荐
 * @author rocky
 *
 */
public class FragmentMy extends FragmentFrame {
	
	private FragmentMy mSelf = FragmentMy.this;
	private boolean mIsLoadData;
	private int mFristLoading = 0;
	
	private IFLYInterstitialAd interstitialAd;
	private TextView mTextView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment_recomment_layout, null);
		mTextView = ((TextView)view.findViewById(R.id.txtView_tip));
		
	    mTextView.setText("requesting");
	   
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
	}
	
	/**
	 * 绑定数据
	 */
	private void bindData() {
		mIsLoadData = true;
//		mLoadingDialog.showCircleLoadingDialog(true);
		
	    createInterstitialAd();
	}
    
	public void createInterstitialAd() {
		//此广告位为Demo专用，广告的展示不产生费用
	    final String adUnitId = "B8ECED46958DB514645C7058B9ED53D6";
	    //创建插屏广告，传入广告位ID
		interstitialAd = IFLYInterstitialAd.createInterstitialAd(getActivity(), adUnitId);
	    //设置广告尺寸
	    interstitialAd.setAdSize(IFLYAdSize.INTERSTITIAL);
		//设置下载广告前，弹窗提示
	    interstitialAd.setParameter(AdKeys.DOWNLOAD_ALERT, "true");
	    
	    //请求广告，添加监听器
    	interstitialAd.loadAd(mAdListener);
	}
	
	IFLYAdListener mAdListener = new IFLYAdListener(){

		/**
		 * 广告请求成功
		 */
		@Override
		public void onAdReceive() {
			//展示广告
	    	interstitialAd.showAd();
	    	
	    	mTextView.setText("success");
		    Log.d("Ad_Android_Demo", "onAdReceive");
		}

		/**
		 * 广告请求失败
		 */
		@Override
		public void onAdFailed(AdError error) {
			mTextView.setText("failed:"+error.getErrorCode()+","+
						error.getErrorDescription());
		    Log.d("Ad_Android_Demo", "onAdFailed:"+error.getErrorCode()+","+
					error.getErrorDescription());
		}

		/**
		 * 广告被点击
		 */
		@Override
		public void onAdClick() {
	    	mTextView.setText("ad click");
		    Log.d("Ad_Android_Demo", "onAdClick");
		}

		/**
		 * 广告被关闭
		 */
		@Override
		public void onAdClose() {
	    	mTextView.setText("ad close");
		    Log.d("Ad_Android_Demo", "onAdClose");
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
    

}
