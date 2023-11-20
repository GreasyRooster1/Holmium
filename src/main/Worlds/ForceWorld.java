package main.Worlds;

import main.Main;
import main.Particles.ForceParticles;
import main.Particles.VortexParticle;
import main.World;

public class ForceWorld extends World {
    public ForceWorld(String name) {
        super(name);
    }

    @Override
    public void setup() {
        for(int i=0;i<5000;i++){
            addParticle(new ForceParticles(Main.app.random(Main.app.width), Main.app.random(Main.app.height)));
        }
    }
}
