package main.java.type;

import java.util.Random;

public class TypeFactory {
    Random rand;

    public TypeFactory() {
        rand = new Random();
    }

    /**
     * gets a randomly created type.
     * @return the created type
     */
    public Type getRandomType() {
        Type type;
        double num = rand.nextDouble();
        if (num < 0.167) {
            type = new Electric();
        } else if (num >= 0.167 && num < 0.333) {
            type = new Fire();
        } else if (num >= 0.333 && num < 0.5) {
            type = new Normal();
        } else if (num >= 0.5 && num < 0.667) {
            type = new Plant();
        } else if (num >= 0.667 && num < 0.833) {
            type = new Rock();
        } else {
            type = new Water();
        }
        return type;
    }
}
