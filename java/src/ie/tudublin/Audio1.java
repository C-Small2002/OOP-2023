package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
{

    Minim minim;
    AudioInput ai; //audio in
    AudioPlayer ap;
    AudioBuffer ab;

	public void settings()
	{
		size(1024, 500);
	}

	int frameSize = 1024;

	public void setup() {
		colorMode(HSB);
		background(0);

		minim = new Minim(this);

		ai = minim.getLineIn(Minim.MONO, frameSize, 44100, 16); //44100 = cd quality, 16 = 16bits bit rate
		ab = ai.mix; //mix of left and right channels

        ai = minim.getLineIn(Minim.MONO, frameSize, 44100, 16);
        ab = ai.mix;
		
		smooth();
		
	}

	
	
	public void draw()
	{	
		background(0);
		stroke(255);

		float cgap = 255 / (float)ab.size();

		//calculating average of the buffer

		float half = height/2;
		float halfW = width/2;

		float total = 0;
		for(int i = 0; i < ab.size(); i++)
		{
			total += abs(ab.get(i));
			stroke(cgap * i, 255, 255);
			line(i,half,i, half + ab.get(i) * half);
		}
		float avg = total / (float) ab.size();
		float r = avg *600;
		lerpedR = lerp(lerpedR, r, 0.1f);
		circle(halfW,half,lerpedR);

		//lerp(10, 20, 0.1f); //used for smoothing, takes threee parameters

		

		//float lerp(float a, float b, float t)
		//{
		//	return a + (b-a) * t;
		//}

	}

float lerpedR = 0;

}
