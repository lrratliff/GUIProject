package com.example.finalprojectlr;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {
	
	private static final String TAG = MainActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//button declarations
		Button start = (Button) findViewById(R.id.startButton);
		Button info = (Button) findViewById(R.id.infoButton);
		Button end = (Button) findViewById(R.id.exitButton);
		
		info.setOnClickListener(infoMethod);
		start.setOnClickListener(buttonMethod);
		end.setOnClickListener(exitMethod);
		
	}

	View.OnClickListener buttonMethod = new View.OnClickListener() {
	    public void onClick(View v) {
	    	Intent intent = new Intent(MainActivity.this, GameActivity.class);
	    	 startActivity(intent);
	    	
	    }
	};
	View.OnClickListener exitMethod = new View.OnClickListener(){
		public void onClick(View v){
			Intent intent = new Intent(Intent.ACTION_MAIN);
			intent.addCategory(Intent.CATEGORY_HOME);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
			finish();
		}
		};
		View.OnClickListener infoMethod = new View.OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(MainActivity.this, InfoPage.class);
				startActivity(intent);
				
			}
			};
	
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

	@Override
    public void onBackPressed() {
            MainActivity.this.finish();
    }

}