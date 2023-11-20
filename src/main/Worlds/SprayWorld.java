package main.Worlds;


import main.Main;
import main.Particles.SprayParticle;
import main.Particles.VortexParticle;
import main.World;

public class SprayWorld extends World {
    public SprayWorld(String name) {
        super(name);
    }

    @Override
    public void setup() {
        for(int i=0;i<5000;i++){
            addParticle(new SprayParticle(Main.app.random(Main.app.width), Main.app.random(Main.app.height)));
        }
    }
}
