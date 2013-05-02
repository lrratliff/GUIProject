package com.example.myproject;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
;

public class MainActivity extends Activity {
	
	private static final String TAG = MainActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}

	@Override
	protected void onDestroy(){
		Log.d(TAG, "Destroying Stuff");
		super.onDestroy();
	}
	
	@Override
	protected void onStop(){
		Log.d(TAG, "Stopping");
		super.onStop();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
