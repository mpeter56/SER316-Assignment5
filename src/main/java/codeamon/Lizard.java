package main.java.codeamon;

import main.java.attack.Attack;
import main.java.type.Type;

public class Lizard extends CodeAMon {

    /**
     * Constructor for lizard.
     * @param type the type of the codeamon.
     * @param attacks the attacks of the codeamon
     * @param level the level of the codeamon
     * @param trainerId the trainer id of the trainer this codeamon belongs to
     */
    public Lizard(Type type, Attack[] attacks, int level, int trainerId) {
        animal = "Lizard";
        baseAttack = 1;
        baseDefense = 12;
        baseSpeed = 8;
        baseAccuracy = 1;
        baseXpToLevel = 10;
        initialize(type, attacks, level, trainerId);
    }
}
