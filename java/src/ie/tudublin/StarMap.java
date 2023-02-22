package ie.tudublin;

import javax.swing.text.TableView.TableRow;

import processing.core.PApplet;

import java.util.ArrayList;
import processing.data.Table;

public class StarMap extends PApplet
{
   

	private ArrayList<Star> stars = new ArrayList<Star>();


	public StarMap() {
	}

	void loadStars()
 	{
		Table table = new Table();
 		table = loadTable("HabHYG15ly.csv", "header");
 		for(processing.data.TableRow r:table.rows())
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
		colorMode(HSB);
		background(0);

		loadStars();
		printStars();
		
		smooth();
	}
	
	public void drawGrid()
	{
		stroke(255);
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

		
	public void draw()
	{	
		strokeWeight(1);		

		drawGrid();
	}
}
