package main.java.attack;

public class Burst extends Attack {

    /**
     * the constructor for Burst attack.
     */
    public Burst() {
        critChance = 0.8;
        missChance = 0.7;
        damage = 30;
        name = "Burst";
        setRandomType();

    }

}
