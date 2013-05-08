package com.example.finalprojectlr;

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

 public void run() {
	     Canvas canvas;
	     Log.d(TAG, "Starting game loop");
	     while (running) {
	         canvas = null;
	         // try locking the canvas for exclusive pixel editing
	         // in the surface
	         try {
	             canvas = this.surfaceHolder.lockCanvas();
	             synchronized (surfaceHolder) {
	                 // update game state
	                 this.gamePanel.update();
	                 // render state to the screen
	                 // draws the canvas on the panel
	                 this.gamePanel.render(canvas);
	             }
	         } finally {
	             // in case of an exception the surface is not left in
	             // an inconsistent state
	             if (canvas != null) {
	                 surfaceHolder.unlockCanvasAndPost(canvas);
	            }
	         }   // end finally
	     }
	 }

}

