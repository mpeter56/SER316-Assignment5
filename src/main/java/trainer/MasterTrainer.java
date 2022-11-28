package main.java.trainer;

import main.java.actions.Item;
import main.java.codeamon.CodeAMon;
import main.java.codeamon.CodeAMonFactory;
import main.java.game.GameMediator;
import main.java.game.Mediator;

public class MasterTrainer extends Trainer {
    /**
     * constructor for a master trainer.
     * @param name of the trainer
     * @param mediator the game mediator
     * @param trainerId the id of the trainer
     */
    public MasterTrainer(String name, Mediator mediator, int trainerId) {
        this.trainerId = trainerId;
        this.name = name;
        this.level = 25;
        this.experience = 0;
        this.xpToLevel = 32141;
        this.numOfCaM = 6;
        this.cam = new CodeAMon[numOfCaM];
        this.items = new Item[8];
        setMediator(mediator);
        this.money = 700;

        for (int i = 0; i < numOfCaM; i++) {
            cam[i] = (new CodeAMonFactory()).makeCaM(15, trainerId);
        }
    }
}
