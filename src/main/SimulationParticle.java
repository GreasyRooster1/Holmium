package main;

import static java.lang.Math.round;
import static processing.core.PApplet.*;

public class SimulationParticle extends Particle{
    public SimulationParticle(float x, float y, World w) {
        super(x, y, w);
    }
    public void setSimCell(int x,int y,float value){
        getWorld().simCells[y*getWorld().width+x]=value;
    }
    public void changeSimCell(int x,int y,float value){
        getWorld().simCells[y*getWorld().width+x]+=value;
    }
    public float getSimCell(int x,int y){
        return getWorld().simCells[y*getWorld().width+x];
    }
    public void setSimCellAtPos(float value){
        int px = floor((getX()/Main.app.width)*getWorld().width);
        int py = floor((getY()/Main.app.height)*getWorld().height);
        getWorld().simCells[py*getWorld().width+px]=value;
    }
    public void changeSimCellAtPos(float value){
        int px = floor((getX()/Main.app.width)*getWorld().width);
        int py = floor((getY()/Main.app.height)*getWorld().height);
        px = max(0,px);
        py = max(0,py);
        px = min(getWorld().width-1, px);
        py = min(getWorld().height-1, py);
        getWorld().simCells[py*getWorld().width+px]+=value;
    }
    public float getSimCellAtPos(){
        int px = floor((getX()/Main.app.width)*getWorld().width);
        int py = floor((getY()/Main.app.height)*getWorld().height);
        px = max(0,px);
        py = max(0,py);
        px = min(getWorld().width-1, px);
        py = min(getWorld().height-1, py);
        return getWorld().simCells[py*getWorld().width+px];
    }
    public void setSimCellAtPosOff(int x,int y,float value){
        int px = floor((getX()/Main.app.width)*getWorld().width)+x;
        int py = floor((getY()/Main.app.height)*getWorld().height)+y;
        getWorld().simCells[py*getWorld().width+px]=value;
    }
    public void changeSimCellAtPosOff(int x,int y,float value){
        int px = floor((getX()/Main.app.width)*getWorld().width)+x;
        int py = floor((getY()/Main.app.height)*getWorld().height)+y;
        px = max(0,px);
        py = max(0,py);
        px = min(getWorld().width-1, px);
        py = min(getWorld().height-1, py);
        getWorld().simCells[py*getWorld().width+px]+=value;
    }
    public float getSimCellAtPosOff(int x,int y){
        int px = floor((getX()/Main.app.width)*getWorld().width)+x;
        int py = floor((getY()/Main.app.height)*getWorld().height)+y;
        px = max(0,px);
        py = max(0,py);
        px = min(getWorld().width-1, px);
        py = min(getWorld().height-1, py);
        return getWorld().simCells[py*getWorld().width+px];
    }

    @Override
    public SimulationWorld getWorld() {
        return (SimulationWorld) super.getWorld();
    }
}
