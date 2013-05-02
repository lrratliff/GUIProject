package com.example.myproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Droid {

	private Bitmap bitmap;
	private int x;
	private int y;
	private boolean touched;
	Speed speed;
	
	public Droid(Bitmap bitmap, int x , int y){
	
	this.bitmap = bitmap;
	this.x = x;
	this.y = y;
	}
	
	public Bitmap getBitmap(){
		return bitmap;
	}
	
	public void setBitmap(Bitmap bitmap){
		this.bitmap = bitmap;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public boolean isTouched(){
		return touched;
	}
	public void setTouched(boolean touched){
		this.touched = touched;
	}
	public void draw(Canvas canvas){
		canvas.drawBitmap(bitmap, x - (bitmap.getWidth() / 2), y - (bitmap.getHeight() / 2), null);
	}
	public void handleActionDown(int eventX, int eventY){
		if (eventX >= (x-bitmap.getWidth()/ 2) && (eventX <= (x + bitmap.getWidth()/2))){
			if (eventY >= (y - bitmap.getHeight() / 2) && (y <= (y + bitmap.getHeight() / 2))){
				setTouched(true);
			}
			else{
				setTouched(false);
			}
		}
			else{
				setTouched(false);
			}
			
		}
		public void update(){
			if(!touched){
				x += (speed.getXv() * speed.getXDirection());
				y += (speed.getYv() * speed.getYDirection());
			}
		}

		public Speed getSpeed() {
			// TODO Auto-generated method stub
			return speed;
		}
	}

