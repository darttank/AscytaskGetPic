package com.example.androidtest;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * 
 * @ClassName: ActivityA
 * @Description: 对Activity生命周期的测试，重载了onCreate，onStart,onResume,
 * 				 onStop,onPause
 *               onDestroy,onRestart七个方法
 * @author yuxianglong
 * @date 2013-7-9 上午9:09:22
 * 
 */
public class ActivityA extends Activity {
	private Button button;
	private String Tag = "yuxlong2010";
	int count = 0;
    private TextView textview;
    User user;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(Tag, "I'm  onCreate");
		setContentView(R.layout.activity_a);
		textview = (TextView) findViewById(R.id.textView1);
		button = (Button) findViewById(R.id.button1);
		Bundle bundle = this.getIntent().getExtras();
		user  = (User) bundle.get("user");
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//startActivity(new Intent(ActivityA.this,ActivityA.class));
				textview.setText(user.getList().get(0).toString());
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i(Tag, "I'm  onStart"+""+count++);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(Tag, "I'm  onResume"+""+count++);
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i(Tag, "I'm  onStop"+""+count++);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i(Tag, "I'm  onDestroy"+""+count++);
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i(Tag, "I'm  onRestart"+""+count++);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i(Tag, "I'm  onPause"+""+count++);
	}
}
