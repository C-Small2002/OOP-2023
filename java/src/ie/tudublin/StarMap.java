package ie.tudublin;

import processing.core.PApplet;

import java.util.ArrayList;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet
{
   

	private ArrayList<Star> stars = new ArrayList<Star>();
	float border;
	int first;
	int second;


	public StarMap() {
	}

	void loadStars()
 	{
		
 		Table table = loadTable("HabHYG15ly.csv", "header");
 		for(TableRow r : table.rows())
 		{
 			Star s = new Star(r);
 			stars.add(s);
		}
 	}

	void printStars()
	{
		for(Star s:stars){
			System.out.println(s);
		}
	}

	public void settings()
	{
		size(800, 800);
	}

	public void setup() {
		colorMode(RGB);
		background(0);

		loadStars();
		printStars();
		
		smooth();
	}
	
	public void drawGrid()
	{
		stroke(255,0,255);
		float border = 50.0f;

		int count = 10;
		float gap = (width - (border * 2.0f)) / (float) count;
		for(int i = -5 ; i <= 5 ; i ++)
		{
			float x = border + (gap * (i + 5));
			line(x, border, x, height - border);
			line(border, x, width - border, x);
			fill(255);
			text(i, x, border * 0.5f);
			text(i, border * 0.5f, x);
		}
		
	}

    public void mouseClicked(){

		for(int i = 0; i < stars.size(); i++){
			
			Star s = stars.get(i);

			float x = map(s.getxG(), -5, 5, border , width - border);
			float y = map(s.getyG(),-5, 5,border, height - border);
			if(dist(mouseX, mouseY, x, y) < s.getAbsMag()/2) // size/2 to make more precise
			{
				if (first == -1) //if haven't clicked yet
				{
					first = i; //position in star array
				}
				else if(second == -1)
				{
					second = i;
				}
				else
				{
					first = i;
					second = -1;
				}
			}
			
		}

        

    }

	public void mouseDragged(float x , float y){

		System.out.println("MouseDragged");
		stroke(255);
		line(x,y,mouseX,mouseY);

	}

	public void drawStar(){
		for(Star s : stars){
			s.render(this);
		}
	}

		
	public void draw()
	{	
		strokeWeight(1);		

		background(0);
		drawStar();
		drawGrid();

		if (first != -1 && second == -1)
        {
            Star s1 = stars.get(first);
            float x = map(s1.getxG(), -5, 5, border, width - border);
            float y = map(s1.getyG(), -5, 5, border, height - border);
            stroke(255, 255, 0);
            line(x, y, mouseX, mouseY);
        }
        else if (first != -1 && second != -1)
        {
            Star s1 = stars.get(first);
            Star s2= stars.get(second);

            float x1 = map(s1.getxG(), -5, 5, border, width - border);
            float y1 = map(s1.getyG(), -5, 5, border, height - border);
            float z1 = map(s1.getzG(), -5, 5, border, height - border);

            float x2 = map(s2.getxG(), -5, 5, border, width - border);
            float y2 = map(s2.getyG(), -5, 5, border, height - border);
            float z2 = map(s2.getzG(), -5, 5, border, height - border);
			stroke(255, 255, 0);
            line(x1, y1, x2, y2);
            fill(255);
            float dist = dist(x1, y1, z1, x2, y2, z2);
            text("Distance from " + s1.getDisplayName() + " to " + s2.getDisplayName() + " is " + dist + " parsecs", border, height - 25);
		}
	}
}
