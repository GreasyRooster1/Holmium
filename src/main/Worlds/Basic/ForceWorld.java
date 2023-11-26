package main.Worlds.Basic;

import main.Main;
import main.Particles.Basic.ForceParticles;
import main.World;

public class ForceWorld extends World {
    public ForceWorld(String name) {
        super(name);
    }

    @Override
    public void setup() {
        for(int i=0;i<5000;i++){
            addParticle(new ForceParticles(Main.app.random(Main.app.width), Main.app.random(Main.app.height),this));
        }
    }
}
