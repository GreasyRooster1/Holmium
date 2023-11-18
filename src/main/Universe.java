package main;

import java.time.Instant;

import static processing.core.PApplet.append;

public class Universe {
    private float id;
    public Particle[] particles ={};
    Universe(){
        id = Instant.now().toEpochMilli()+Main.app.random(Integer.MAX_VALUE);
    }
    public void add(int amount){
        for(int i=0;i<amount;i++){
            addParticle(new Particle(Main.app.random(Main.app.width),Main.app.random(Main.app.height)));
        }
    }
    public void addParticle(Particle p){
        particles = (Particle[]) append(particles,p);
    }
    public float getId() {
        return id;
    }

    public void update() {
        for(Particle p:particles){
            p.update();
        }
    }
}
