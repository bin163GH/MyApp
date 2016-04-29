package com.bing.greenmemory.controls;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

import com.bing.greenmemory.R;
import com.bing.greenmemory.controls.gifview.GifView;

/**
 * loading对话框
 * @author rocky
 */
public class LoadingDialog {

	private Dialog mDialog;
	private Context mContext;
	private GifView gifvLoading;

	public LoadingDialog(Context pContext) {
		mContext = pContext;
	}

	private OnClickListener mOnClickListener=new OnClickListener() {

		@Override
		public void onClick(View v) {
			dismissDialog();
		}
	};
/*	*//**
	 * 显示对话框的 对象
	 * @param msgTitleId
	 *            对话框标题 从String配置文件 中取id
	 * @param msgImgId
	 *            图片 从R文件中取id
	 * @param msgContentId
	 *            对话框内容 从String配置文件 中取id
	 *//*
	public void showDialog(int pMsgTitleId, int pMsgImgId,
			int pMsgContentId) {
		View dialogView = LayoutInflater.from(mContext).inflate(
				R.layout.dialogshow, null);
		mDialog = new Dialog(mContext, R.style.dialog);
		mDialog.setContentView(dialogView);

		
		 * 获取对话框的窗口对象及参数对象以修改对话框的布局设置, 可以直接调用getWindow(),表示获得这个Activity的Window
		 * 对象,这样这可以以同样的方式改变这个Activity的属性.
		 
		Window dialogWindow = mDialog.getWindow();
		WindowManager.LayoutParams lp = dialogWindow.getAttributes();
		dialogWindow.setGravity(Gravity.CENTER);

		// 设置对话框的的 宽度和高度
		lp.width = 250; // 宽度
		lp.height = 400; // 高度

		dialogWindow.setAttributes(lp);

		ImageView ivMessagePic = (ImageView) dialogView.findViewById(R.id.ivMessagePic);
		mTvMessageTitle = (TextView) dialogView.findViewById(R.id.tvMessageTitle);
		mTvMessageContent = (TextView) dialogView.findViewById(R.id.tvMessageContent);
		mButton = (Button) dialogView.findViewById(R.id.btnConfirm);
		mButton.setOnClickListener(mOnClickListener);
		
		ivMessagePic.setBackgroundResource(pMsgImgId);
		setTitleAndContent(pMsgTitleId,pMsgContentId);

		mDialog.show();
	}

	public void showDialog(String pMsgTitle,
			String pMsgContent) {
		View dialogView = LayoutInflater.from(mContext).inflate(
				R.layout.dialogshownettrafficstatisticsalert, null);
		mDialog = new Dialog(mContext, R.style.dialog);
		mDialog.setContentView(dialogView);

		
		 * 获取对话框的窗口对象及参数对象以修改对话框的布局设置, 可以直接调用getWindow(),表示获得这个Activity的Window
		 * 对象,这样这可以以同样的方式改变这个Activity的属性.
		 
		Window dialogWindow = mDialog.getWindow();
		WindowManager.LayoutParams lp = dialogWindow.getAttributes();
		dialogWindow.setGravity(Gravity.CENTER);

		// 设置对话框的的 宽度和高度
		lp.width = 380; // 宽度
		lp.height = 350; // 高度

		dialogWindow.setAttributes(lp);

		mTvMessageTitle = (TextView) dialogView.findViewById(R.id.tvMessageTitle);
		mTvMessageContent = (TextView) dialogView.findViewById(R.id.tvMessageContent);
		mButton = (Button) dialogView.findViewById(R.id.btnConfirm);
		mButton.setOnClickListener(mOnClickListener);
		setTitleAndContent(pMsgTitle, pMsgContent);
		mDialog.show();
	}
	
	*//**
	 * 显示对话框的 对象
	 * @param msgTitleId
	 *            对话框标题 从String配置文件 中取id
	 * @param msgImgId
	 *            图片 从R文件中取id
	 * @param msgContentId
	 *            对话框内容 从String配置文件 中取id
	 *//*
	public void showDialog(String pMsgTitle, int pMsgImgId,
			String pMsgContent) {
		View dialogView = LayoutInflater.from(mContext).inflate(
				R.layout.dialogshow, null);
		mDialog = new Dialog(mContext, R.style.dialog);
		mDialog.setContentView(dialogView);

		
		 * 获取对话框的窗口对象及参数对象以修改对话框的布局设置, 可以直接调用getWindow(),表示获得这个Activity的Window
		 * 对象,这样这可以以同样的方式改变这个Activity的属性.
		 
		Window dialogWindow = mDialog.getWindow();
		WindowManager.LayoutParams lp = dialogWindow.getAttributes();
		dialogWindow.setGravity(Gravity.CENTER);

		// 设置对话框的的 宽度和高度
		lp.width = 380; // 宽度
		lp.height = 300; // 高度

		dialogWindow.setAttributes(lp);

		mTvMessageTitle = (TextView) dialogView.findViewById(R.id.tvMessageTitle);
		mTvMessageContent = (TextView) dialogView.findViewById(R.id.tvMessageContent);
		ImageView ivMessagePic = (ImageView) dialogView.findViewById(R.id.ivMessagePic);
		mButton = (Button) dialogView.findViewById(R.id.btnConfirm);
		mButton.setOnClickListener(mOnClickListener);
		
		ivMessagePic.setBackgroundResource(pMsgImgId);
		setTitleAndContent(pMsgTitle,pMsgContent);

		mDialog.show();
	}
	
	private void setTitleAndContent(int pMsgTitleId, int pMsgContentId) {
		mTvMessageTitle.setText(pMsgTitleId);
		mTvMessageContent.setText(pMsgContentId);
	}

	private void setTitleAndContent(String pMsgTitle, String pMsgContent) {
		mTvMessageTitle.setText(pMsgTitle);
		mTvMessageContent.setText(pMsgContent);
	}*/
	
	/**
	 * 显示圆圈loading对话框
	 * @param b 是否能能点击back键取消   true能取消
	 */
	public void showCircleLoadingDialog(boolean b) {
		View dialogView = LayoutInflater.from(mContext).inflate(
				R.layout.common_loading_view, null);
		mDialog = new Dialog(mContext, R.style.loading_dialog_style);
//		mDialog = new Dialog(mContext);
		mDialog.setContentView(dialogView);
		mDialog.setCanceledOnTouchOutside(false); //点击外侧区域时，dialog不消失
		mDialog.setCancelable(b); //不能点击后退键取消
		
		gifvLoading = (GifView) dialogView.findViewById(R.id.gifvLoading);
//		gifvLoading.setGifImage(R.drawable.common_loading_cat); //喜猫图
		gifvLoading.setGifImage(R.drawable.common_loading_circle); //圆圈图
		
		Window dialogWindow = mDialog.getWindow();
		WindowManager.LayoutParams lp = dialogWindow.getAttributes();
		dialogWindow.setGravity(Gravity.CENTER);

		//设置对话框的的 宽度和高度
//		lp.width = 400; // 宽度
//		lp.height = 400; // 高度
		

		dialogWindow.setAttributes(lp);
		
		mDialog.show();
	}
	
	
	/**
	 * 取消弹出的对话框
	 */
	public void dismissDialog() {
		if (mDialog != null) {
			mDialog.dismiss();
			mDialog = null;
		}
	}

}
