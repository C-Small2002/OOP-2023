package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class Audio2 extends PApplet{

    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;
    Minim m;

    FFT fft;


    public void settings(){
        size(1024,1024, P3D);
    }

    public void setup(){
        m = new Minim(this);
        ai = m.getLineIn(Minim.MONO,width,44100,16);
        ab = ai.mix;
       

        fft = new FFT(ai.bufferSize(),ai.sampleRate());
    }
    
    
    float lerpedBuffer[] = new float[1024];
    int highestIndex;
    float lerpedY = 
    public void draw(){
        background(0);
        float halfH = height / 2;

        for(int i = 0; i < ab.size(); i++){
            stroke(map(i,0,ab.size(),0,255));
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
            float f = abs(lerpedBuffer[i] * halfH * 2.0f);
            line(i,halfH + f,i,halfH  - f);
        }

        //println(map1(5,0,10,1000,2000));

        //println(map(5,0,10,1000,2000)); 5 is halfway between 0 and 10, and then find the equivalent between 1000 and 2000

        fft.forward(ab);
        stroke(255);
        for(int i = 0; i < fft.specSize(); i++){
            line(i , height, i, height - fft.getBand(i) * 5.0f);

            if(fft.getBand(i) > fft.getBand(highestIndex)){
                highestIndex = i;
            }
        }

        float freq = fft.indexToFreq(highestIndex);
        fill(255);
        text("Freq: " + freq, 100, 100);

        float y = map(freq, 1000.00f, 2500.00f, height, 0);
        
        circle(200,y,50);

    }

    float map1(float a, float b, float c, float d, float e){
        float f = (a-b) / (c-b);

        float g = f *  + (f * e);

        return g;
    }
    
}
