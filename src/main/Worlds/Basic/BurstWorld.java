package main.Worlds.Basic;

import main.Main;
import main.Particles.Basic.BurstParticle;
import main.World;

public class BurstWorld extends World {
    public BurstWorld(String name) {
        super(name);
    }
    @Override
    public void setup() {
        for(int i=0;i<5000;i++){
            addParticle(new BurstParticle(Main.app.random(Main.app.width), Main.app.random(Main.app.height),this));
        }
    }
}
