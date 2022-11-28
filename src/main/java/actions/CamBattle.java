package main.java.actions;

import java.util.Random;

import main.java.attack.Attack;
import main.java.codeamon.CodeAMon;

// fulfills requirement 3 : Code-a-mons will compete 1v1 with another trainers code-a-mons.
// fulfills requirement 11
public class CamBattle {
    private CodeAMon cam1;
    private CodeAMon cam2;
    String weather;
    boolean cam1Strong;
    boolean cam2Strong;
    Random rand;

    /**
     * a battl between two cam.
     * @param tcam the trainer's cam.
     * @param ocam the opponent cam
     * @param weather the current weather as a string
     * @return the cam that won the battle.
     */
    public CodeAMon battle(CodeAMon tcam, CodeAMon ocam, String weather) {
        setCam1(tcam);
        setCam2(ocam);
        this.weather = weather;
        rand = new Random();
        CodeAMon winner;
        if (cam1.getType().getStrongAgainst().compareTo(cam2.getType().getName()) == 0) {
            cam1Strong = true;
        } else {
            cam1Strong = false;
        }

        if (cam2.getType().getStrongAgainst().compareTo(cam1.getType().getName()) == 0) {
            cam2Strong = true;
        } else {
            cam2Strong = false;
        }

        while (cam1.getHealth() > 0 && cam2.getHealth() > 0) {
            boolean cam1First;
            if (cam1.getSpeed() >= cam2.getSpeed()) {
                cam1First = true;
            } else {
                cam1First = false;
            }

            if (cam1First) {
                attack(true);
                attack(false);
            } else {
                attack(false);
                attack(true);
            }
        }

        if (cam1.getHealth() > 0) {
            winner = getCam1();
            winner.setExperience(cam1.getExperience() + calculateExperience());
            return winner;
        } else {
            winner = getCam2();
            return winner;
        }
    }

    private CodeAMon getCam2() {
        return cam2;
    }

    private int calculateExperience() {
        int basexp = 10;
        if (cam1.getLevel() == cam2.getLevel()) {
            return basexp;
        } else {
            int levelDifference = cam2.getLevel() - cam1.getLevel();
            if (levelDifference > 0) {
                return basexp * levelDifference;
            } else {
                return (int) (basexp - levelDifference);
            }
        }
    }

    private void attack(boolean cam1Attacker) {
        int damage;
        if (cam1Attacker) {
            damage = dealDamage(cam1, cam1Strong);
            takeDamage(cam2, damage, false);
        } else {
            damage = dealDamage(cam2, cam2Strong);
            takeDamage(cam1, damage, true);
        }

    }

    private void takeDamage(CodeAMon cam, int damage, boolean isCam1) {
        int damageTaken = damage - cam.getDefense();
        if (damageTaken < 0) {
            damageTaken = 0;
        }

        if (isCam1) {
            if (damage > 0) {
                System.out.println(cam2.getName() + " hit " + cam1.getName() + " for " + damage 
                        + " damage!");
            } else {
                System.out.println(cam2.getName() + " missed!");
            }
            cam1.setHealth(cam1.getHealth() - damageTaken);
            if (cam1.getHealth() < 0) {
                cam1.setHealth(0);
            }
        } else {
            if (damage > 0) {
                System.out.println(cam1.getName() + " hit " + cam2.getName() + " for " + damage 
                        + " damage!");
            } else {
                System.out.println(cam1.getName() + " missed!");
            }
            cam2.setHealth(cam2.getHealth() - damageTaken);
            if (cam2.getHealth() < 0) {
                cam2.setHealth(0);
            }
        }
    }

    private int dealDamage(CodeAMon cam, boolean strongAgainst) {
        Attack thisAttack = cam.getRandomAttack();
        System.out.println(cam.getName() + " used " + thisAttack.getName());
        if (!isMiss(cam, thisAttack)) {
            double attackStat = cam.getAttack();
            int attackDamage = thisAttack.getDamage();
            int damage = (int) (attackDamage * attackStat);
            if (cam.getType().getStrongWhen().compareTo(weather) == 0) {
                damage = damage * 2;
            }

            if (strongAgainst) {
                damage = damage * 2;
            }

            if (thisAttack.getType().getName().compareTo(cam.getType().getName()) == 0) {
                damage = damage * 2;
            }

            if (isCrit(thisAttack)) {
                damage = damage * 2;
                return damage;
            } else {
                return damage;
            }
        } else {
            return 0;
        }
    }

    private boolean isCrit(Attack attack) {
        if (rand.nextDouble() <= attack.getCritChance()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isMiss(CodeAMon cam, Attack attack) {
        double accuracy = cam.getAccuracy();
        double missChance = attack.getMissChance();
        double finalMissChance = missChance / accuracy;
        if (rand.nextDouble() <= finalMissChance) {
            return true;
        } else {
            return false;
        }
    }

    private CodeAMon getCam1() {
        return cam1;
    }

    private void setCam1(CodeAMon cam) {
        this.cam1 = cam;
    }

    private void setCam2(CodeAMon cam) {
        this.cam2 = cam;
    }

}
