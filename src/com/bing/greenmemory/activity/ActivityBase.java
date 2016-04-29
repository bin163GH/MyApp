package com.bing.greenmemory.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bing.greenmemory.R;

/**
 * Activity基类
 * @author rocky
 *
 */
public class ActivityBase extends FragmentActivity {
	private View vToast;
	private Toast toast;
	TextView tvToast;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); 
	}
	
	/**
	 * 长时间显示Toast
	 * @param pResID 要显示的字符资源ID
	 */
	protected void toastLongShow(int pResID) {
		setToastObject();
		tvToast.setText(pResID);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.setView(vToast);
		toast.show();
	}
	
	/**
	 * 短时间显示Toast
	 * @param pResID 要显示的字符资源ID
	 */
	protected void toastShortShow(int pResID) {
		setToastObject();
		tvToast.setText(pResID);
		toast.setDuration(Toast.LENGTH_SHORT);
		toast.setView(vToast);
		toast.show();
	}
	
	/**
	 * 长时间显示Toast
	 * @param pText 要显示的字符
	 */
	protected void toastLongShow(String pText) {
		setToastObject();
		tvToast.setText(pText);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.setView(vToast);
		toast.show();
	}
	
	/**
	 * 短时间显示Toast
	 * @param pText 要显示的字符
	 */
	protected void toastShortShow(String pText) {
		setToastObject();
		tvToast.setText(pText);
		toast.setDuration(Toast.LENGTH_SHORT);
		toast.setView(vToast);
		toast.show();
	}
	
	/**
	 * 根据传进来的activity打开activity
	 * @param pClass 要打开的activity class
	 */
	protected void startActivity(Class<?> pClass) {
		Intent intent = new Intent();
		intent.setClass(this, pClass);
		startActivity(intent);
	}
	
	/**
	 * 包装并显示toas
	 * @param pToast 要包装的Toast
	 */
	protected void setToastObject() {
		vToast = getLayoutInflater().inflate(R.layout.common_toast_view, null);
		tvToast = (TextView)vToast. findViewById(R.id.tvMessage);
		toast = new Toast(this);
		toast.setGravity(Gravity.CENTER, 0, 0);
	}
			
}
