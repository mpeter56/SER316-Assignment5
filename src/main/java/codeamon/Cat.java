package main.java.codeamon;

import main.java.attack.Attack;
import main.java.type.Type;

public class Cat extends CodeAMon {

    /**
     * Constructor for cat.
     * @param type the type of the codeamon.
     * @param attacks the attacks of the codeamon
     * @param level the level of the codeamon
     * @param trainerId the trainer id of the trainer this codeamon belongs to
     */
    public Cat(Type type, Attack[] attacks, int level, int trainerId) {
        animal = "Cat";
        baseAttack = 1;
        baseDefense = 10;
        baseSpeed = 10;
        baseAccuracy = 1.2;
        baseXpToLevel = 12;
        initialize(type, attacks, level, trainerId);
    }
}
