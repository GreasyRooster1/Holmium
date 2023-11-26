package main.Worlds;

import main.Main;
import main.Particles.BurstParticle;
import main.Particles.ForceParticles;
import main.World;

public class BurstWorld extends World {
    public BurstWorld(String name) {
        super(name);
    }
    @Override
    public void setup() {
        for(int i=0;i<5000;i++){
            addParticle(new BurstParticle(Main.app.random(Main.app.width), Main.app.random(Main.app.height)));
        }
    }
}
