package main.java.actions;

import java.util.ArrayList;

import main.java.codeamon.CodeAMon;
import main.java.codeamon.CodeAMonFactory;
import main.java.cycle.Cycle;
import main.java.game.Difficulty;
import main.java.game.Mediator;
import main.java.trainer.Trainer;
import main.java.trainer.TrainerFactory;

// fulfills requirement 1: A new world must start with a number of trainers, at least 2, each of them starts
//with at least one code-a-mon. You can also decide to have trainners join in time if
//you like.
public class World {
    Mediator mediator;
    ArrayList<CodeAMon> wildCam;
    ArrayList<Trainer> worldTrainers;
    Cycle cycle;
    double trainerSkill;
    int camLevel;
    int numOfTrainers = 10;
    int numOfCam = 10;

    /**
     * Constructor.
     * @param mediator for the mediator design pattern
     */
    public World(Mediator mediator) {
        setMediator(mediator);
        wildCam = new ArrayList<CodeAMon>();
        worldTrainers = new ArrayList<Trainer>();
    }

    /**
     * This method sets the mediator.
     * @param the mediator for the mediator design pattern
     */
    private void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * this sends the availible npc world trainers to the game mediator to add to the roster.
     */
    public void availibleWorldTrainers() {
        removeTrainers();
        double skillDifference;
        if (cycle.isNight()) {
            skillDifference = 0.167;
        } else {
            skillDifference = 0.0;
        }
        TrainerFactory tfactory = new TrainerFactory();
        for (int i = 1; i <= numOfTrainers; i++) {
            worldTrainers.add(tfactory.makeTrainer(trainerSkill + skillDifference, mediator, -i));
        }

        for (Trainer trainer : worldTrainers) {
            mediator.addTrainer(trainer);
            trainer.trainerBattle();
        }
    }

    /**
     * removes trainers fome the game mediator and locally.
     */
    public void removeTrainers() {
        for (Trainer trainer : worldTrainers) {
            trainer.cancelTrainerBattle();
            mediator.removeTrainer(trainer.getTrainerId());
        }
        worldTrainers.clear();

    }

    /**
     * sends the wild cam to the game mediator to add to the roster.
     */
    public void availibleWildCam() {
        removeWildCam();
        int clevel;
        if (cycle.isNight()) {
            clevel = (int) (camLevel / 4);
            clevel++;
            clevel++;
        } else {
            clevel = (int) (camLevel / 4);
            clevel++;
        }
        CodeAMonFactory cfactory = new CodeAMonFactory();
        for (int i = 0; i < numOfCam; i++) {
            wildCam.add(cfactory.makeCaM(clevel, -1));
        }
        mediator.addWildCam(wildCam);
    }

    /**
     * removes the wild cam from the roster.
     */
    public void removeWildCam() {
        mediator.removeWildCam();
    }

    private void setCycle(Cycle cycle) {
        this.cycle = cycle;
    }

    /**
     * This updates the cycle and resends new wildcam and world trainers.
     * @param cycle2 the new cycle
     */
    public void updateCycle(Cycle cycle2) {
        if (this.cycle == null) {
            setCycle(cycle2);
            availibleWildCam();
            availibleWorldTrainers();
            System.out.println("It's a " + cycle.getName());
        }
        if (this.cycle.getName().compareTo(cycle2.getName()) != 0) {
            setCycle(cycle2);
            availibleWildCam();
            availibleWorldTrainers();
            System.out.println("It's a " + cycle.getName());
        }

    }

    public void updateDifficulty(double newTrainerSkill, int newCamLevel) {
        trainerSkill = newTrainerSkill;
        camLevel = newCamLevel;
    }
}
