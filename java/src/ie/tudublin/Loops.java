package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

	int mode = 0;
	int x,y,z;
	float centerX = width /2;
	float centerY = height/2;
	public void settings() {
		size(1000, 1000);

	}

	public void setup() {
		colorMode(HSB);
		stroke(255);
	}



	public void keyPressed() {
		
		mode = key - '0';
		println(mode);
	}

	float off = 0;

	public void draw() {
		background(0);
		
		
		switch(mode){
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
				break;
			}

			case 1:{
				
				if(mouseX > width/4 && mouseX <width/2){
					rect(width/4,0,width/4,height);
				}
				else if (mouseX > width/2 && mouseX < width*0.75){
					rect(width/2,0,width/4,height);
				}
				
				break;
			}

			case 2:{
				if(mouseX > width/4 && mouseX < width/2 && mouseY < height && mouseY <height/4){
					rect(width/4,0,width/4,height/4);
				}
				else if (mouseX > width/2 && mouseX < width *0.75 && mouseY < height && mouseY <height/4){
					rect(width/2,0,width/4,height/4);
				}
				else if (mouseX > width/4 && mouseX < width/2 && mouseY >height/4)
				{
					rect(width/4,height/4,width/4,height/4);
				}
				
				break;
			}

			case 3:{
				fill(255);
				rect(width/2, height/3, width/4, height/4);
				if (mouseX > width/2 && mouseX < width/2 + width/4 && mouseY < height/4 && mouseY > height/3 && mouseY <	 height/3 + height/4)
				{
					fill(200,255,255);
					rect(width/2, height/3, width/4, height/4);
				}
				
				break;
			}
			case 4:{
				x = 0;
				y = 0;
				fill(255);
				for (int i =0; i<10; i++){
					fill((x+20)%256,255,255);
					rect(x,y,75,75);
					x += 75;
					y += 75;
				}
				
				break;
			}

			case 5:{
				x = 100;
				y = 100;
				z = 850;
				
				for(int i =0; i<=100; i++){
		
					line(x,y-(50 * i),z,y);
					line(x-(50 * i),y,x,z);
					
					x+=50;
					y+=50;
					z+=50;
					
				}
				
				break;
			}
		}
		

	}
}
