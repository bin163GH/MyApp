package com.bing.greenmemory.fragment;

import android.app.Activity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bing.greenmemory.R;
import com.bing.greenmemory.controls.LoadingDialog;

/**
 * fragment框架
 * @author rocky
 *
 */
public abstract class FragmentFrame extends FragmentBase {
	
	protected OnSetFragmentTitleListener mOnSetFragmentTitleListener;
	protected ILoadTrackListListener mILoadTrackListListener;
	protected LoadingDialog mLoadingDialog;
	
	/**
	 * 通知主Activity设置标题栏View和左侧View的回调函数
	 * @author rocky
	 *
	 */
	public interface OnSetFragmentTitleListener {
        /**
         * 设置标题控件
         * @param pView 需要放置入的控件
         */
        public void onSetTitle(View pView);
        /**
         * 设置左侧容器控件
         * @param pIsShowAppName 是否为显示AppName
         */
        public void onSetLeftContainerView(boolean pIsShowAppName);
    }
	
	/**
	 * 通知主Activity根据专辑ID加载音乐列表
	 * @author rocky
	 *
	 */
	public interface ILoadTrackListListener {
//		public void loadTrackList(ModelAlbum pModelAlbum);
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		//当主activity实现了设置title接口并且附加完成，则触发回调; 并且实现自己的标题view不为空时触发onSetTitle（）
		if (activity instanceof OnSetFragmentTitleListener && getTitle() != null) {
			mOnSetFragmentTitleListener = (OnSetFragmentTitleListener) activity;
			mOnSetFragmentTitleListener.onSetTitle(getTitle());
		}else if (activity instanceof OnSetFragmentTitleListener) {
			mOnSetFragmentTitleListener = (OnSetFragmentTitleListener) activity;
		}
		
		//如果是主窗体，则自动实例化ILoadTrackListListener接口  (为了确保宿主activity实现这个接口)
		if (activity instanceof ILoadTrackListListener) {
			mILoadTrackListListener = (ILoadTrackListListener) activity;
		}
		
		mLoadingDialog = new LoadingDialog(this.getActivity());
	}
	
	/**
	 * 由继承的子fragment来实现自己的标题view
	 * @return
	 */
	View getTitle(){
		return null;
	};
	
	/**
	 * 默认提供一个只有textview样式的title
	 * @param pResID 要设置的文本资源ID
	 * @return textview
	 */
	protected View getTextViewTitle(int pResID) {
		TextView tvTitle = new TextView(this.getActivity());
		tvTitle.setText(pResID);
		tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, this.getResources().getDimension(R.dimen.title_bar_text));
		setTextViewTitleColor(tvTitle);
		return tvTitle;
	}
	
	/**
	 * 默认提供一个只有textview样式的title
	 * @param pResID 要设置的文本资源字符
	 * @return textview
	 */
	protected View getTextViewTitle(String pMsg) {
		TextView tvTitle = new TextView(this.getActivity());
		tvTitle.setText(pMsg);
		tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, this.getResources().getDimension(R.dimen.title_bar_text));
		setTextViewTitleColor(tvTitle);
		return tvTitle;
	}
	
	/**
	 * 设置title颜色
	 * @param pTextView 要设置的textview
	 */
	private void setTextViewTitleColor(TextView pTextView) {
		pTextView.setTextColor(this.getResources().getColorStateList(R.color.title_white));
	}
	
	/**
	 * 打开音乐播放界面
	 * @param pModelAlbum 要播放的专辑
	 */
	/*protected void openPlayerView(ModelAlbum pModelAlbum) {
		mILoadTrackListListener.loadTrackList(pModelAlbum);
	}*/
	
	 /**
     * 设置左侧容器控件
     * @param pIsShowAppName 是否为显示AppName
     */
    protected void setLeftContainerView(boolean pIsShowAppName) {
    	if (mOnSetFragmentTitleListener != null) {
			mOnSetFragmentTitleListener.onSetLeftContainerView(pIsShowAppName);
		}
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
		Toast toast = new Toast(this.getActivity());
		View view = this.getActivity().getLayoutInflater().inflate(R.layout.common_toast_view, null);
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
		toast.setDuration(Toast.LENGTH_LONG);
		toast.show();
	}
	
	@Override
	protected void toastShortShow(String pText) {
		Toast toast = getToastObject(pText);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.show();
	}
}
