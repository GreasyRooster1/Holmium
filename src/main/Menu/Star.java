package main.Menu;

import main.Main;

public class Star {
    public float x,y;
    Star(float x,float y){
        this.x=x;
        this.y=y;
    }

    public void update(){
        for(int i=0;i<10;i++) {
            Main.app.fill(127, 255-i*25, 255, 25);
            Main.app.ellipse(x, y, 25-i*2, 25-i*2);
        }
    }
}
