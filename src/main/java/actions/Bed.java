package main.java.actions;

// fulfills requirement 9
import java.util.ArrayList;

import main.java.codeamon.CodeAMon;
import main.java.cycle.Cycle;
import main.java.evolution.Evolution;
import main.java.evolution.EvolutionFactory;
import main.java.game.Mediator;
import main.java.trainer.Trainer;

public class Bed {
    Mediator mediator;
    Cycle cycle;

    public Bed(Mediator mediator) {
        setMediator(mediator);
    }

    private void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * tells the mediator if the bed is availible.
     */
    public void bedAvailable() {
        if (cycle.isNight()) {
            mediator.bedAvailable(true);
        } else {
            mediator.bedAvailable(false);
        }
    }

    /**
     * complete the rest action for the trainer.
     * @param trainer the trainer to be rested
     * @return the rested trainer
     */
    public Trainer restTrainer(Trainer trainer) {
        Trainer newTrainer = trainer;
        newTrainer = evolve(newTrainer);
        newTrainer = heal(newTrainer);
        return newTrainer;
    }


    private Trainer evolve(Trainer trainer) {
        CodeAMon[] cam = trainer.getCam();
        for (int i = 0; i < cam.length; i++) {
            if (cam[i] != null) {
                int level = cam[i].getLevel();
                ArrayList<Evolution> evolutions = cam[i].getEvolutions();
                if (evolutions.size() < (int) (level / 10)) {
                    EvolutionFactory factory = new EvolutionFactory();
                    Evolution evolution = factory.getRandomEvolution();
                    evolution.evolve(cam[i]);
                    cam[i].addEvolution(evolution);
                    String oldName = cam[i].getName();
                    cam[i].setName(evolution.getName() + " " + cam[i].getName());
                    System.out.println(oldName + " evolved into a " + cam[i].getName());
                }
            }
        }
        trainer.setCam(cam);
        return trainer;
    }

    private Trainer heal(Trainer trainer) {
        CodeAMon[] cam = trainer.getCam();
        for (int i = 0; i < cam.length; i++) {
            if (cam[i] != null) {
                int health = cam[i].getFullHealth();
                cam[i].setHealth(health);
            }
        }
        trainer.setCam(cam);
        return trainer;
    }

    private void setCycle(Cycle cycle) {
        this.cycle = cycle;
    }

    public void updateCycle(Cycle cycle) {
        setCycle(cycle);
        bedAvailable();
    }
}
