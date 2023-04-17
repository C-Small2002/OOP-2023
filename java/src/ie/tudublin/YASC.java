package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class YASC extends PApplet
{

	Ship ship;
	Ship ship1;

	public boolean[] keys = new boolean[1024];
	
	public void keyPressed(){
		keys[keyCode] = true;
	}

	public void keyReleased(){
		keys[keyCode] = false;	
	}

	ArrayList<GameObject> gameobject = new ArrayList<GameObject>();

	public void settings()
	{
		size(500, 500);

		PVector a = new PVector(10, 10);
        PVector b = new PVector(20, 20);

        b = a;
        
        b.x = 30;
        b.y = 30;

        println(a);
		
	}

	String s3 = "Hello";

	public void setup() {
		ship = new Ship(width / 2, height / 2, 50, 70, this);
		ship1 = new Ship(100, 50, 50, 6, this);
		colorMode(HSB);

		String s = "I love Star Trek";

		s += " & 200AD";

		String s1 = s.substring(2, 6);

		println(s.substring(7, 11));

		println(s.indexOf("Trek"));

		println(s.startsWith("Ilove"));

		String ss3 = "Hell";
		String temp = "o";
		String s2 = "Hello";
		
		String s4 = ss3 + temp;

		println(s4 == s2);
		println(s4.equals(s2));
		


		println();

		/*startsWith
		endsWidth
		substring
		indexOf
		s1.chatAt
		s1.lastIndexOf
		s1.toUpperCase()
		s1.compareTo(s)
		s1.equals
		s1.

		println(s1);
		*/
	}

	public void draw()
	{	background(0);
		noStroke();
		fill(0,20);
		rect(0,0,width,height);
		ship.render();
		ship.update();

		ship1.render();
		ship1.update();

		for(int i = gameobject.size() - 1 ; i >= 0 ; i --)
		{
			GameObject b = gameobject.get(i);
			b.render();
			b.update();
		}
		

		fill(255);
		text("Bullets: " + gameobject.size(), 50, 50);

	}
}
