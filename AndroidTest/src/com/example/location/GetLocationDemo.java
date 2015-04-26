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
			System.out.println("��ȷ�ȣ�"+location.getAccuracy());
			System.out.println("�ƶ����ٶȣ�"+location.getSpeed());
			System.out.println("γ�ȣ�"+location.getLatitude());
			System.out.println("���ȣ�"+location.getLongitude());
			System.out.println("���Σ�"+location.getAltitude());
			sb.append("��ȷ�ȣ�"+location.getAccuracy()+"\n");
			sb.append("�ƶ����ٶȣ�"+location.getSpeed()+"\n");
			sb.append("γ�ȣ�"+location.getLatitude()+"\n");
			sb.append("���ȣ�"+location.getLongitude()+"\n");
			sb.append("���Σ�"+location.getAltitude()+"\n");
			String result = sb.toString();
			TextView tv = new TextView(getApplicationContext());
			tv.setTextColor(Color.RED);
			tv.setText(result);
			setContentView(tv);
		}
		//��λ���ṩ�� ״̬�����仯��ʱ����õķ�����
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			
		}
		//��ĳ��λ���ṩ�� ���õ�ʱ����õķ�����
		@Override
		public void onProviderEnabled(String provider) {
			
		}
		//��ĳ��λ���ṩ�� �����õ�ʱ����õķ�����
		@Override
		public void onProviderDisabled(String provider) {
			
		}
		
	}
	
}
