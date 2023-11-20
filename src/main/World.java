package main;

import static processing.core.PApplet.append;

public class World {
    public String name;
    public Particle[] particles ={};

    public World(String name){
        this.name = name;
    }

    public void setup(){

    }

    public void addParticle(Particle p){
        particles = (Particle[]) append(particles,p);
    }

    public void update() {
        for(Particle p:particles){
            p.update();
        }
    }

    public void reset(){
        particles = new Particle[0];
        setup();
    }
}
