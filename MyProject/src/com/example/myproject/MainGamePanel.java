package com.example.myproject;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainGamePanel extends SurfaceView implements SurfaceHolder.Callback {
	
	private MainThread thread;
	private Droid droid;
	private static final String TAG = MainThread.class.getSimpleName();

public MainGamePanel(Context context) {
		super(context);
		// adding the callback (this) to the surface holder to intercept events
		getHolder().addCallback(this);
  
		thread = new MainThread(getHolder(), this);
		// make the GamePanel focusable so it can handle events
		setFocusable(true);
	}

 @Override
 public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
	 	
 		}

 @Override
 public void surfaceCreated(SurfaceHolder holder) {
	 thread.setRunning(true);
	 thread.start();

 }

 @Override
 public void surfaceDestroyed(SurfaceHolder holder) {
	 Log.d(TAG, "Surface is being destroyed");
	 boolean retry = true;
	   while (retry) {
	    try {
	     thread.join();
	     retry = false;
	    } 
	    catch (InterruptedException e) {
	     // try again shutting down the thread
	    }
	   }
	   Log.d(TAG, "Thread was shut down cleanly");
 }

 @Override
 public boolean onTouchEvent(MotionEvent event) {
	 if(event.getAction() == MotionEvent.ACTION_DOWN){
		 droid.handleActionDown((int)event.getX(), (int)event.getY());
		 if(event.getY() > getHeight() - 50) {
			 thread.setRunning(false);
			 ((Activity)getContext()).finish();
		 }
		 else{
			 Log.d(TAG, "Coords: x=" + event.getX() + ",y=" +
					 event.getY());
		 }
	 }
	 if (event.getAction() == MotionEvent.ACTION_MOVE) {
		 if (droid.isTouched()) {
			 droid.setX((int)event.getX());
			 droid.setY((int)event.getY());
		 }
	 }
	 if (event.getAction() == MotionEvent.ACTION_UP) {
		 if (droid.isTouched()) {
			 droid.setTouched(false);
		 }
	 }
	 


  return super.onTouchEvent(event);
 }

 @Override
 protected void onDraw(Canvas canvas) {
	 canvas.drawColor(Color.BLACK);
	   droid.draw(canvas);	 
 }
 

}
