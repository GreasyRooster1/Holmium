package main.Particles;

import main.Main;
import main.Particle;

import static java.lang.Math.random;
import static processing.core.PApplet.*;
import static processing.core.PConstants.PI;

public class SprayParticle extends Particle {
    public int colOff;
    public int colVal;
    public float px,py;
    boolean renderLine = true;
    int life;
    public SprayParticle(float x, float y) {
        super(x, y);
        setDrag(0.95f);
        colOff = (int) Main.app.random(30);
        colVal = -100;
        life = (int) Main.app.random(200);
        setSize(2);
        setDoCollision(true);
    }

    @Override
    public void render() {
        int col1 = Main.app.color(0,255,255);
        int col2 = Main.app.color(40,255,255);
        int col = Main.app.lerpColor(col1,col2,(float)(abs(life)+colOff)/200);
        Main.app.fill(col);
        Main.app.noStroke();
        Main.app.ellipse(getX(),getY(),getSize(),getSize());
        Main.app.stroke(col);
        Main.app.strokeWeight(getSize());
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
        setDrag(0.99f);
        life--;
        if(life<1){
            setX(Main.app.mouseX);
            setY(Main.app.mouseY);
            float dir =(atan2((float)Main.app.height/2-getY(), (float)Main.app.width/2-getX()))+Main.app.random(-0.2f,0.2f);
            float mag =(dist(getX(),getY(),Main.app.width/2,Main.app.height/2)/15)+2;
            setXvel(getXvel()+cos(dir)*mag);
            setYvel(getYvel()+sin(dir)*mag);
            setXvel(getXvel()+Main.app.random(-2,2));
            setYvel(getYvel()+Main.app.random(-2,2));
            renderLine=false;
            life= (int) Main.app.random(170,230);
        }
    }

    @Override
    public void passiveMove() {
        px = getX();
        py = getY();
        setDrag(0.95f);
        float dir = atan2(Main.app.mouseY-getY(),Main.app.mouseX-getX())+Main.app.random(0.1f)+PI;
        float mag = 0.05f;
        setXvel(getXvel()+cos(dir)*mag);
        setYvel(getYvel()+sin(dir)*mag);
    }
}
