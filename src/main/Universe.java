package main;

import main.Menu.Constellation;
import main.Worlds.Basic.*;
import main.Worlds.Simulation.GasWorld;

import java.time.Instant;

import static processing.core.PApplet.append;

public class Universe {
    private float id;

    public World[] worlds ={};
    public World currentWorld;
    public Constellation constellation = new Constellation((float)Main.app.width/2,75);
    Universe(){
        id = Instant.now().toEpochMilli()+Main.app.random(Integer.MAX_VALUE);
        registerWorlds();
    }
    public void registerWorlds(){
        addWorld(new RainbowWorld("rainbowWorld"));
        addWorld(new ForceWorld("forceWorld"));
        addWorld(new SprayWorld("sprayWorld"));
        addWorld(new StarWorld("starWorld"));
        addWorld(new VortexWorld("vortexWorld"));
        addWorld(new PathWorld("pathWorld"));
        addWorld(new BurstWorld("burstWorld"));

        addWorld(new GasWorld("gasWorld"));
    }
    public void addWorld(World w){
        w.setup();
        worlds = (World[]) append(worlds,w);
    }

    public void setWorld(String name) {
        for(World w:worlds){
            if(w.name==name){
                w.reset();
                currentWorld = w;
            }
        }
    }
    public void setWorld(int id) {
        worlds[id].reset();
        currentWorld = worlds[id];
    }

    public void update() {
        currentWorld.update();
        //constellation.update();
    }
}
