package main.java.trainer;

import java.util.Random;

import main.java.game.Mediator;

public class TrainerFactory {
    Names names;
    Random rand;

    public TrainerFactory() {
        rand = new Random();
        names = new Names();
    }

    /**
     * gets a trainer corresponding to the given skill level.
     * @param skill the skill level of the trainer.
     * @param mediator the game mediator.
     * @param trainerId the id of the trainer.
     * @return the constructed trainer.
     */
    public Trainer makeTrainer(double skill, Mediator mediator, int trainerId) {
        Trainer trainer;

        String name = names.getName(rand.nextInt(50));
        if (skill < 0.167) {
            trainer = new NewTrainer(name, mediator, trainerId);
        } else if (skill >= 0.167 && skill < 0.333) {
            trainer = new NoviceTrainer(name, mediator, trainerId);
        } else if (skill >= 0.333 && skill < 0.5) {
            trainer = new IntermediateTrainer(name, mediator, trainerId);
        } else if (skill >= 0.5 && skill < 0.667) {
            trainer = new ExperiencedTrainer(name, mediator, trainerId);
        } else if (skill >= 0.667 && skill < 0.833) {
            trainer = new ExpertTrainer(name, mediator, trainerId);
        } else {
            trainer = new MasterTrainer(name, mediator, trainerId);
        }
        return trainer;
    }
}
