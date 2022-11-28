package main.java.game;

import main.java.cycle.Cycle;
import main.java.cycle.Observer;

public interface Subject {
    public void register(Observer newObserver);

    public void unregister(Observer deletedObserver);

    public void notifyObserver();

    void updateCycle(Cycle cycle);

    public void updateDifficulty(double trainerSkill, int camLevel);
}
