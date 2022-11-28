package main.java.actions;

public abstract class Item {
    protected String name;
    protected int healthRestored;
    protected int price;

    public String getName() {
        return name;
    }

    public int getHealthRestored() {
        return healthRestored;
    }

    public int getPrice() {
        return price;
    }
}
