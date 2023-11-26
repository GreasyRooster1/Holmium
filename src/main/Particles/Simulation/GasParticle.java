package main.Particles.Simulation;

import main.Main;
import main.SimulationParticle;
import main.Util.Vec;
import main.World;
import main.Worlds.Simulation.GasWorld;

public class GasParticle extends SimulationParticle {
    public int xOff,yOff;
    public GasParticle(float x, float y, World world) {
        super(x,y,world);
        setDoCollision(true);
        setDrag(0.97f);
        xOff= (int) Main.app.random(-4,4);
        yOff= (int) Main.app.random(-4,4);
    }

    @Override
    public void render() {
        int col = Main.app.color(getSimCellAtPosOff(xOff,yOff)*255,255,255);
        renderCircular(col);
        renderLine(col);
    }

    @Override
    public void always() {
        changeSimCellAtPos((float) 1 / getWorld().size());
        float changeX = 0;
        float changeY = 0;
        changeX+=-getSimCellAtPosOff(1,0);
        changeX-=-getSimCellAtPosOff(-1,0);
        changeY+=-getSimCellAtPosOff(0,1);
        changeY-=-getSimCellAtPosOff(0,-1);
        Vec pressure = new Vec(changeX,changeY);
        pressure.setDir(pressure.dir()+Main.app.random(-1f,1f));
        velocityVec(pressure.divide(2));

    }

    @Override
    public void activeMove() {
        Vec toMouse = new Vec(0,0);
        toMouse.dirTowards(getX(),getY(),Main.app.mouseX,Main.app.mouseY);
        velocityVec(toMouse.divide(1));
    }
}
