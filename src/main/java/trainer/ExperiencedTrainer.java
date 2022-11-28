package main.java.trainer;

import main.java.actions.Item;
import main.java.codeamon.CodeAMon;
import main.java.codeamon.CodeAMonFactory;
import main.java.game.GameMediator;
import main.java.game.Mediator;

public class ExperiencedTrainer extends Trainer {
    /**
     * constructor for a experienced trainer.
     * @param name of the trainer
     * @param mediator the game mediator
     * @param trainerId the id of the trainer
     */
    public ExperiencedTrainer(String name, Mediator mediator, int trainerId) {
        this.trainerId = trainerId;
        this.name = name;
        this.level = 15;
        this.experience = 0;
        this.xpToLevel = 1111;
        this.numOfCaM = 4;
        this.cam = new CodeAMon[numOfCaM];
        this.items = new Item[5];
        setMediator(mediator);
        this.money = 400;

        for (int i = 0; i < numOfCaM; i++) {
            cam[i] = (new CodeAMonFactory()).makeCaM(9, trainerId);
        }
    }
}
