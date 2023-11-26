package main.Worlds.Simulation;

import main.Main;
import main.Particles.Basic.VortexParticle;
import main.Particles.Simulation.GasParticle;
import main.SimulationWorld;

public class GasWorld extends SimulationWorld {
    public GasWorld(String name) {
        super(name);
    }

    @Override
    public void setup() {
        populateSim(40,40,0f);
        decayAmount = 0.99f;
        //showSimCells = true;
        for(int i=0;i<5000;i++){
            addParticle(new GasParticle(Main.app.random(Main.app.width), Main.app.random(Main.app.height),this));
        }

    }

    @Override
    public void simUpdate() {
        int x = 0;
        int y=0;
        int w = Main.app.width/width;
        int h = Main.app.height/height;
        for(int c = 0; c < simCells.length; c++){
            float avg =0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    avg += getSimCell(x + i, y + j);
                }
            }
            avg/=9;
            simCells[c]=avg;
            x++;
            if(x>=width){
                y++;
                x=0;
            }
        }
    }
}
