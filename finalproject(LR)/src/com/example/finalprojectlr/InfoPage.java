package com.example.finalprojectlr;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class InfoPage extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info_layout);
		
		Button start = (Button) findViewById(R.id.play);
		
		start.setOnClickListener(buttonMethod);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	View.OnClickListener buttonMethod = new View.OnClickListener() {
	    public void onClick(View v) {
	    	Intent intent = new Intent(InfoPage.this, GameActivity.class);
	    	startActivity(intent);
	    	
	    }
	};
}
