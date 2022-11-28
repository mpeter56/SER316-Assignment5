package main.java.type;

import main.java.cycle.Hot;
import main.java.cycle.Rainy;

public class Fire extends Type {
    
    /**
     * constructor for the fire type.
     */
    public Fire() {
        this.setStrongAgainst("Plant");
        this.setStrongWhen("Hot");
        this.setWeakWhen("Rainy");
        this.setName("Fire");
    }
}
