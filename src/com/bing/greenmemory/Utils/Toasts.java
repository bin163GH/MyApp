package com.bing.greenmemory.Utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.widget.Toast;

/**
 * 自定义的Toast提示， 可定义显示的时间， 可避免连续点击长时间显示
 * 
 * @author l_bin
 *	Create at： 2016/01/11
 */
public class Toasts {
	private Toast toast;  
    private Field field;  
    private Object obj;  
    private Method showMethod;  
    private Method hideMethod;  
    private int time;  
    private boolean isRedo;
  
    public Toasts(Context c, String text, int time) {  
        toast = Toast.makeText(c, text, time);  
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL,  
                0, 0);  
        this.time=time;  
        reflectionTN();  
    } 
    
    public Toasts(Context c, int resId, int time) {  
        toast = Toast.makeText(c, resId, time);  
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL,  
                0, 0);  
        this.time=time;  
        reflectionTN();  
    } 
    
	/**
	 * 避免连续点击的 toast 提示, 
	 */
	public void show(){  
		if (!isRedo) {
			isRedo = true;
			toast.show();  
			Handler handler = new Handler();  
			handler.postDelayed(new Runnable() {  
				
				@Override  
				public void run() {  
					try {  
						hideMethod.invoke(obj, null);// 调用TN对象的hide()方法，关闭toast  
						isRedo = false;
					} catch (Exception e) {  
						e.printStackTrace();  
					}  
				}  
			}, time);  
		}
	}  
	
    /**
     * 利用反射技术获得了TN对象；
     * 利用反射技术获得了TN对象的show、hide方法。
     */
    private void reflectionTN() {  
        try {  
            field = toast.getClass().getDeclaredField("mTN");  
            field.setAccessible(true);  
            obj = field.get(toast);  
            showMethod = obj.getClass().getDeclaredMethod("show", null);  
            hideMethod = obj.getClass().getDeclaredMethod("hide", null);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}
