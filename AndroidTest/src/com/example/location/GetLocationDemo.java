package com.example.location;

import java.util.List;

import com.example.androidtest.R;

import android.app.Activity;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class GetLocationDemo extends Activity {
	private LocationManager  lm;
	private MyListener listener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lm  = (LocationManager) getSystemService(LOCATION_SERVICE);
		
		List<String>  providers = lm.getAllProviders();
		for(String s : providers){
			System.out.println(s);
		}
		//passive wifi gps
		listener = new MyListener();
		lm.requestLocationUpdates("gps", 0, 0, listener);
	}
	
	@Override
	protected void onDestroy() {
		lm.removeUpdates(listener);
		listener = null;
		super.onDestroy();
	}

	private class MyListener implements LocationListener{

		@Override
		public void onLocationChanged(Location location) {
			StringBuilder sb = new StringBuilder();
			System.out.println("精确度："+location.getAccuracy());
			System.out.println("移动的速度："+location.getSpeed());
			System.out.println("纬度："+location.getLatitude());
			System.out.println("经度："+location.getLongitude());
			System.out.println("海拔："+location.getAltitude());
			sb.append("精确度："+location.getAccuracy()+"\n");
			sb.append("移动的速度："+location.getSpeed()+"\n");
			sb.append("纬度："+location.getLatitude()+"\n");
			sb.append("经度："+location.getLongitude()+"\n");
			sb.append("海拔："+location.getAltitude()+"\n");
			String result = sb.toString();
			TextView tv = new TextView(getApplicationContext());
			tv.setTextColor(Color.RED);
			tv.setText(result);
			setContentView(tv);
		}
		//当位置提供者 状态发生变化的时候调用的方法。
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			
		}
		//当某个位置提供者 可用的时候调用的方法。
		@Override
		public void onProviderEnabled(String provider) {
			
		}
		//当某个位置提供者 不可用的时候调用的方法。
		@Override
		public void onProviderDisabled(String provider) {
			
		}
		
	}
	
}
