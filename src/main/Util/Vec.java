package main.Util;

import static processing.core.PApplet.*;

public class Vec {
    public float x,y;
    public Vec(float x,float y){
        this.x = x;
        this.y = y;
    }
    public float mag(){
        return sqrt(pow(x,2)+pow(y,2));
    }
    public Vec normalize(){
        return new Vec(x/mag(),y/mag());
    }
    public void dirTowards(float x, float y, float x1, float y1){
        float dir = atan2(y1-y,x1-x);
        setDir(dir);
    }
    public void setDir(float dir){
        x = cos(dir);
        y = sin(dir);
    }

    public Vec divide(float i) {
        return new Vec(x/i,y/i);
    }

    public float dir() {
        return atan2(y,x);
    }

    public Vec invert(){
        return new Vec(-x,-y);
    }

    public Vec mult(int v) {
        return new Vec(x*v,y*v);
    }
}
