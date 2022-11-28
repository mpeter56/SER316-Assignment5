package main.java.trainer;

import main.java.actions.Item;
import main.java.codeamon.CodeAMon;
import main.java.game.Mediator;

public abstract class Trainer {
    protected String name;
    protected int trainerId;
    protected int level;
    protected int experience;
    protected int xpToLevel;
    protected int numOfCaM;
    protected CodeAMon[] cam;
    protected Item[] items;
    protected Mediator mediator;
    protected int money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean buy(String itemName) {
        return mediator.buy(itemName, getTrainerId());
    }

    public boolean rest() {
        return mediator.rest(trainerId);
    }

    public void explore() {
        mediator.explore(trainerId);
    }

    public boolean canFight() {
        return mediator.canFight(trainerId);
    }

    public void wait12Hour() {
        mediator.wait12Hour();
    }

    /**
     * give a health potion to a codeamon.
     * @param camNum the number of codeamon
     */
    public void giveHealthPotion(int camNum) {
        int idx = -1;

        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                if (items[i].getName().compareTo("HealthPotion") == 0 && idx == -1) {
                    idx = i;
                    break;
                }
            }
        }

        if (idx != -1) {
            int health = cam[camNum].getHealth() + items[idx].getHealthRestored();
            items[idx] = null;
            if (health > cam[camNum].getFullHealth()) {
                health = cam[camNum].getFullHealth();
            }
            cam[camNum].setHealth(health);
            System.out.println(name + " gave " + cam[camNum].getName() 
                    + " a health potion. Their health is now at ");
        }
    }

    // fulfills requirement 2
    // trainers can get new codeamon slots up to 6, they then can catch a codeamon.
    /**
     * level up the trainer.
     */
    public void levelUp() {
        if (experience >= xpToLevel) {
            experience = 0;
            xpToLevel = (int) (xpToLevel * 1.1);
            level++;
            if (level % 3 == 0) {
                Item[] newItems = new Item[items.length + 1];
                for (int i = 0; i < items.length; i++) {
                    newItems[i] = items[i];
                }
                items = newItems;
            }

            if (level % 5 == 0 && level < 26) {
                CodeAMon[] newCam = new CodeAMon[cam.length + 1];
                for (int i = 0; i < cam.length; i++) {
                    newCam[i] = cam[i];
                }
                cam = newCam;
            }
        }
    }

    public int getTrainerId() {
        return trainerId;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * checks if the trainer has a free item slot.
     * @return true if the trainer has a free item slot.
     */
    public boolean hasFreeItemSlot() {
        boolean hasFreeItemSlot = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                hasFreeItemSlot = true;
            }
        }
        return hasFreeItemSlot;
    }

    /**
     * add an item to the item array.
     * @param item the item to be added.
     */
    public void addItem(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                break;
            }
        }

    }

    private CodeAMon[] getTheseCam() {
        return cam;
    }

    public CodeAMon[] getCam() {
        return getTheseCam();
    }

    private void setThisCam(CodeAMon[] cam) {
        this.cam = cam;
    }

    public void setCam(CodeAMon[] cam) {
        setThisCam(cam);
    }

    public void trainerBattle() {
        mediator.trainerBattle(trainerId);

    }

    public void cancelTrainerBattle() {
        mediator.cancelTrainerBattle(trainerId);
    }

    public int getExperience() {
        return experience;
    }

    public int getLevel() {
        return level;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getNumOfCam() {
        return numOfCaM;
    }

    public void setNumOfCam(int numOfCaM) {
        this.numOfCaM = numOfCaM;
    }

    /**
     * sets the mediator for the game mediator.
     * @param mediator the mediator to be set.
     */
    protected void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * prints out all the information for the trainer.
     */
    public void print() {
        System.out.println("---------------------------------------------");
        System.out.println("Trainer " + name + ":");
        System.out.println("    level: " + level);
        System.out.println("    Experience: " + experience);
        System.out.println("    XP to level: " + xpToLevel);
        System.out.println("    Money: " + money);
        System.out.println("    CodeAMon: ");
        for (CodeAMon thisCam : cam) {
            if (thisCam != null) {
                thisCam.print();
            }
        }
        System.out.println("Items: ");
        for (Item item : items) {
            if (item != null) {
                System.out.println("    " + item.getName() + ":");
            }
        }
        System.out.println("---------------------------------------------");
    }

}
