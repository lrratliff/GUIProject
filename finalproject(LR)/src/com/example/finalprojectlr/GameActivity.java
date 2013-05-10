package com.example.finalprojectlr;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class GameActivity extends Activity{
	
	private static final String TAG = MainActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(new MainGamePanel(this));
		Log.d(TAG, "View aded");
		
	}

	@Override
	protected void onDestroy(){
		Log.d(TAG, "Destroying Stuff");
		super.onDestroy();
		finish();
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

	@Override
    public void onBackPressed() {
		GameActivity.this.finish();
    }

}


