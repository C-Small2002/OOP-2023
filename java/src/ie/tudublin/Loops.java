package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

	int mode = 0;
	float centerX = width /2;
	float centerY = height/2;
	public void settings() {
		size(1000, 1000);

	}

	public void setup() {
		colorMode(HSB);
	}



	public void keyPressed() {
		
		mode = key - '0';
		println(mode);
	}

	public void draw() {
		background(0);
		fill(230,240,210);
		
		switch(mode){
			case 0:
			{
				if(mouseX < centerX && mouseX > centerX/2){

					rect(centerX, centerY, width/4, height);

				}
				
			}
		}
		

	}
}
