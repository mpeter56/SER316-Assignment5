package main.java.type;

import main.java.cycle.Hot;
import main.java.cycle.Rainy;

public class Water extends Type {
    
    /**
     * constructor for the water type.
     */
    public Water() {
        this.setStrongAgainst("Fire");
        this.setStrongWhen("Rainy");
        this.setWeakWhen("Hot");
        this.setName("Water");
    }
}
