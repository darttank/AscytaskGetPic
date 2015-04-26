package com.example.androidtest;

import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class GetLocationDemo2 extends Activity {
	private LocationManager  lm;
	private MyListener listener;
	TextView get_text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.location_activity);
		lm  = (LocationManager) getSystemService(LOCATION_SERVICE);
		get_text = (TextView) findViewById(R.id.get_text);
		List<String>  providers = lm.getAllProviders();
		for(String s : providers){
			System.out.println(s);
		}
		//passive network gps
		listener = new MyListener();
		lm.requestLocationUpdates("network", 0, 0, listener);
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
		    get_text.setTextColor(Color.RED);
		    get_text.setText(result);
		    System.out.println(result);
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
