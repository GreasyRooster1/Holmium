package main.Menu;

import main.Main;

import static processing.core.PApplet.append;
import static processing.core.PConstants.ADD;
import static processing.core.PConstants.BLEND;

public class Constellation {
    public float x,y;
    public Constellation(float x, float y){
        this.x=x;
        this.y=y;
    }

    public void update(){
        move();
        render();
    }

    public void render(){
        Main.app.blendMode(ADD);
        Main.app.noFill();
        Main.app.stroke(127, 255, 255,0.2f);
        Main.app.strokeWeight(20);
        Main.app.ellipse(x,y, 50, 50);

        Main.app.stroke(127, 255, 255,0.5f);
        Main.app.strokeWeight(5);
        Main.app.ellipse(x,y, 50, 50);

        Main.app.stroke(127, 0, 255);
        Main.app.strokeWeight(1);
        Main.app.ellipse(x,y, 50, 50);
        Main.app.noStroke();
        Main.app.blendMode(BLEND);
    }
    public void move(){

    }
}
