package com.example.finalprojectlr;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class User {

	private int score = 0;
	
	
	
	public void setScore(int i)
	{
		score = i;
	}
	public int getScore()
	{
		return score;
	}
	public void draw(Canvas c)
	{
		Paint paint = new Paint();
		paint.setColor(Color.WHITE);
		paint.setTextSize(40);
		c.drawText("Score: " + score, 20, 40, paint);
		
	}
}
