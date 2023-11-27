package main.Menu;

import main.Main;

import java.awt.*;

import static processing.core.PApplet.append;

public class Menu {
    Star[] stars = {};
    public float camX,camY;
    public float camXVel,camYVel;
    public Menu(){
        addStar(0,0);
        camX=Main.app.width/2f;
        camY=Main.app.height
                /2f;
    }
    public void update(){
        Main.app.background(0);
        doDrag();
        moveCam();
        Main.app.pushMatrix();
        Main.app.translate(camX, camY);
        renderStars();
        Main.app.popMatrix();
    }

    public void renderStars(){
        for(Star star:stars){
            star.update();
        }
    }
    public void moveCam(){
        camX+=camXVel;
        camY+=camYVel;
        camXVel*=0.9f;
        camYVel*=0.9f;
    }
    public void doDrag(){
        if(Main.app.mousePressed){
            camXVel=Main.app.mouseX-Main.app.pmouseX;
            camYVel=Main.app.mouseY-Main.app.pmouseY;
            //lockMouse();
        }
    }
    public void lockMouse(){
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        robot.mouseMove(Main.app.width/2+Main.app.windowX, Main.app.height/2+Main.app.windowY);
        //Main.app.noCursor();
    }
    public void addStar(float x,float y){
        stars = (Star[]) append(stars,new Star(x,y));
    }
}
