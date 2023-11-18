package main.Particles;

import main.Main;
import main.Particle;

import static processing.core.PApplet.*;
import static processing.core.PApplet.max;

public class VortexParticle extends Particle {
    public int colOff;
    public int colVal;
    public float px,py;
    boolean renderLine = true;
    public VortexParticle(float x, float y) {
        super(x, y);
        setDrag(0.95f);
        colOff = (int) Main.app.random(30);
        colVal = -100;
        setSize(3);
        setDoCollision(false);
    }

    @Override
    public void render() {
        int col1 = Main.app.color(127,255,255);
        int col2 = Main.app.color(170,255,255);
        int col = Main.app.lerpColor(col1,col2,(float)(abs(colVal)+colOff)/100);
        Main.app.fill(col);
        Main.app.noStroke();
        Main.app.ellipse(getX(),getY(),getSize(),getSize());
        Main.app.stroke(col);
        Main.app.strokeWeight(getSize());
        setSize(dist(getX(),getY(),Main.app.mouseX,Main.app.mouseY)/200+3);
        if(colVal>100){
            colVal=-100;
        }
        colVal++;
        if(renderLine) {
            Main.app.line(getX(), getY(), px, py);
        }else{
            renderLine=true;
        }
    }
    public void activeMove(){
        px = getX();
        py = getY();
        setDrag(0.97f);
        float dir = atan2(Main.app.mouseY-getY(),Main.app.mouseX-getX())+Main.app.random(0.1f)+PI/2;
        float mag = evalMag();
        setXvel(getXvel()+cos(dir)*mag);
        setYvel(getYvel()+sin(dir)*mag);
        if(dist(0,0,getX(),getY())>max(Main.app.width,Main.app.height)*2||round(Main.app.random(40))==0){
            setX(Main.app.random(Main.app.width));
            setY(Main.app.random(Main.app.height));
            setXvel(0);
            setYvel(0);
            renderLine=false;
        }
    }

    @Override
    public void passiveMove() {
        px = getX();
        py = getY();
        setDrag(0.99f);
        float dir = atan2(Main.app.mouseY-getY(),Main.app.mouseX-getX())+Main.app.random(0.1f)+PI/3;
        float mag = 0.005f;
        setXvel(getXvel()+cos(dir)*mag);
        setYvel(getYvel()+sin(dir)*mag);
    }

    private float evalMag(){
        float distance = dist(Main.app.mouseX,Main.app.mouseY,getX(),getY());
        float adjustedDistance=distance/1000;
        float minMaxAdjusted=max(adjustedDistance,0.1f);
        return minMaxAdjusted;
    }
}
