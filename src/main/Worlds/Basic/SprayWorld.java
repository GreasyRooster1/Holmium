package main.Worlds.Basic;


import main.Main;
import main.Particles.Basic.SprayParticle;
import main.World;

public class SprayWorld extends World {
    public SprayWorld(String name) {
        super(name);
    }

    @Override
    public void setup() {
        for(int i=0;i<5000;i++){
            addParticle(new SprayParticle(Main.app.random(Main.app.width), Main.app.random(Main.app.height),this));
        }
    }
}
