package main.java.attack;

public class Whirlwind extends Attack {

    /**
     * the constructor for whirlwind attack.
     */
    public Whirlwind() {
        critChance = 0.3;
        missChance = 0.3;
        damage = 20;
        name = "Whirlwind";
        setRandomType();
    }
}
