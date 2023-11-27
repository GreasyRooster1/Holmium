package main.Particles.Basic;

import main.Main;
import main.Particle;
import main.World;

import static processing.core.PApplet.*;
import static processing.core.PApplet.max;

public class BurstParticle extends Particle {
    public int colOff;
    public float px,py;
    public int burstGroup;
    int mouseHeldFrames = 0;
    int maxBurst = 15;
    float life;
    private boolean renderLine=true;

    public BurstParticle(float x, float y, World w) {
        super(x, y,w);
        setDrag(0.99f);

        setSize(4);
        setDoCollision(true);
        burstGroup = (int)Main.app.random(maxBurst);
        colOff = (int) Main.app.random(20)+burstGroup*(255/maxBurst);
    }
    public void render() {
        float mag = sqrt(pow(getXvel(),2)+pow(getYvel(),2));
        int col = Main.app.color(((Main.app.frameCount%255)+colOff)%255,255, 255);
        Main.app.fill(col);
        Main.app.noStroke();
        Main.app.ellipse(getX(),getY(),getSize(),getSize());
        if(renderLine) {
            Main.app.stroke(col);
            Main.app.strokeWeight(getSize());
            Main.app.line(getX(), getY(), getPx(), getPy());
        }
    }
    public void activeMove(){
        px = getX();
        py = getY();
        renderLine=true;
        if(round((float) Main.app.frameCount / 10) % maxBurst == burstGroup){
            setX(Main.app.mouseX);
            setY(Main.app.mouseY);
            float dir = Main.app.random(6.48f);
            float mag = Main.app.random(6)+1;
            setXvel(cos(dir)*mag);
            setYvel(sin(dir)*mag);
            life=80;
            renderLine=false;
        }
        life-=Main.app.random(-0.5f,1f);
    }

    @Override
    public void passiveMove() {
        px = getX();
        py = getY();
        life--;
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
