package main.java.cycle;

public abstract class Weather {
    protected String name;

    public Weather() {
        setName();
    }

    public String getName() {
        return this.name;
    }

    public abstract void setName();

}
