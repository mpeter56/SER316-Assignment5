package main.java.trainer;

import main.java.actions.Item;
import main.java.codeamon.CodeAMon;
import main.java.codeamon.CodeAMonFactory;
import main.java.game.GameMediator;
import main.java.game.Mediator;

public class IntermediateTrainer extends Trainer {
    /**
     * constructor for a intermediate trainer.
     * @param name of the trainer
     * @param mediator the game mediator
     * @param trainerId the id of the trainer
     */
    public IntermediateTrainer(String name, Mediator mediator, int trainerId) {
        this.trainerId = trainerId;
        this.name = name;
        this.level = 10;
        this.experience = 0;
        this.xpToLevel = 206;
        this.numOfCaM = 3;
        this.cam = new CodeAMon[numOfCaM];
        this.items = new Item[3];
        setMediator(mediator);
        this.money = 200;

        for (int i = 0; i < numOfCaM; i++) {
            cam[i] = (new CodeAMonFactory()).makeCaM(6, trainerId);
        }
    }
}
