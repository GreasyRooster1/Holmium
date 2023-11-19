package main;

import main.Worlds.RainbowWorld;

import java.time.Instant;

import static processing.core.PApplet.append;

public class Universe {
    private float id;

    public World[] worlds ={};
    public World currentWorld;
    Universe(){
        id = Instant.now().toEpochMilli()+Main.app.random(Integer.MAX_VALUE);
        registerWorlds();
    }
    public void registerWorlds(){
        addWorld(new RainbowWorld("rainbowWorld"));
    }
    public void addWorld(World w){
        w.setup();
        worlds = (World[]) append(worlds,w);
    }

    public void setWorld(String name) {
        for(World w:worlds){
            if(w.name==name){
                currentWorld = w;
            }
        }
    }

    public void update() {
        currentWorld.update();
    }
}
