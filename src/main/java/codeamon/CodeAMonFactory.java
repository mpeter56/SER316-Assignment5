package main.java.codeamon;

import java.util.Random;

import main.java.attack.Attack;
import main.java.attack.AttackFactory;
import main.java.type.Type;
import main.java.type.TypeFactory;

public class CodeAMonFactory {
    Random rand;

    public CodeAMonFactory() {
        rand = new Random();
    }

    /**
     * makes a random codeamon.
     * @param level the desired level of the codeamon.
     * @param trainerId the id of the trainer who will own this codeamon.
     * @return
     */
    public CodeAMon makeCaM(int level, int trainerId) {
        Type type = (new TypeFactory()).getRandomType();
        Attack[] attacks;
        if (level >= 15) {
            attacks = new Attack[4];
        } else if (level >= 10) {
            attacks = new Attack[3];
        } else if (level >= 5) {
            attacks = new Attack[2];
        } else {
            attacks = new Attack[1];
        }
        AttackFactory attackFactory = new AttackFactory();
        for (int i = 0; i < attacks.length; i++) {
            attacks[i] = attackFactory.getRandomAttack();
        }

        int idx = -1;
        for (int i = 16; i < level; i = i + 5) {
            for (int j = 0; j < attacks.length; j++) {
                if (!attacks[j].getType().equals(type)) {
                    idx = j;
                }
            }
            if (idx != -1) {
                attacks[idx] = attackFactory.getRandomAttack();
            }
        }
        CodeAMon cam;
        double num = rand.nextDouble();
        if (num <= 0.2) {
            cam = new Bird(type, attacks, level, trainerId);
        } else if (num <= 0.4) {
            cam = new Bunny(type, attacks, level, trainerId);
        } else if (num <= 0.6) {
            cam = new Cat(type, attacks, level, trainerId);
        } else if (num <= 0.8) {
            cam = new Dog(type, attacks, level, trainerId);
        } else {
            cam = new Lizard(type, attacks, level, trainerId);
        }
        return cam;
    }
}
