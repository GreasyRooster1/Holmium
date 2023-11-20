package main;

import main.Particles.*;
import main.Worlds.RainbowWorld;
import processing.core.PApplet;

public class Main extends PApplet {
    public static PApplet app;
    public Universe mainUniverse;
    public int worldId = 0;
    public void settings(){
        //size(1000,1000);
        fullScreen();
    }
    public void setup(){
        Main.app = this;
        mainUniverse = new Universe();
        mainUniverse.setWorld("rainbowWorld");
        colorMode(HSB,255,255,255);
    }
    public void draw(){
        noStroke();
        fill(0,50);
        rect(0,0,width,height);
        mainUniverse.update();
    }
    public void keyReleased(){
        if(key=='a'&&worldId>0){
            worldId--;
            mainUniverse.setWorld(worldId);
        }
        if(key=='d'&&worldId<mainUniverse.worlds.length-1){
            worldId++;
            mainUniverse.setWorld(worldId);
        }

    }
    public static void main(String[] args) {
        String[] appletArgs = new String[] { "main.Main" };
        PApplet.main(appletArgs);
    }
}