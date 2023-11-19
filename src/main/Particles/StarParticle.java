package main.Particles;

import main.Main;
import main.Particle;

import static processing.core.PApplet.*;

public class StarParticle extends Particle {
    public int life = 100;
    public int colOff;
    public float px,py;
    public StarParticle(float x, float y) {
        super(x, y);
        setDrag(0.95f);
        life = (int) Main.app.random(2000);
        colOff = (int) Main.app.random(3);
        setSize(3);
        setDoCollision(true);
    }

    @Override
    public void render() {

        int col1 = Main.app.color(0,255,0);
        int col2 = Main.app.color(0,255,255);
        int col3 = Main.app.color(25,255,255);
        int col4 = Main.app.color(50,255,255);
        int col5 = Main.app.color(50,0,255);
        float mag = sqrt(pow(getXvel(),2)+pow(getYvel(),2));
        float maxVel = 30;
        float colFac = maxVel/4;
        int col =0;
        if(mag<colFac){
            Main.app.colorMode(RGB);
            col = Main.app.lerpColor(col1,col2,mag/colFac);
            Main.app.colorMode(HSB);
        } else if (mag<colFac*2) {
            col = Main.app.lerpColor(col2,col3,(mag-colFac)/colFac);
        } else if (mag<colFac*3) {
            col = Main.app.lerpColor(col3,col4,(mag-colFac*2)/colFac);
        } else {
            col = Main.app.lerpColor(col4,col5,(mag-colFac*3)/colFac);
        }
        Main.app.fill(col);
        Main.app.noStroke();
        Main.app.ellipse(getX(),getY(),getSize(),getSize());
        Main.app.stroke(col);
        Main.app.strokeWeight(getSize());
        if(life<495) {
            Main.app.line(getX(), getY(), px, py);
        }
    }
    public void activeMove(){
        px = getX();
        py = getY();
        setDrag(0.97f);
        float dir = atan2(Main.app.mouseY-getY(),Main.app.mouseX-getX())+Main.app.random(0.1f);
        float mag = evalMag();
        setXvel(getXvel()+cos(dir)*mag);
        setYvel(getYvel()+sin(dir)*mag);
        life--;
        if(life<1){
            setX(Main.app.random(Main.app.width));
            setY(Main.app.random(Main.app.height));
            setXvel(0);
            setYvel(0);
            life =500;
        }
    }

    @Override
    public void passiveMove() {
        px = getX();
        py = getY();
        setDrag(0.99f);
        float dir = Main.app.random(6.48f);
        float mag = 0.05f;
        setXvel(getXvel()+cos(dir)*mag);
        setYvel(getYvel()+sin(dir)*mag);
    }

    private float evalMag(){
        float dist = dist(Main.app.mouseX,Main.app.mouseY,getX(),getY());
        if(dist<70){
            return 15;
        }
        float distance = 1/dist;
        float adjustedDistanceSqr=pow(distance,2);
        float magAdjusted = adjustedDistanceSqr/1000;
        float minMaxAdjusted=max(magAdjusted,0.1f);
        return minMaxAdjusted;
    }
}
