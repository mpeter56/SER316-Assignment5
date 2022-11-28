package main.java.codeamon;

import main.java.attack.Attack;
import main.java.type.Type;

public class Dog extends CodeAMon {

    /**
     * Constructor for dog.
     * @param type the type of the codeamon.
     * @param attacks the attacks of the codeamon
     * @param level the level of the codeamon
     * @param trainerId the trainer id of the trainer this codeamon belongs to
     */
    public Dog(Type type, Attack[] attacks, int level, int trainerId) {
        animal = "Dog";
        baseAttack = 1.2;
        baseDefense = 10;
        baseSpeed = 10;
        baseAccuracy = .8;
        baseXpToLevel = 10;
        initialize(type, attacks, level, trainerId);
    }
}
