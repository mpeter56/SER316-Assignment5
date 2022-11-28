package main.java.evolution;

import java.util.Random;

public class EvolutionFactory {
    Random rand;

    public EvolutionFactory() {
        rand = new Random();
    }

    /**
     * this method gets a randomly generated evolution.
     * @return a randomly generated evolution.
     */
    public Evolution getRandomEvolution() {
        Evolution evolution;
        double num = rand.nextDouble();
        if (num < 0.167) {
            evolution = new Careful();
        } else if (num >= 0.167 && num < 0.333) {
            evolution = new Hearty();
        } else if (num >= 0.333 && num < 0.5) {
            evolution = new Quick();
        } else if (num >= 0.5 && num < 0.667) {
            evolution = new Smart();
        } else if (num >= 0.667 && num < 0.833) {
            evolution = new Strong();
        } else {
            evolution = new Tough();
        }
        return evolution;
    }
}
