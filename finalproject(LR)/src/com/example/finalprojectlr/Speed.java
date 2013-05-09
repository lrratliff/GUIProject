package com.example.finalprojectlr;

public class Speed {
	//public static final int DIRECTION_RIGHT = 1;
	//public static final int DIRECTION_LEFT = -1;
	//public static final int DIRECTION_UP = -1;
	public static final int DIRECTION_DOWN = 1;
	
	private float xv = 1; //velocities
	private float yv = 1;
	
	private int xDirection = 0;
	private int yDirection = DIRECTION_DOWN;
	
	public Speed(){
		this.xv = 0;
		this.yv =5;
	}
	
	public Speed( float xv, float yv){
		this.xv = xv;
		this.yv =yv;
	}

	public float getXv(){
		return xv;
	}
	public void setXv(float xv){
		this.xv = xv;
	}
	public float getYv(){
		return yv;
	}
	public void setYv(float yv){
		this.yv = yv;
	}
	public int getxDirection(){
		return xDirection;
	}
	public int getyDirection(){
		return yDirection;
	}
	public void setxDirection(int xDirection){
		this.xDirection = xDirection;
	}
	public void setyDirection(int yDirection){
		this.yDirection = yDirection;
	}
	public void toggleXDirection(){
		xDirection = xDirection*-1;
	}
	public void toggleYDirection(){
		yDirection = yDirection * -1;
	}
	
}
