package main.java.game;

import java.util.ArrayList;
import java.util.Random;

import main.java.actions.Bed;
import main.java.actions.Item;
import main.java.actions.Shop;
import main.java.actions.TrainerBattle;
import main.java.actions.WildBattle;
import main.java.actions.World;
import main.java.codeamon.CodeAMon;
import main.java.cycle.Cycle;
import main.java.cycle.Observer;
import main.java.trainer.Trainer;

public class GameMediator implements Mediator, Subject {
    private Shop shop;
    private Bed bed;
    private World world;
    private boolean bedAvailible;
    private ArrayList<Item> itemsForSale;
    private ArrayList<String> itemsToPurchase;
    private ArrayList<Trainer> trainers;
    private ArrayList<Trainer> trainersReadyToBattle;
    private ArrayList<CodeAMon> wildCam;
    private ArrayList<Observer> observers;
    private Cycle cycle;
    private int time;
    private Random rand;

    // fulfills requirement 12
    /**
     * constructor for the game mediator.
     */
    public GameMediator() {
        rand = new Random();
        shop = new Shop(this);
        bed = new Bed(this);
        world = new World(this);
        itemsForSale = new ArrayList<Item>();
        itemsToPurchase = new ArrayList<String>();
        trainers = new ArrayList<Trainer>();
        trainersReadyToBattle = new ArrayList<Trainer>();
        wildCam = new ArrayList<CodeAMon>();
        observers = new ArrayList<Observer>();
    }

    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    public void unregister(Observer deleteObserver) {
        int observerIdx = observers.indexOf(deleteObserver);
        observers.remove(observerIdx);
    }

    /**
     * notifies the observers of the change in time and main character traner level.
     */
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(time, getTrainer(0).getLevel());
        }
    }

    @Override
    public boolean buy(String itemName, int trainerId) {
        boolean itemBought = false;
        for (Item item : itemsForSale) {
            if (item.getName().compareTo(itemName) == 0) {
                if (checkPurchase(item, trainerId)) {
                    purchaseItem(item, trainerId);
                    itemBought = true;
                }

                if (itemBought) {
                    break;
                }
            }
        }
        return itemBought;
    }

    private void purchaseItem(Item item, int trainerId) {
        Trainer trainer = getTrainer(trainerId);
        if (trainer == null) {
            return;
        } else {
            trainer.setMoney(trainer.getMoney() - item.getPrice());
            trainer.addItem(item);
            itemsForSale.remove(item);
        }
    }

    private boolean checkPurchase(Item item, int trainerId) {
        Trainer trainer = getTrainer(trainerId);
        if (trainer == null) {
            return false;
        } else {
            if (trainer.getMoney() >= item.getPrice()) {
                if (trainer.hasFreeItemSlot()) {
                    System.out.println(trainer.getName() + " bought a " + item.getName());
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    @Override
    public void sell(Item item) {
        boolean itemSold = false;

        for (String itemToPurchase : itemsToPurchase) {
            if (itemToPurchase.compareTo(item.getName()) == 0) {
                itemsToPurchase.remove(itemToPurchase);
                itemSold = true;
            }

            if (itemSold) {
                break;
            }
        }

        if (!itemSold) {
            itemsForSale.add(item);
        }

    }

    private Trainer getTrainer(int trainerId) {
        for (Trainer trainer : trainers) {
            if (trainer.getTrainerId() == trainerId) {
                return trainer;
            }
        }

        return null;
    }

    private void setTrainer(int trainerId, Trainer trainer) {
        for (int i = 0; i < trainers.size(); i++) {
            if (trainers.get(i).getTrainerId() == trainerId) {
                trainers.remove(i);
                trainers.add(trainer);
            }
        }
    }

    @Override
    public void restTrainer(Trainer trainer) {
        setTrainer(trainer.getTrainerId(), bed.restTrainer(trainer));
        System.out.println("Resting...");
        System.out.println("Good morning");
        trainer.print();

    }

    /**
     * this is a method to allow a trainer to wait 12 hours.
     */
    public void wait12Hour() {
        System.out.println(getTrainer(0).getName() 
                + " can't do anything for now, so they will wait 12 hours...");
        time = time + 12;
        notifyObserver();
    }

    // i made the call to let trainers explore at night but its harder at night
    @Override
    public void explore(int trainerId) {
        Trainer trainer = getTrainer(trainerId);
        System.out.println(trainer.getName() + " set out to explore the world.");
        if (trainersReadyToBattle.size() > 0 && wildCam.size() > 0) {
            if (rand.nextBoolean()) {
                trainerBattle(trainerId);
            } else {
                wildBattle(trainer);
            }
        } else if (trainersReadyToBattle.size() > 0) {
            trainerBattle(trainerId);
        } else if (wildCam.size() > 0) {
            wildBattle(trainer);
        } else {
            trainer.setMoney(trainer.getMoney() + 10);
            setTrainer(trainerId, trainer);
            System.out.println(trainer.getName() + " found 10 gold in a bush!");

        }
        time = time + 12;
        notifyObserver();
    }

    @Override
    public void bedAvailable(boolean bedAvailible) {
        this.bedAvailible = bedAvailible;
    }

    @Override
    public boolean rest(int trainerId) {
        if (bedAvailible) {
            restTrainer(getTrainer(trainerId));
            time = time + 12;
            notifyObserver();
            System.out.println("Time to get some rest!");
            return true;
        } else {
            return false;
        }

    }

    // fulfills requirement 12
    @Override
    public boolean trainerBattle(int trainerId) {
        if (trainerId >= 0) {
            if (trainersReadyToBattle.size() > 0) {
                Trainer opponent = trainersReadyToBattle.remove(0);
                System.out.println(opponent.getName() + ": Hey you! lets battle!");
                TrainerBattle battle = new TrainerBattle(cycle.getWeather().getName());
                Trainer newTrainer = battle.trainerBattle(getTrainer(trainerId), opponent);
                newTrainer.levelUp();
                setTrainer(trainerId, newTrainer);
                return true;
            }
        } else {
            trainersReadyToBattle.add(getTrainer(trainerId));
        }
        return false;
    }

    @Override
    public void cancelTrainerBattle(int trainerId) {
        for (Trainer trainer : trainersReadyToBattle) {
            if (trainer.getTrainerId() == trainerId) {
                trainersReadyToBattle.remove(trainer);
                return;
            }
        }

    }

    /**
     * a method for a trainer to do a battle with a wild codeamon.
     * @param trainer the main trainer
     */
    public void wildBattle(Trainer trainer) {
        WildBattle battle = new WildBattle(cycle.getWeather().getName());

        Trainer newTrainer = battle.wildBattle(trainer, wildCam.get(wildCam.size() - 1));
        wildCam.remove(wildCam.size() - 1);
        newTrainer.levelUp();
        setTrainer(trainer.getTrainerId(), newTrainer);
    }

    @Override
    public void addWildCam(ArrayList<CodeAMon> wildCam) {
        for (CodeAMon cam : wildCam) {
            this.wildCam.add(cam);
        }
    }

    @Override
    public void removeWildCam() {
        wildCam.clear();
        ;
    }

    @Override
    public void updateCycle(Cycle newCycle) {
        bed.updateCycle(newCycle);
        shop.updateCycle(newCycle);
        world.updateCycle(newCycle);
        setCycle(newCycle);

    }

    private void setCycle(Cycle newCycle) {
        cycle = newCycle;
    }

    @Override
    public boolean canFight(int trainerId) {
        boolean canFight = false;
        Trainer trainer = getTrainer(trainerId);
        for (CodeAMon cam : trainer.getCam()) {
            if (cam != null) {
                if (cam.getHealth() > 0) {
                    canFight = true;
                }
            }
        }
        return canFight;
    }

    @Override
    public void updateDifficulty(double trainerSkill, int camLevel) {
        world.updateDifficulty(trainerSkill, camLevel);
    }

    @Override
    public boolean gameWon(int trainerId) {
        Trainer trainer = getTrainer(trainerId);
        if (trainer.getLevel() >= 25) {
            System.out.println("Congrats! " + trainer.getName() + " is level 25! You won!");
            return true;
        } else {

            return false;
        }
    }

    @Override
    public void addTrainer(Trainer newTrainer) {
        trainers.add(newTrainer);
    }

    @Override
    public void removeTrainer(int trainerId) {
        trainers.remove(getTrainer(trainerId));
    }

    /**
     * a method to move an op codeamon down the list so that weaker cam can level.
     * @param trainerId the id of the trainer to reorganize.
     */
    public void firstTooStrong(int trainerId) {
        Trainer trainer = getTrainer(trainerId);
        CodeAMon[] cam = trainer.getCam();
        CodeAMon first = cam[0];
        if (cam.length > 1) {
            for (int i = 1; i < cam.length; i++) {
                if (cam[i] != null) {
                    if (cam[i].getLevel() + 5 > first.getLevel()) {
                        cam[0] = cam[i];
                        cam[i] = first;
                    }
                }
            }
        }
        trainer.setCam(cam);
        setTrainer(trainerId, trainer);
    }

    public int getItemsForSale() {
        return itemsForSale.size();
    }

}
