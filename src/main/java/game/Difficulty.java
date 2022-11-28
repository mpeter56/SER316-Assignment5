package main.java.game;

import main.java.cycle.Day;
import main.java.cycle.Observer;

public class Difficulty implements Observer {
    private Subject gameMediator;

    private int level;
    private double trainerSkill;
    private static final int typesOfTrainers = 6;
    private static final int trainerLevelDifference = 5;

    public Difficulty(Subject gameMediator) {
        this.gameMediator = gameMediator;
        updateDifficulty();
    }

    @Override
    public void update(int newTime, int level) {
        this.level = level;
        updateDifficulty();
    }

    private void updateDifficulty() {
        trainerSkill = (1 / typesOfTrainers) * (level / trainerLevelDifference);
        gameMediator.updateDifficulty(trainerSkill, level);
    }
}
