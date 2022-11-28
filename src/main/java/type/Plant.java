package main.java.type;

import main.java.cycle.Cold;
import main.java.cycle.Rainy;

public class Plant extends Type {
    
    /**
     * constructor for the plant type.
     */
    public Plant() {
        this.setStrongAgainst("Rock");
        this.setStrongWhen("Rainy");
        this.setWeakWhen("Cold");
        this.setName("Plant");
    }
}
