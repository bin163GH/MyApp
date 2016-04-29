package com.bing.greenmemory.fragment;

import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bing.greenmemory.R;

/**
 * fragment基类
 * @author rocky
 *
 */
public abstract class FragmentBase extends Fragment {
	private View vToast;
	private Toast toast;
	private TextView tvToast;
	
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
	 * 包装并显示toast
	 * @param pToast 要包装的Toast
	 */
	protected void setToastObject() {
		vToast = getLayoutInflater(getArguments()).inflate(R.layout.common_toast_view, null);
		tvToast = (TextView)vToast. findViewById(R.id.tvMessage);
		toast = new Toast(getActivity());
		toast.setGravity(Gravity.CENTER, 0, 0);
	}
}
