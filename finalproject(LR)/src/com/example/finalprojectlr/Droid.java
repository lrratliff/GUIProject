package com.example.finalprojectlr;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;

public class Droid {

	private Bitmap bitmap;
	private int x;
	private int y;
	private boolean valid;
	Speed speed;
	
	public Droid(Bitmap bitmap, int x , int y, float f){
	
	this.bitmap = bitmap;
	this.x = x;
	this.y = y;
	speed = new Speed();
	speed.setYv(f);
	valid = true;
	}
	public Droid(Droid d){
		this.bitmap = d.bitmap;
		this.x = d.x;
		this.y = d.y;
		speed = new Speed();
		valid = true;
		
	}
	
	public Bitmap getBitmap(){
		return bitmap;
	}
	public void setSpeed(float f){
		speed.setYv(f) ;
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
	public void destroy(){
		this.setValid(false);
		this.bitmap.recycle();
	}
	public boolean getValid()
	{
		return valid;
	}
	public void setValid(boolean b)
	{
		valid = b;
	}
	public void draw(Canvas canvas){
		canvas.drawBitmap(bitmap, x - (bitmap.getWidth() / 2), y - (bitmap.getHeight() / 2), null);
	}
	
		public void update(){
				x +=(int)(speed.getXv() * speed.getxDirection());
				y += (speed.getYv() * speed.getyDirection());
			}
		

		public Speed getSpeed() {
			// TODO Auto-generated method stub
			return speed;
		}
	}

