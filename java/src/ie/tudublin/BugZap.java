package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{

	float playerX; 
	float playerY;
	float playerWidth;
	float playerSpeed;
	float halfPlayerWidth;

	float bugX;
	float bugY;
	float bugWidth;


	public void settings()
	{
		size(500, 500);
	}

	void reset() 
	{
		playerX = width / 2;
		playerY = height - 50;
	}

	public void setup() {

		reset();

		smooth();

		playerX = width /2;
		playerY = height - 50;
		playerWidth = 50;
		playerSpeed = 5;
		halfPlayerWidth = playerWidth/2;

		bugX = 30;
		bugY = 30;
		bugWidth = 30;

	}

	
	public void draw()
	{	
		background(0);
		drawPlayer(playerX,playerY,playerWidth);
		drawBug();
	}

	public void drawPlayer(float x, float y, float w)
	{	
		strokeWeight(2);
		stroke(255);
		rectMode(CENTER);
		noFill();
		rect(x, y, w, 20);
		line(x,y-10,x,y-20);
	}

	public void drawBug	()
	{
		strokeWeight(2);
		stroke(255);
		line(bugX,bugY-10, bugX, bugY-20);
	}

	public void keyPressed()
	{
		if (keyCode == LEFT)
		{
			if (playerX > halfPlayerWidth)
			{
				playerX-=playerSpeed;
			}
			
		}
		if (keyCode == RIGHT)
		{
			if (playerX < width - halfPlayerWidth)
			{
				playerX+= playerSpeed;
			}
			
		}
		if (key == ' ')
		{
			line(playerX, playerY, playerX, 0);
		}
	}	

}
