package com.bing.greenmemory.activity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.bing.greenmemory.R;

/**
 * Activity框架类
 * 
 * @author rocky
 * 
 */
public abstract class ActivityFrame extends ActivityBase {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//隐藏标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		/*//强制设置为横屏
		if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		}*/
	}
	
	/**
	 * 包装并显示toast
	 * @param pToast 要包装的Toast
	 */
	protected void setToastObject(Toast pToast) {
		pToast.setGravity(Gravity.CENTER, 0, 0); //居中显示
	}
	
	/**
	 * 获取包装的Toast
	 * @param pResID 文本资源ID
	 * @return Toast
	 */
	protected Toast getToastObject(int pResID) {
		return getToastObject(getString(pResID));
	}
	
	/**
	 * 获取包装的Toast
	 * @param pText 文本字符
	 * @return Toast
	 */
	protected Toast getToastObject(String pText) {
		Toast toast = new Toast(this);
		View view = getLayoutInflater().inflate(R.layout.common_toast_view, null);
		TextView tvMessage = (TextView)view. findViewById(R.id.tvMessage);
		tvMessage.setText(pText);
		toast.setView(view);
		toast.setGravity(Gravity.CENTER, 0, 0); //居中显示
		
		return toast;
	}
	
	@Override
	protected void toastLongShow(int pResID) {
		Toast toast = getToastObject(pResID);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.show();
	}
	
	@Override
	protected void toastLongShow(String pText) {
		Toast toast = getToastObject(pText);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.show();
	}
	
	@Override
	protected void toastShortShow(int pResID) {
		Toast toast = getToastObject(pResID);
		toast.setDuration(Toast.LENGTH_SHORT);
		toast.show();
	}
	
	@Override
	protected void toastShortShow(String pText) {
		Toast toast = getToastObject(pText);
		toast.setDuration(Toast.LENGTH_SHORT);
		toast.show();
	}
}
