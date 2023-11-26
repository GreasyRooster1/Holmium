package main.Worlds.Basic;

import main.Main;
import main.Particles.Basic.BasicParticle;
import main.World;

public class RainbowWorld extends World {
    public RainbowWorld(String name) {
        super(name);
    }

    @Override
    public void setup() {
        for(int i=0;i<5000;i++){
            addParticle(new BasicParticle(Main.app.random(Main.app.width), Main.app.random(Main.app.height),this));
        }
    }
}
