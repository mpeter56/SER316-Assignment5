package main.java.game;

import main.java.cycle.Time;
import main.java.trainer.Trainer;
import main.java.trainer.TrainerFactory;

public class Game {
    Trainer main;
    TrainerFactory factory;
    GameMediator gameMediator;
    Time time;
    Difficulty difficulty;

    /**
     * constructor for the game.
     */
    public Game() {
        System.out.println("Welcome to CodeAMon");
        gameMediator = new GameMediator();
        factory = new TrainerFactory();
        main = factory.makeTrainer(0, gameMediator, 0);

        System.out.println("New trainer created:");
        main.print();

        gameMediator.addTrainer(main);
        time = new Time(gameMediator);
        difficulty = new Difficulty(gameMediator);
        gameMediator.register(time);
        gameMediator.register(difficulty);
        gameMediator.notifyObserver();
    }

    /**
     * plays the game completely automated, ends when trainer reaches level 25.
     * @return true if the trainer reached level 25.
     */
    public boolean playAutomated() {
        while (!gameMediator.gameWon(main.getTrainerId())) {
            if (main.canFight()) {
                main.explore();
                gameMediator.firstTooStrong(0);
            } else {
                System.out.println(
                        main.getName() 
                        + " has no codeAMon left and must either rest " + "or use a health potion");
                if (!main.rest()) {
                    if (main.hasFreeItemSlot()) {
                        if (main.buy("HealthPotion")) {
                            main.giveHealthPotion(0);
                        }
                    }

                    main.wait12Hour();

                }
            }
        }
        if (gameMediator.gameWon(main.getTrainerId())) {
            return true;
        } else {
            return false;
        }
    }
}
