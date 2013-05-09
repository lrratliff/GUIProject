package com.example.finalprojectlr;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExitActivity extends Activity {
	
	private MainGamePanel m;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exit);
		Button b =(Button) findViewById(R.id.exitButton);
		TextView t = (TextView) findViewById(R.id.exitText);
		Intent intent = getIntent();
        String message = intent.getStringExtra(MainGamePanel.EXTRA_MESSAGE);
		t.setText("Your Score: " + message);
		
		b.setOnClickListener(buttonMethod);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.exit, menu);
		
		
		return true;
	}

	View.OnClickListener buttonMethod = new View.OnClickListener() {
	    public void onClick(View v) {
	    	Intent intent = new Intent(Intent.ACTION_MAIN);
	    	intent.addCategory(Intent.CATEGORY_HOME);
	    	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	    	startActivity(intent);
	    	
	    	ExitActivity.this.finish();
	    }
	};
}
