package main;

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
        mainUniverse.add(1000);
    }
    public void draw(){
        background(0);
        mainUniverse.update();
    }
    public static void main(String[] args) {
        String[] appletArgs = new String[] { "main.Main" };
        PApplet.main(appletArgs);
    }
}