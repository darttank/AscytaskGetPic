package com.example.androidtest;

import java.io.Serializable;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class BundleDemo extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bundle_activity);
		User user = new User();
		Intent intent = new Intent(this, ActivityA.class);
		Bundle bundle = new Bundle();
		bundle.putSerializable("user", user);
		intent.putExtras(bundle);
		startActivity(intent);
	}
}
class User implements Serializable {
	public ArrayList getList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("tian1");
		list.add("tian2");
		list.add("tian3");
		list.add("tian4");
		return list;

	}
}
