package main.Worlds;

import main.Main;
import main.Particles.BasicParticle;
import main.Particles.PathParticle;
import main.World;

public class RainbowWorld extends World {
    public RainbowWorld(String name) {
        super(name);
    }

    @Override
    public void setup() {
        for(int i=0;i<10000;i++){
            addParticle(new BasicParticle(Main.app.random(Main.app.width), Main.app.random(Main.app.height)));
        }
    }
}
