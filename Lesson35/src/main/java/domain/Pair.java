package domain;

import lombok.Data;

@Data
public class Pair {
    private Horse horse;
    private Jockey jockey;
    private double speed;
    private double time;
    public final Double distance = 1000.0;

    public Pair(Horse horse, Jockey jockey) {
        this.horse = horse;
        this.jockey = jockey;
        this.speed = 10 + Math.random();
        this.speed = 20 + Math.random() * 10;
        this.time = 0.0;
    }
    public void setTime() {
        time += distance / (speed - Math.random() * 5);
    }

    @Override
    public String toString() {
        return "Pair: " +
                horse +
                ", " + jockey;

    }
}
