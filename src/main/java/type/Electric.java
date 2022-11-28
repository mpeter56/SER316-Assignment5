package main.java.type;

import main.java.cycle.Cold;
import main.java.cycle.Hot;

public class Electric extends Type {

    /**
     * constructor for the electric type.
     */
    public Electric() {
        this.setStrongAgainst("Water");
        this.setStrongWhen("Cold");
        this.setWeakWhen("Hot");
        this.setName("Electric");
    }

}
