package ie.tudublin;

import processing.core.PApplet;

public class StarMap extends PApplet
{
	public void settings()
	{
		size(500, 500);
	}

	int x,y,w,h;

	public void setup() {
		colorMode(HSB);
		background(0);

		smooth();
		
	}

	public void drawGrid(){
		x=10;
		y=10;
		w=40;
		h=40;
		
		fill(0);
		for(int i =0; i< 11; i++) {
			
			for(int j =0; j< 11; j++){
				rect(x,y,w,h);
				x += w;
			}
			x=10;
			y += h;
		}
	}	

	public void draw()
	{	
		strokeWeight(2);
		stroke(134);
		drawGrid();		
	}
}
