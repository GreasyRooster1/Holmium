package main.Particles.Basic;

import main.Main;
import main.Particle;
import main.World;

import static processing.core.PApplet.*;

public class BasicParticle extends Particle {
    public int colOff;
    public float px,py;
    public BasicParticle(float x, float y, World w) {
        super(x, y,w);
        setDrag(0.95f);
        colOff = (int) Main.app.random(20);
        setSize(3);
        setDoCollision(true);
    }

    @Override
    public void render() {
        Main.app.fill((Main.app.frameCount%255)+colOff,255,255);
        Main.app.noStroke();
        Main.app.ellipse(getX(),getY(),getSize(),getSize());
        Main.app.stroke((Main.app.frameCount%255)+colOff,255,255);
        Main.app.strokeWeight(getSize());
        Main.app.line(getX(), getY(), getPx(), getPy());
    }
    public void activeMove(){
        px = getX();
        py = getY();
        setDrag(0.97f);
        float dir = atan2(Main.app.mouseY-getY(),Main.app.mouseX-getX())+Main.app.random(0.3f);
        float mag = evalMag();
        setXvel(getXvel()+cos(dir)*mag);
        setYvel(getYvel()+sin(dir)*mag);
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
        float adjustedDistanceSqr=pow(distance/10,3);
        //float adjustedDistanceSqr = distance;
        float magAdjusted = adjustedDistanceSqr/100000;
        float minMaxAdjusted=max(magAdjusted,0.5f);
        return minMaxAdjusted;
    }
}
