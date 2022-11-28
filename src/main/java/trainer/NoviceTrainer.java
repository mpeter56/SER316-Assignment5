package main.java.trainer;

import main.java.actions.Item;
import main.java.codeamon.CodeAMon;
import main.java.codeamon.CodeAMonFactory;
import main.java.game.GameMediator;
import main.java.game.Mediator;

public class NoviceTrainer extends Trainer {
    /**
     * constructor for a novic trainer.
     * @param name of the trainer
     * @param mediator the game mediator
     * @param trainerId the id of the trainer
     */
    public NoviceTrainer(String name, Mediator mediator, int trainerId) {
        this.trainerId = trainerId;
        this.name = name;
        this.level = 5;
        this.experience = 0;
        this.xpToLevel = 38;
        this.numOfCaM = 2;
        this.cam = new CodeAMon[numOfCaM];
        this.items = new Item[2];
        setMediator(mediator);
        this.money = 100;

        for (int i = 0; i < numOfCaM; i++) {
            cam[i] = (new CodeAMonFactory()).makeCaM(3, trainerId);
        }
    }
}
