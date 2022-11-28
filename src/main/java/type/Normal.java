package main.java.type;

public class Normal extends Type {
    
    /**
     * constructor for the normal type.
     */
    public Normal() {
        this.setStrongAgainst("none");
        this.setStrongWhen("none");
        this.setWeakWhen("none");
        this.setName("Normal");
    }
}
