package com.bing.greenmemory.activity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.os.Bundle;
import android.widget.Toast;

import com.bing.greenmemory.R;
import com.bing.greenmemory.calendar.CalendarView;
import com.bing.greenmemory.calendar.CalendarView.OnCalendarViewListener;

public class ActivityCalendarView extends ActivityFrame {
 
	CalendarView calendarView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//隐藏标题栏
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_calendar_view);
		
		calendarView = (CalendarView) findViewById(R.id.calendar);
		//设置标注日期
        List<Date> markDates = new ArrayList<Date>();
        markDates.add(new Date());
        calendarView.setMarkDates(markDates);
 
        //设置点击操作
        calendarView.setOnCalendarViewListener(new OnCalendarViewListener() {
             
            @Override
            public void onCalendarItemClick(CalendarView view, Date date) {
                // TODO Auto-generated method stub
                final SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日", Locale.CHINA);
                Toast.makeText(ActivityCalendarView.this, format.format(date), Toast.LENGTH_SHORT).show();
            }
        });		        

	}
	

	@Override
	public void onBackPressed() {
		canBack();
	}
	/**
	 * 
	 * 描述：能退出吗
	 * @return
	 * @throws 
	 * @date：2013-12-13 上午11:06:58
	 * @version v1.0
	 */
	public void canBack(){
		
	}

}
