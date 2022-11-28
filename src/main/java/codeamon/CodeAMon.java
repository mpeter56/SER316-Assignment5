package main.java.codeamon;

import java.util.ArrayList;
import java.util.Random;

import main.java.attack.Attack;
import main.java.attack.AttackFactory;
import main.java.evolution.Evolution;
import main.java.type.Type;
import main.java.type.TypeFactory;

// fulfills requirement 10
public abstract class CodeAMon {
    private int trainerId;
    private int level;
    private int experience;
    private int xpToLevel;
    private Type type;
    private Attack[] attacks;
    private String name;
    protected String animal;
    private int health;
    private double attack;
    private int defense;
    private int speed;
    private double accuracy;
    private int fullHealth;
    private int baseHealth;
    protected int baseXpToLevel;
    protected double baseAttack;
    protected int baseDefense;
    protected int baseSpeed;
    protected double baseAccuracy;
    private ArrayList<Evolution> evolutions;
    private Random rand;

    /**
     * initializes the new codeamon.
     * @param type the type of the codeamon.
     * @param attacks the attacks of the codeamon.
     * @param level the level of the codeamon.
     * @param trainerId the id of the trainer that this codeamon belongs to.
     */
    public void initialize(Type type, Attack[] attacks, int level, int trainerId) {
        this.trainerId = trainerId;
        this.level = level;
        this.setExperience(0);
        this.xpToLevel = calculateXpToLevel();
        setType(type);
        this.baseHealth = 100;
        this.setAttacks(attacks);
        this.setName(calculateName());
        this.setFullHealth(calculateHealth());
        this.setHealth(fullHealth);
        this.setAttack(calculateAttack());
        this.setDefense(calculateDefense());
        this.setSpeed(calculateSpeed());
        this.setAccuracy(calculateAccuracy());
        this.evolutions = new ArrayList<Evolution>();
        rand = new Random();
    }

    private void setType(Type type2) {
        this.type = type2;
    }

    /**
     * this method gets a new attack for the codeamon.
     * @param index the index of the attack to replace.
     */
    public void getNewAttack(int index) {
        if (index == -1) {
            Attack[] newAttacks = new Attack[attacks.length + 1];
            for (int i = 0; i < attacks.length; i++) {
                newAttacks[i] = attacks[i];
            }

            newAttacks[attacks.length] = (new AttackFactory()).getRandomAttack();
            this.attacks = newAttacks;
        } else if (index == -2) {
            return;
        } else {
            this.attacks[index] = (new AttackFactory()).getRandomAttack();
        }
    }

    /**
     * level up if below level 16, which means we wont need to replace an attack.
     */
    public void levelUpBelow16() {
        if (this.experience >= xpToLevel) {
            System.out.println(name + " leveled up!");
            print();
            this.setExperience(experience - xpToLevel);
            this.level++;
            this.xpToLevel = calculateXpToLevel();
            this.setFullHealth(calculateHealth());
            this.setHealth(fullHealth);
            this.setAttack(calculateAttack());
            this.setDefense(calculateDefense());
            this.setSpeed(calculateSpeed());
            this.setAccuracy(calculateAccuracy());
            if (level == 5 || level == 10 || level == 15) {
                getNewAttack(-1);
            }
            levelUpBelow16();

        }
    }

    /**
     * level up at or after level 16.
     * @param index of the attack to replace
     */
    public void levelUp(int index) {
        if (this.experience >= xpToLevel) {
            System.out.println(name + " leveled up!");
            this.level++;
            this.setExperience(0);
            this.xpToLevel = calculateXpToLevel();
            this.setFullHealth(calculateHealth());
            this.setHealth(fullHealth);
            this.setAttack(calculateAttack());
            this.setDefense(calculateDefense());
            this.setSpeed(calculateSpeed());
            this.setAccuracy(calculateAccuracy());
            if (level >= 20 && level % 5 == 0) {
                getNewAttack(index);
            }
            print();
            levelUp(index);
        }
    }

    private int calculateXpToLevel() {
        int newXp = (int) calculateMultiplyIncrease(baseXpToLevel, 1.1);
        return newXp;
    }

    private String calculateName() {
        String name = type.getName() + "-" + this.animal;
        return name;
    }

    protected int calculateHealth() {
        return calculateAdditionIncrease(baseHealth, 10);
    }

    protected double calculateAttack() {
        return calculateMultiplyIncrease(baseAttack, 1.05);
    }

    protected int calculateDefense() {
        return (int) calculateMultiplyIncrease(baseDefense, 1.05);
    }

    protected int calculateSpeed() {
        return calculateAdditionIncrease(baseSpeed, 1);
    }

    protected double calculateAccuracy() {
        return calculateMultiplyIncrease(baseAccuracy, 1.01);
    }

    protected double calculateMultiplyIncrease(double original, double increase) {
        double num = original;
        for (int i = 1; i < level; i++) {
            num = (num * increase);
        }
        return num;
    }

    protected int calculateAdditionIncrease(int original, int increase) {
        int num = original;
        for (int i = 1; i < level; i++) {
            num += increase;
        }
        return num;
    }

    private Attack[] getTheseAttacks() {
        return attacks;
    }

    public Attack[] getAttacks() {
        return getTheseAttacks();
    }

    private void setAttacks(Attack[] attacks) {
        this.attacks = attacks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public int getFullHealth() {
        return fullHealth;
    }

    public void setFullHealth(int fullHealth) {
        this.fullHealth = fullHealth;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getBaseXpToLevel() {
        return baseXpToLevel;
    }

    public void setBaseXpToLevel(int xp) {
        this.baseXpToLevel = xp;
        this.xpToLevel = calculateXpToLevel();
    }

    public double getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(double attack) {
        this.baseAttack = attack;
        this.attack = calculateAttack();
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    public void setBaseDefense(int defense) {
        this.baseDefense = defense;
        this.defense = calculateDefense();
    }

    public int getBaseSpeed() {
        return baseSpeed;
    }

    public void setBaseSpeed(int speed) {
        this.baseDefense = speed;
        this.speed = calculateSpeed();
    }

    public double getBaseAccuracy() {
        return baseAccuracy;
    }

    public void setBaseAccuracy(double accuracy) {
        this.baseAccuracy = accuracy;
        this.accuracy = calculateAccuracy();
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public void setBaseHealth(int health) {
        this.baseHealth = health;
        this.health = calculateHealth();
    }

    public int getLevel() {
        return level;
    }

    public void addEvolution(Evolution evolution) {
        evolutions.add(evolution);
    }

    private ArrayList<Evolution> getTheseEvolutions() {
        return evolutions;
    }

    public ArrayList<Evolution> getEvolutions() {
        return getTheseEvolutions();
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    private Type getThisType() {
        return type;
    }

    public Type getType() {
        return getThisType();
    }

    public Attack getRandomAttack() {
        int num = rand.nextInt(attacks.length);
        return attacks[num];
    }

    /**
     * prints out all the important information for the trainer.
     */
    public void print() {
        System.out.println("    " + name);
        System.out.println("        Level: " + level);
        System.out.println("        Experience: " + experience);
        System.out.println("        Health: " + health);
        System.out.println("        Attack: " + attack);
        System.out.println("        Defense: " + defense);
        System.out.println("        Speed: " + speed);
        System.out.println("        Accuracy: " + accuracy);
        System.out.println("        Attacks:");
        for (Attack attack : attacks) {
            System.out.println("            " + attack.getName());
        }

    }
}
