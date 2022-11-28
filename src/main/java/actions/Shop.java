package main.java.actions;

import java.util.ArrayList;

import main.java.cycle.Cycle;
import main.java.game.Mediator;

public class Shop {
    private ArrayList<Item> items;
    private int numOfHealthPotions = 5;
    private Mediator mediator;
    private Cycle cycle;

    /**
     * constructor for the shop.
     * @param newMediator the game mediator
     */
    public Shop(Mediator newMediator) {
        this.items = new ArrayList<Item>();
        stockHealthPotion(numOfHealthPotions);
        setMediator(newMediator);
    }

    private void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * tell the game mediator to sell these items.
     */
    public void sell() {
        for (int i = 0; i < items.size(); i++) {
            mediator.sell(items.get(i));
        }
    }

    /**
     * add health potions to the inventory.
     * @param num the number of health potions to add.
     */
    public void stockHealthPotion(int num) {
        for (int i = 0; i < num; i++) {
            items.add(new HealthPotion());
        }
    }

    private void setCycle(Cycle cycle) {
        this.cycle = cycle;
    }

    /**
     * update the cycle and see if you need to restock the store.
     * @param cycle the new cycle.
     */
    public void updateCycle(Cycle cycle) {
        if (this.cycle == null) {
            setCycle(cycle);
            sell();
        }
        if (this.cycle.getName().compareTo(cycle.getName()) != 0) {
            setCycle(cycle);
            if (cycle.isNight()) {
                sell();
            }
        }

    }
}
