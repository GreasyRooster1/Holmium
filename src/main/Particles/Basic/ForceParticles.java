package main.Particles.Basic;

import main.Main;
import main.Particle;
import main.World;

import static processing.core.PApplet.*;
import static processing.core.PApplet.max;

public class ForceParticles extends Particle {
    public int life = 100;
    public int colOff;
    public float px,py;
    public ForceParticles(float x, float y, World w) {
        super(x, y,w);
        setDrag(0.95f);
        life = (int) Main.app.random(2000);
        colOff = (int) Main.app.random(3);
        setSize(3);
        setDoCollision(true);
    }

    @Override
    public void render() {
        int col2 = Main.app.color(145,0,255);
        int col1 = Main.app.color(170,255,255);
        float mag = sqrt(pow(getXvel(),2)+pow(getYvel(),2));
        int col = Main.app.lerpColor(col1,col2,(float)(abs(mag)+colOff)/30);
        Main.app.fill(col);
        Main.app.noStroke();
        Main.app.ellipse(getX(),getY(),getSize(),getSize());
        Main.app.stroke(col);
        Main.app.strokeWeight(getSize());
        if(life<495) {
            Main.app.line(getX(), getY(), getPx(), getPy());
        }
    }
    public void activeMove(){
        px = getX();
        py = getY();
        setDrag(0.97f);
        float dir = atan2(getY()-Main.app.mouseY,getX()-Main.app.mouseX)+Main.app.random(0.1f);
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
        float distance = dist(Main.app.mouseX,Main.app.mouseY,getX(),getY());
        if(distance<70){
            return 10;
        }
        float adjustedDistanceSqr=pow(distance/10,2);
        float magAdjusted = adjustedDistanceSqr/100000000;
        float minMaxAdjusted=max(magAdjusted,0.1f);
        return minMaxAdjusted;
    }
}
