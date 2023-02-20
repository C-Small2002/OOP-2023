package ie.tudublin;

import javax.swing.text.TableView.TableRow;

import processing.core.PApplet;

import java.util.ArrayList;
import processing.data.Table;

public class StarMap extends PApplet
{

	private boolean hab;
	private String displayName;
	private float distance;
	private float xG;
	private float yG;
	private float zG;
	private float absMag;

    public StarMap(boolean hab, String displayName, float distance, float xG, float yG, float zG, float absMag) {
		this.hab = hab;
		this.displayName = displayName;
		this.distance = distance;
		this.xG = xG;
		this.yG = yG;
		this.zG = zG;
		this.absMag = absMag;
	}

	private ArrayList<StarMap> stars = new ArrayList<StarMap>();

	public StarMap(processing.data.TableRow r)
 	{
 		this(
 			r.getInt("Hab?") == 1, 
 			r.getString("Display Name"), 
 			r.getFloat("Distance"),
 			r.getFloat("Xg"),
 			r.getFloat("Yg"),
 			r.getFloat("Zg"),
 			r.getFloat("AbsMag")
 		);
 	}

	public StarMap() {
	}

	void loadStars()
 	{
		Table table = new Table();
 		table = loadTable("HabHYG15ly.csv", "header");
 		for(processing.data.TableRow r:table.rows())
 		{
 			StarMap s = new StarMap(r);
 			stars.add(s);
		}
 	}

	void printStars()
	{
		
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
		}
		
	}

	public void drawStar()
	{
		for(int i = 0; i< stars.size(); i++){
			line(this.xG,this.yG,this.xG,this.yG);
		}
		
	}
		
	public void draw()
	{	
		strokeWeight(1);		

		drawGrid();
		drawStar();
	}
}
