package main.java.codeamon;

import main.java.attack.Attack;
import main.java.type.Type;

public class Bird extends CodeAMon {

    /**
     * Constructor for bird.
     * @param type the type of the codeamon.
     * @param attacks the attacks of the codeamon
     * @param level the level of the codeamon
     * @param trainerId the trainer id of the trainer this codeamon belongs to
     */
    public Bird(Type type, Attack[] attacks, int level, int trainerId) {
        animal = "Bird";
        baseAttack = 0.8;
        baseDefense = 10;
        baseSpeed = 12;
        baseAccuracy = 1;
        baseXpToLevel = 10;
        initialize(type, attacks, level, trainerId);
    }

}
