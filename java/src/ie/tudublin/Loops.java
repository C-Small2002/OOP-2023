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

	float off = 0;

	public void draw() {
		background(0);
		
		
		switch(mode){
			//case 0:
			//{
			//	if(mouseX < centerX && mouseX > centerX/2){
//
			//		rect(centerX, centerY, width/4, height);
//
			//	}
			//	
			//}
			case 0:{
				int numCircles = (int) (mouseX / 50.0f);
				float d = width / (float) numCircles;
				for(int j =0; j<numCircles;j++){

					for(int i = 0;i < numCircles; i++){
						float x = (d * 0.5f) + d * i;
						float y = (d * 0.5f) + d * j;
						float c = ((i+j) / ((numCircles - 1) * 2.0f)) * 255.0f;
						fill((c + off)%256 ,255,255);
						circle(x,y,d);
						
					}
				}
				off+=mouseY/50.0f;
			}
		}
		

	}
}
