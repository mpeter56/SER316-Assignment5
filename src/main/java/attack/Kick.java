package main.java.attack;

public class Kick extends Attack {

    /**
     * the constructor for kick attack.
     */
    public Kick() {
        critChance = 0.5;
        missChance = 0.5;
        damage = 20;
        name = "Kick";
        setRandomType();
    }
}
