package com.bing.greenmemory.fragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.bing.greenmemory.R;
import com.bing.greenmemory.activity.ActivityCalendarView;
import com.bing.greenmemory.calendar.CalendarView;
import com.bing.greenmemory.calendar.CalendarView.OnCalendarViewListener;
import com.iflytek.voiceads.AdError;
import com.iflytek.voiceads.AdKeys;
import com.iflytek.voiceads.IFLYAdListener;
import com.iflytek.voiceads.IFLYAdSize;
import com.iflytek.voiceads.IFLYFullScreenAd;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;


/**
 * 搜索专辑
 * @author rocky
 *
 */
public class FragmentSearch extends FragmentFrame  {

	private CalendarView calendarView;
	private FragmentSearch mSelf = FragmentSearch.this;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    		Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	View view = inflater.inflate(R.layout.activity_calendar_view, null);
    	
    	calendarView = (CalendarView) view.findViewById(R.id.calendar);
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
                Toast.makeText(getActivity(), format.format(date), Toast.LENGTH_SHORT).show();
            }
        });		
        
    	return view;
    	
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
    	// TODO Auto-generated method stub
    	super.setUserVisibleHint(isVisibleToUser);
    }
    
    

}
