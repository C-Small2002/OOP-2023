package ie.tudublin;

import processing.core.PVector;
import processing.core.PApplet;

public class Ship {
    private PVector pos;
    private PVector forward;
    private float rot;
    private int c; //color
    private float size;
    private float halfSize;
    PApplet p;

    YASC yasc = ((YASC)p);

    public Ship(float x, float y, float size, int c, PApplet p){
        pos = new PVector(x,y);
        halfSize = size /2;
        forward = new PVector(x,y);
        this.size = size;
        this.c = c;
        this.p = p;
    }

    public void move(){

        YASC yasc = ((YASC)p);

        forward.x = PApplet.sin(rot);
        forward.y = -PApplet.cos(rot);
        if(yasc.keyPressed){    
            if(yasc.keys[PApplet.LEFT]){
                rot -= 0.1f;
            }

            if(yasc.keys[PApplet.RIGHT]){
                rot += 0.1f;
            }

            if(yasc.keys[PApplet.UP]){
                pos.x += forward.x;
                pos.y += forward.y;
            }

            if(yasc.keys[PApplet.DOWN]){
                pos.x -= forward.x;
                pos.y -= forward.y;
            }

            if(yasc.keys[' ']){
                PVector inFront = PVector.add(pos,PVector.mult(forward, 30));
                Bullet b = new Bullet(inFront.x,inFront.y, rot, c, p);

                ((YASC)p).bullets.add(b);
            }
        }
    }

    public void render(){
        p.pushMatrix();
        p.translate(pos.x, pos.y);
        p.rotate(rot);
        p.stroke(c,255,255);
        p.line(-halfSize,halfSize,0, - halfSize);
        p.line(0,-halfSize, 0 + halfSize, 0 +halfSize);
        p.line(0+ halfSize, 0+ halfSize, 0, 0);
        p.line(0,0,0-halfSize,0+halfSize);
        p.popMatrix();
    }

    public PVector getPos() {
        return pos;
    }
    public void setPos(PVector pos) {
        this.pos = pos;
    }
    public float getRot() {
        return rot;
    }
    public void setRot(float rot) {
        this.rot = rot;
    }
    public int getC() {
        return c;
    }
    public void setC(int c) {
        this.c = c;
    }
    public float getSize() {
        return size;
    }
    public void setSize(float size) {
        this.size = size;
    } 
}
