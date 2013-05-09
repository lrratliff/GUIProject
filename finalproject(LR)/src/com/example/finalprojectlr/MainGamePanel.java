package com.example.finalprojectlr;


import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Movie;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainGamePanel extends SurfaceView implements SurfaceHolder.Callback {
	
	public User user;
	private Context context;
	private SurfaceHolder surfaceHolder;
	private MainThread thread;
	private Paddle paddle;
	private static final String TAG = MainThread.class.getSimpleName();
	public final static String EXTRA_MESSAGE = "com.example.finalprojectlr.MESSAGE";
	static Random generator = new Random();
	private int randXGen = generator.nextInt(700) + 1;
	private int randYGen = generator.nextInt(700) + 1;
	private static final int maxObjects = 5;
	private Droid[] droidArray;
	private float maxSpeed = 1;
	private int score = 0;
	
public MainGamePanel(Context context) {
		super(context);
		// adding the callback (this) to the surface holder to intercept events
		getHolder().addCallback(this);
		droidArray = new Droid [maxObjects];
		user = new User();
		paddle = new Paddle(BitmapFactory.decodeResource(getResources(), R.drawable.paddle), 400, 1000);
		
		for(int x = 0; x < maxObjects; x++){
		
		randXGen = generator.nextInt(700) + 1;
		randYGen = generator.nextInt(700) + 1;
		droidArray [x] = new Droid(BitmapFactory.decodeResource(getResources(), R.drawable.asteroid_1), randXGen, randYGen, maxSpeed);
		}
		
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
	 try{
		 Thread.sleep(50);
	 }
	 catch(InterruptedException e){
		 e.printStackTrace();
	 }
		 
	 switch (event.getAction()){
	 case(MotionEvent.ACTION_DOWN):
		 paddle.handleActionDown((int)event.getX(), (int)event.getY());
		 if(event.getY() > getHeight() - 50) {
			 thread.setRunning(false);
			 ((Activity)getContext()).finish();
		 }
		 else{
			 Log.d(TAG, "Coords: x=" + event.getX() + ",y=" +
					 event.getY());
		 }
	 
		 break;
	 case(MotionEvent.ACTION_MOVE):
		 if (paddle.isTouched()) {
			 paddle.setX((int)event.getX());
			 paddle.setY((int)event.getY());
		 }
	 
	 break;
	 case( MotionEvent.ACTION_UP):
		 if (paddle.isTouched()) {
			 paddle.setTouched(false);
		 }
	 break;
	 }
	 
	 return true;
 }

 
 protected void render(Canvas canvas) {
	 canvas.drawColor(Color.BLACK);
	 user.draw(canvas);
	 paddle.draw(canvas);
	 for(int x = 0; x < maxObjects; x++){
		 if(droidArray[x].getValid() == true)
	   droidArray[x].draw(canvas);
		 else
			 continue;
	 }
	
 }
 @Override
 protected void onDraw(Canvas canvas) {
	 canvas.drawColor(Color.BLACK);
	 paddle.draw(canvas);
	 user.draw(canvas);
	 for(int x = 0; x < maxObjects; x++){
		 if(droidArray[x].getValid() == true)
			   droidArray[x].draw(canvas);
				 else
					 continue;
	 }
	 //droid.draw(canvas);
	 
 }
 
 public void update() {
//	     // check collision with right wall if heading right
//	     if (droid.getSpeed().getxDirection() == Speed.DIRECTION_RIGHT
//	             && droid.getX() + droid.getBitmap().getWidth() / 2 >= getWidth()) {
//	         droid.getSpeed().toggleXDirection();
//	     }
//	     // check collision with left wall if heading left
//	     if (droid.getSpeed().getxDirection() == Speed.DIRECTION_LEFT
//	             && droid.getX() - droid.getBitmap().getWidth() / 2 <= 0) {
//
//	         droid.getSpeed().toggleXDirection();
//	     }
	     // check collision with bottom wall if heading down
	 for(int x = 0; x < maxObjects; x++){
		 if(droidArray[x].getValid()== false){
			 randXGen = generator.nextInt(700) + 1;
			 randYGen = generator.nextInt(700) + 1;
			 maxSpeed += 1;
			 droidArray [x] = new Droid(BitmapFactory.decodeResource(getResources(), R.drawable.asteroid_1), randXGen, randYGen,
					 maxSpeed);
			 
			 continue;
		 }
		 else if(droidArray[x].getValid() == true){
			 
		 if ( droidArray[x].getY() + droidArray[x].getBitmap().getHeight() / 2 >= getHeight()) {
			 Context context = getContext(); // from MySurfaceView/Activity
			 Intent intent = new Intent(context, ExitActivity.class);
			 StringBuilder sb = new StringBuilder();
			 sb.append("");
			 sb.append(score);
			 String message = sb.toString();
		     intent.putExtra(EXTRA_MESSAGE, message);
			 context.startActivity(intent); 
			 
	                
	     }
	     // check collision with paddle
	     if ( (paddle.getY() - droidArray[x].getY() >= -153 && paddle.getY() - droidArray[x].getY() <= 153) && 
	    		 (paddle.getX()- droidArray[x].getX() >= -150 && paddle.getX()- droidArray[x].getX() <= 150))
	     {
	    	 droidArray[x].destroy();
	    	 user.setScore(user.getScore() + 1);
	    	 score = user.getScore();
	     }

	     // Update the droid
	     //droid.update();
	    droidArray[x].update();
		 }
	 }


 }

}
