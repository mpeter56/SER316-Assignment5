package main.java.type;

import main.java.cycle.Cold;
import main.java.cycle.Rainy;

public class Rock extends Type {
    
    /**
     * constructor for the rock type.
     */
    public Rock() {
        this.setStrongAgainst("Electric");
        this.setStrongWhen("Cold");
        this.setWeakWhen("Rainy");
        this.setName("Rock");
    }
}
