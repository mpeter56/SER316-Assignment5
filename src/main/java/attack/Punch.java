package main.java.attack;

public class Punch extends Attack {

    /**
     * the constructor for punch attack.
     */
    public Punch() {
        critChance = 0.4;
        missChance = 0.4;
        damage = 15;
        name = "Punch";
        setRandomType();
    }
}
