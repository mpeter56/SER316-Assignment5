package main.java.trainer;

import main.java.actions.Item;
import main.java.codeamon.CodeAMon;
import main.java.codeamon.CodeAMonFactory;
import main.java.game.GameMediator;
import main.java.game.Mediator;

public class NewTrainer extends Trainer {

    /**
     * constructor for a new trainer.
     * @param name of the trainer
     * @param mediator the game mediator
     * @param trainerId the id of the trainer
     */
    public NewTrainer(String name, Mediator mediator, int trainerId) {
        this.trainerId = trainerId;
        this.name = name;
        this.level = 1;
        this.experience = 0;
        this.xpToLevel = 38;
        this.numOfCaM = 1;
        this.cam = new CodeAMon[numOfCaM];
        this.items = new Item[1];
        setMediator(mediator);
        this.money = 10;

        for (int i = 0; i < numOfCaM; i++) {
            cam[i] = (new CodeAMonFactory()).makeCaM(1, trainerId);
        }
    }
}
