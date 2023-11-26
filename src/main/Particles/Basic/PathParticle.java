package main.Particles.Basic;

import main.Main;
import main.Particle;
import main.World;

import static processing.core.PApplet.*;
import static processing.core.PApplet.max;

public class PathParticle extends Particle {
    public int colOff;
    public float px,py;
    public PathParticle(float x, float y, World w) {
        super(x, y,w);
        setDrag(0.95f);
        colOff = (int) Main.app.random(20);
        setSize(3);
        setDoCollision(true);
    }

    @Override
    public void render() {
        int col = (int) map(atan2(getYvel(),getXvel()),-PI,PI,0,255);
        Main.app.fill(col,255,255);
        Main.app.noStroke();
        Main.app.ellipse(getX(),getY(),getSize(),getSize());
        Main.app.stroke(col,255,255);
        Main.app.strokeWeight(getSize());
        Main.app.line(getX(), getY(), px, py);
    }
    public void activeMove(){
        px = getX();
        py = getY();
        setDrag(0.97f);
        float dirAdd = (Main.app.noise(getX()*0.02f,getY()*0.02f,Main.app.frameCount/100)*PI*2);
        float dir = atan2(getY()-Main.app.mouseY,getX()-Main.app.mouseX)+dirAdd;
        float mag = evalMag();
        setXvel(getXvel()+cos(dir)*mag);
        setYvel(getYvel()+sin(dir)*mag);
    }

    @Override
    public void passiveMove() {
        px = getX();
        py = getY();
        setDrag(0.99f);
        float dir = atan2(Main.app.mouseY-getY(),Main.app.mouseX-getX())+Main.app.random(-2,2);
        float mag = -Main.app.noise(getX()*0.002f,getY()*0.002f,Main.app.frameCount/1000)/100;
        setXvel(getXvel()+cos(dir)*mag);
        setYvel(getYvel()+sin(dir)*mag);
    }

    private float evalMag(){
        float distance = dist(Main.app.mouseX,Main.app.mouseY,getX(),getY());
        float adjustedDistanceSqr=pow(distance/10,3);
        float magAdjusted = adjustedDistanceSqr/100000;
        float minMaxAdjusted=max(magAdjusted,0.5f);
        return minMaxAdjusted;
    }
}
