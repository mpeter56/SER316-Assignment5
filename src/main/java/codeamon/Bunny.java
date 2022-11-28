package main.java.codeamon;

import main.java.attack.Attack;
import main.java.type.Type;

public class Bunny extends CodeAMon {

    /**
     * Constructor for bunny.
     * @param type the type of the codeamon.
     * @param attacks the attacks of the codeamon
     * @param level the level of the codeamon
     * @param trainerId the trainer id of the trainer this codeamon belongs to
     */
    public Bunny(Type type, Attack[] attacks, int level, int trainerId) {
        animal = "Bunny";
        baseAttack = 1;
        baseDefense = 8;
        baseSpeed = 10;
        baseAccuracy = 1;
        baseXpToLevel = 8;
        initialize(type, attacks, level, trainerId);
    }
}
