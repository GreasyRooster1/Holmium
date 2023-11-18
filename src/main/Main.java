package main;

import main.Particles.VortexParticle;
import processing.core.PApplet;

public class Main extends PApplet {
    public static PApplet app;
    public Universe mainUniverse;
    public void settings(){
        size(1000,1000);
    }
    public void setup(){
        Main.app = this;
        mainUniverse = new Universe();
        for(int i=0;i<5000;i++){
            mainUniverse.addParticle(new VortexParticle(random(width),random(height)));
        }
        colorMode(HSB,255,255,255);
    }
    public void draw(){
        fill(0,50);
        rect(0,0,width,height);
        mainUniverse.update();
    }
    public static void main(String[] args) {
        String[] appletArgs = new String[] { "main.Main" };
        PApplet.main(appletArgs);
    }
}