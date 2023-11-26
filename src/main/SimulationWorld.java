package main;

import static processing.core.PApplet.*;

public class SimulationWorld extends World{
    public float[] simCells = {};
    public int width = 0;
    public int height = 0;
    public boolean showSimCells = false;
    public float decayAmount =1;

    public SimulationWorld(String name) {
        super(name);
    }
    public void populateSim(int w,int h,float value){
        simCells = new float[0];
        width = w;
        height = h;
        for(int i=0;i<w*h;i++){
            simCells = append(simCells,value);
        }
    }

    @Override
    public void update() {
        if(showSimCells) {
            renderCells();
        }
        if(shader !=null) {
            Main.app.shader(shader);
        }
        for(Particle p:particles){
            p.update();
        }
        simUpdate();
        decay();
    }
    public void decay() {
        int c=0;
        for(float f:simCells){
            simCells[c]*=decayAmount;
            c++;
        }
    }
    public void renderCells(){
        int x = 0;
        int y=0;
        int w = Main.app.width/width;
        int h = Main.app.height/height;
        for(float f:simCells){
            Main.app.fill(f*255f,255,255);
            Main.app.rect(x*w,y*h,w,h);
            x++;
            if(x>=width){
                y++;
                x=0;
            }
        }
    }
    public void simUpdate(){

    }
    public void setSimCell(int x,int y,float value){
        simCells[y*width+x]=value;
    }
    public void changeSimCell(int x,int y,float value){
        simCells[y*width+x]+=value;
    }
    public float getSimCell(int x,int y) {
        x=max(x,0);
        y=max(y,0);
        x=min(x,width-1);
        y=min(y,height-1);
        return simCells[y * width + x];
    }
}
