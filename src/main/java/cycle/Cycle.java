package main.java.cycle;

import java.util.Random;

// fulfills requirement 4.
public class Cycle {
    protected Weather weather;
    protected String name;
    protected Random rand;

    public Cycle() {
        rand = new Random();
    }

    // fulfills requirement 5
    /**
     * gets a randomly selected new weather event.
     * @return the new weather event.
     */
    public Weather getRandomWeather() {
        double r = rand.nextDouble();

        if (r <= 0.33) {
            return new Hot();
        } else if (r > 0.33 && r <= 0.66) {
            return new Cold();
        } else {
            return new Rainy();
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName() {
        name = weather.getName() + " " + name;
    }

    /**
     * checks if the current cycle is a night cycle.
     * @return true if it is a night cycle.
     */
    public boolean isNight() {
        if (name.contains("night")) {
            return true;
        } else {
            return false;
        }
    }

    private Weather getThisWeather() {
        return weather;
    }

    public Weather getWeather() {
        return getThisWeather();
    }

}
