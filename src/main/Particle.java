package main;

public class Particle {
    float x,y;
    float size;
    Particle(float x,float y){
        this.x = x;
        this.y = y;
        size = 5;
    }
    public void update(){
        move();
        render();
    }
    public void render(){
        Main.app.ellipse(x,y,size,size);
    }
    public void move(){

    }
}
