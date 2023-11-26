package main.Worlds.Basic;

import main.Main;
import main.Particles.Basic.VortexParticle;
import main.World;

public class VortexWorld extends World {
    public VortexWorld(String name) {
        super(name);
    }

    @Override
    public void setup() {
        for(int i=0;i<5000;i++){
            addParticle(new VortexParticle(Main.app.random(Main.app.width), Main.app.random(Main.app.height),this));
        }
    }
}
