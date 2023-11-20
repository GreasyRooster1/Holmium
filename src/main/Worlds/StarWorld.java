package main.Worlds;

import main.Main;
import main.Particles.StarParticle;
import main.Particles.VortexParticle;
import main.World;

public class StarWorld extends World {
    public StarWorld(String name) {
        super(name);
    }

    @Override
    public void setup() {
        for(int i=0;i<5000;i++){
            addParticle(new StarParticle(Main.app.random(Main.app.width), Main.app.random(Main.app.height)));
        }
    }
}
