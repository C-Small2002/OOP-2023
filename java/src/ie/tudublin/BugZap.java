package ie.tudublin;

import javazoom.jl.player.Player;
import jogamp.nativewindow.ResourceToolkitLock;
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
	float halfBugWidth;

	int score;


	public void settings()
	{
		size(500, 500);
	}

	void reset() 
	{
		playerX = width / 2;
		playerY = height - 50;
		resetBug();
	}

	void resetBug()
	{
		
		bugY = 50;
		bugWidth = 30;
		halfBugWidth = bugWidth /2;
		bugX = random(halfBugWidth, width - halfBugWidth);
	}

	public void setup() {

		reset();

		smooth();

		score = 0;

		playerX = width /2; //playerX = width * 0.5f
		playerY = height - 50;
		playerWidth = 50;
		playerSpeed = 5;
		halfPlayerWidth = playerWidth/2;

	}

	
	public void draw()
	{	
		background(0);
		drawPlayer(playerX,playerY,playerWidth);
		drawBug();
		moveBug();
		text("SCORE: " + score, 20, 20);
		if (bugY > height)
			{
				textAlign(CENTER);
				text("GAME OVER!!!", width/2,height/2);
			}
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
		circle(bugX,bugY,bugWidth);
	}

	public void moveBug()
	{
		if (frameCount % 30 == 0)
		{
			bugX += random(-5,5);
			bugY+= score/2;
			if(bugX < halfBugWidth)
			{
				bugX = halfBugWidth;
			}
			else if (bugX > width - halfBugWidth)
			{
				bugX = width - halfBugWidth;
			}

		}
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
			line(playerX, playerY, playerX, bugY);
			if(playerX  > bugX - halfBugWidth && playerX < bugX + halfBugWidth)
			{
				score++;
				resetBug();
			}
		}
	}	

}
