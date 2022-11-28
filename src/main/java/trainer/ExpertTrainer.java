package main.java.trainer;

import main.java.actions.Item;
import main.java.codeamon.CodeAMon;
import main.java.codeamon.CodeAMonFactory;
import main.java.game.GameMediator;
import main.java.game.Mediator;

public class ExpertTrainer extends Trainer {
    /**
     * constructor for a expert trainer.
     * @param name of the trainer
     * @param mediator the game mediator
     * @param trainerId the id of the trainer
     */
    public ExpertTrainer(String name, Mediator mediator, int trainerId) {
        this.trainerId = trainerId;
        this.name = name;
        this.level = 20;
        this.experience = 0;
        this.xpToLevel = 5976;
        this.numOfCaM = 4;
        this.cam = new CodeAMon[numOfCaM];
        this.items = new Item[6];
        setMediator(mediator);
        this.money = 500;

        for (int i = 0; i < numOfCaM; i++) {
            cam[i] = (new CodeAMonFactory()).makeCaM(12, trainerId);
        }
    }
}
