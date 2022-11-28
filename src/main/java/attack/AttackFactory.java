package main.java.attack;

import java.util.Random;

import main.java.type.Electric;
import main.java.type.Fire;
import main.java.type.Normal;
import main.java.type.Plant;
import main.java.type.Rock;
import main.java.type.Type;
import main.java.type.Water;

public class AttackFactory {
    Random rand;

    public AttackFactory() {
        rand = new Random();
    }

    /**
     * get a random attack.
     * @return a randomly created attack
     */
    public Attack getRandomAttack() {
        Attack attack;
        double num = rand.nextDouble();
        if (num < 0.25) {
            attack = new Burst();
        } else if (num >= 0.25 && num < 0.5) {
            attack = new Kick();
        } else if (num >= 0.5 && num < 0.75) {
            attack = new Punch();
        } else {
            attack = new Whirlwind();
        }
        return attack;
    }

}
