package main.java.cycle;

import java.util.Random;

public class Night extends Cycle {

    /**
     * the constructor for the night cycle.
     */
    public Night() {
        this.name = "night";
        this.weather = getRandomWeather();
        setName();
        this.rand = new Random();
    }

}
