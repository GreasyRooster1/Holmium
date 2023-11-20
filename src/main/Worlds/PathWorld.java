package main.Worlds;

import main.Main;
import main.Particles.PathParticle;
import main.World;

public class PathWorld extends World {
    public PathWorld(String name) {
        super(name);
    }

    @Override
    public void setup() {
        for(int i=0;i<10000;i++){
            addParticle(new PathParticle(Main.app.random(Main.app.width), Main.app.random(Main.app.height)));
        }
    }
}
