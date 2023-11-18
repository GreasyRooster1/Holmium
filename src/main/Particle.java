package main;

import processing.core.PConstants;

public class Particle {
    private float x;
    private float y;
    private float xvel,yvel,drag;
    private float size;
    private boolean doCollision;
    public Particle(float x,float y){
        this.setX(x);
        this.setY(y);
        setDrag(1);
        setSize(5);
        doCollision =false;
    }
    public void update(){
        move();
        velUpdate();
        render();
    }
    public void render(){
        Main.app.ellipse(getX(),getY(),getSize(),getSize());
    }
    public void move(){
        if(Main.app.mousePressed) {
            activeMove();
        }else{
            passiveMove();
        }
        if(doCollision) {
            collision();
        }
    }
    public void passiveMove(){

    }
    public void activeMove(){

    }
    public void velUpdate(){
        if(Main.app.mousePressed&&Main.app.mouseButton==PConstants.RIGHT){
            x-=xvel;
            y-=yvel;
        }else {
            x += xvel;
            y += yvel;
        }
        xvel*=drag;
        yvel*=drag;
    }
    public void collision(){
        if(x<0||x>Main.app.width){
            xvel*=-1;
        }
        if(y<0||y>Main.app.height){
            yvel*=-1;
        }
        if(x>Main.app.width){
            x=Main.app.width;
        }
        if(y>Main.app.height){
            y=Main.app.height;
        }
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getXvel() {
        return xvel;
    }

    public void setXvel(float xvel) {
        this.xvel = xvel;
    }

    public float getYvel() {
        return yvel;
    }

    public void setYvel(float yvel) {
        this.yvel = yvel;
    }

    public float getDrag() {
        return drag;
    }

    public void setDrag(float drag) {
        this.drag = drag;
    }

    public boolean isDoCollision() {
        return doCollision;
    }

    public void setDoCollision(boolean doCollision) {
        this.doCollision = doCollision;
    }
}
