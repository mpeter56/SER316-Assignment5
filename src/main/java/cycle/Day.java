package main.java.cycle;

import java.util.Random;

public class Day extends Cycle {

    /**
     * the constructor for the day cycle.
     */
    public Day() {
        this.name = "day";
        this.weather = getRandomWeather();
        setName();
        this.rand = new Random();
    }

}
