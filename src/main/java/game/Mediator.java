package main.java.game;

import java.util.ArrayList;

import main.java.actions.Item;
import main.java.codeamon.CodeAMon;
import main.java.trainer.Trainer;

public interface Mediator {

    boolean buy(String itemName, int trainerId);

    public void sell(Item item);

    public boolean rest(int trainerId);

    public void restTrainer(Trainer trainer);

    void bedAvailable(boolean b);

    boolean trainerBattle(int trainerId);

    void cancelTrainerBattle(int trainerId);

    void addWildCam(ArrayList<CodeAMon> wildCam);

    void removeWildCam();

    void explore(int trainerId);

    void wait12Hour();

    boolean canFight(int trainerId);

    boolean gameWon(int trainerId);

    void addTrainer(Trainer main);

    void removeTrainer(int trainerId);

}
