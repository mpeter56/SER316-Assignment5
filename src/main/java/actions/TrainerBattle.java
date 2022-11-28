package main.java.actions;

// fulfills requirement 8
// fulfills requirement 13
import main.java.attack.Attack;
import main.java.codeamon.CodeAMon;
import main.java.game.GameMediator;
import main.java.game.Mediator;
import main.java.trainer.Trainer;

public class TrainerBattle {
    String weather;

    public TrainerBattle(String weather) {
        this.weather = weather;
    }

    /**
     * this method does a battle between trainer and opponent.
     * @param trainer the main character.
     * @param opponent the opponent trainer.
     * @return the main character with updated cam, xp, and money.
     */
    public Trainer trainerBattle(Trainer trainer, Trainer opponent) {
        System.out.println("Battle:");
        System.out.println("---------------------------------------------");
        CamBattle camBattle = new CamBattle();
        CodeAMon[] tcam = trainer.getCam();
        CodeAMon[] ocam = opponent.getCam();
        int tcamleft = tcam.length;
        int ocamleft = ocam.length;
        int tcamidx = 0;
        int ocamidx = 0;

        System.out.println(trainer.getName() + " has " + tcamleft + " CodeAMon");
        System.out.println(opponent.getName() + " has " + ocamleft + " CodeAMon");
        while (tcamleft > 0 && ocamleft > 0) {
            if (tcam[tcamidx] == null) {
                tcamleft--;
                tcamidx++;
            } else {
                System.out.println(trainer.getName() + ": " + tcam[tcamidx].getName() 
                        + ", I choose you!");
                System.out.println(opponent.getName() + ": " + ocam[ocamidx].getName() 
                        + ", I choose you!");
                CodeAMon winner = camBattle.battle(tcam[tcamidx], ocam[ocamidx], weather);

                if (winner.getTrainerId() == trainer.getTrainerId()) {
                    System.out.println(trainer.getName() + ": Great job " + winner.getName());
                    if (winner.getLevel() > 15) {
                        winner.levelUp(getAutomatedAttackReplacement(winner));
                    } else {
                        winner.levelUpBelow16();
                    }
                    tcam[tcamidx] = winner;
                    ocamidx++;
                    ocamleft--;
                } else {
                    ocam[ocamidx] = winner;
                    tcamidx++;
                    tcamleft--;
                }
            }
        }

        trainer.setCam(tcam);
        System.out.println("---------------------------------------------");
        if (tcamleft > 0) {
            trainer.setMoney(trainer.getMoney() + opponent.getMoney());
            trainer.setExperience(trainer.getExperience() + calculateExperience(trainer, opponent));
            System.out.println("Nice! " + trainer.getName() + " defeated " + opponent.getName());
            trainer.levelUp();
            trainer.print();
            return trainer;
        } else {
            System.out.println(trainer.getName() + " was defeated by " + opponent.getName());
            trainer.print();
            return trainer;
        }
    }

    private int calculateExperience(Trainer trainer, Trainer opponent) {
        int basexp = 50;
        if (trainer.getLevel() == opponent.getLevel()) {
            return basexp;
        } else {
            int levelDifference = trainer.getLevel() - opponent.getLevel();
            if (levelDifference > 0) {
                return basexp * levelDifference;
            } else {
                return (int) (basexp + levelDifference);
            }
        }
    }

    private int getAutomatedAttackReplacement(CodeAMon cam) {
        Attack[] attacks = cam.getAttacks();
        for (int i = 0; i < attacks.length; i++) {
            if (attacks[i].getType().toString().compareTo(cam.getType().toString()) != 0) {
                return i;
            }
        }
        return -2;
    }

}
