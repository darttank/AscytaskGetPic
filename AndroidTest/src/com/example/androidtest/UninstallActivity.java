package com.example.androidtest;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class UninstallActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_uninstall);
	}
	
	public void ClickUninstall(View view){
	            
		Uri packageURI = Uri.parse("package:com.example.showdialog");           
		Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);           
		startActivity(uninstallIntent); 

		
	}

	
}
