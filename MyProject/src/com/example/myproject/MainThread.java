package com.example.myproject;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

public class MainThread extends Thread {
	
	private static final String TAG = MainThread.class.getSimpleName();
	private SurfaceHolder surfaceHolder;
	private MainGamePanel gamePanel;
	private boolean running;
	private static final int MAX_FPS = 50;
	private static final int MAX_FRAME_SKIPS = 5;
	private static final int FRAME_PERIOD = 1000/ MAX_FPS;
	
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
	 long beginTime;
	 long timeDiff;
	 int sleepTime = 0;
	 int framesSkipped;
	 Canvas canvas;
	 Log.d(TAG, "Starting game loop");
	 
	 
  while (running) {
	 canvas = null;
	 try{
		 canvas = this.surfaceHolder.lockCanvas();
		 synchronized(surfaceHolder){
			 beginTime = System.currentTimeMillis();
			 framesSkipped = 0;
			 // update game state
			 this.gamePanel.update();
			   // render state to the screen
			 this.gamePanel.render(canvas);
			 timeDiff = System.currentTimeMillis();
			 sleepTime = (int)(FRAME_PERIOD - timeDiff);
			 
			 if(sleepTime > 0){
				 try{
					 Thread.sleep(sleepTime);
				 }
				 catch(InterruptedException e ){}
			 }
		 }
		 while(sleepTime < 0 && framesSkipped < MAX_FRAME_SKIPS)
		 {
			 this.gamePanel.update();
			 sleepTime += FRAME_PERIOD;
			 framesSkipped++;
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

