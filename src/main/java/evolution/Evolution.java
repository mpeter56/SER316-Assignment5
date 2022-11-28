package main.java.evolution;

import main.java.codeamon.CodeAMon;

public class Evolution {
    protected String name;
    protected int healthModifier;
    protected double attackModifier;
    protected int defenseModifier;
    protected int speedModifier;
    protected double accuracyModifier;
    protected double experienceRateModifier;
    
    /**
     * decorate the cam with an evolution.
     * @param cam the cam to be decorated.
     * @return the decorated cam.
     */
    public CodeAMon evolve(CodeAMon cam) {
        cam.setBaseHealth(cam.getHealth() + getHealthModifier());
        cam.setBaseAttack(cam.getAttack() * getAttackModifier());
        cam.setBaseDefense(cam.getDefense() + getDefenseModifier());
        cam.setBaseSpeed(cam.getSpeed() + getSpeedModifier());
        cam.setBaseAccuracy(cam.getAccuracy() * getAccuracyModifier());
        cam.setBaseXpToLevel((int)(cam.getBaseXpToLevel() * getExperienceRateModifier()));
        return cam;
    }
    
    public int getHealthModifier() {
        return healthModifier;
    }

    public double getAttackModifier() {
        return attackModifier;
    }

    public int getDefenseModifier() {
        return defenseModifier;
    }

    public int getSpeedModifier() {
        return speedModifier;
    }

    public double getAccuracyModifier() {
        return accuracyModifier;
    }

    public double getExperienceRateModifier() {
        return experienceRateModifier;
    }
    
    public String getName() {
        return name;
    }
}
