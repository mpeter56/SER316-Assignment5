package main.java.attack;

import main.java.type.Type;
import main.java.type.TypeFactory;

public class Attack {
    Type type;
    double critChance;
    double missChance;
    int damage;
    String name;

    public Attack() {
        setRandomType();
    }

    public void setRandomType() {
        TypeFactory factory = new TypeFactory();
        this.type = factory.getRandomType();
    }

    private Type getThisType() {
        return type;
    }

    public Type getType() {
        return getThisType();
    }

    public int getDamage() {
        return damage;
    }

    public double getCritChance() {
        return critChance;
    }

    public double getMissChance() {
        return missChance;
    }

    public String getName() {
        return type.toString() + " " + name;
    }
}
