package main;

import main.Util.Vec;
import processing.core.PConstants;

import static processing.core.PApplet.cos;
import static processing.core.PApplet.sin;

public class Particle {
    private float x;
    private float y;
    private float xvel,yvel,drag;
    private float size;
    private boolean doCollision;
    private World world;
    private float px;
    private float py;
    public Particle(float x,float y,World w){
        this.setX(x);
        this.setY(y);
        setDrag(1);
        setSize(5);
        doCollision =false;
        world = w;
    }
    public void update(){
        move();
        render();
        always();
    }
    public void render(){
        Main.app.ellipse(getX(),getY(),getSize(),getSize());
    }
    public void move(){
        px=getX();
        py=getY();
        velUpdate();
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
    public void always(){

    }
    public void velUpdate(){
        x += xvel;
        y += yvel;
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
        if(x<0){
            x=0;
        }
        if(y<0){
            y=0;
        }
    }

    public void velocityDir(float dir,float mag){
        xvel+=cos(dir)*mag;
        yvel+=sin(dir)*mag;
    }
    public void velocityVec(Vec vec){
        xvel+=vec.x;
        yvel+=vec.y;
    }

    public void renderCircular(int col){
        Main.app.fill(col);
        Main.app.noStroke();
        Main.app.ellipse(getX(),getY(),getSize(),getSize());
    }
    public void renderLine(int col){
        Main.app.stroke(col);
        Main.app.strokeWeight(getSize());
        Main.app.line(getX(), getY(), px, py);
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

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public float getPx() {
        return px;
    }

    public void setPx(float px) {
        this.px = px;
    }

    public float getPy() {
        return py;
    }

    public void setPy(float py) {
        this.py = py;
    }
}
