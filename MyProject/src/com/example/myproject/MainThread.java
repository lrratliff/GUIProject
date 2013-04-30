package com.example.myproject;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

public class MainThread extends Thread {
	
	private static final String TAG = MainThread.class.getSimpleName();
	private SurfaceHolder surfaceHolder;
	private MainGamePanel gamePanel;
	private boolean running;
	
	public  MainThread(SurfaceHolder surfaceHolder,MainGamePanel
			gamePanel){
		super();
		this.surfaceHolder = surfaceHolder;
		this.gamePanel = gamePanel;
	}

 public void setRunning(boolean running) {

  this.running = running;

 }

 @Override
 public void run() {
	 Canvas canvas;
	 Log.d(TAG, "Starting game loop");
  while (running) {
	 canvas = null;
	 try{
		 canvas = this.surfaceHolder.lockCanvas();
		 synchronized(surfaceHolder){
			 // update game state
			   // render state to the screen
			 this.gamePanel.update();
			 this.gamePanel.render(canvas);
		 }
	 }
  	  finally{
  		  if(canvas != null){
  			  surfaceHolder.unlockCanvasAndPost(canvas);
  		  }
  	  }
  }

 }
}

