package main.java.type;

import main.java.cycle.Weather;

// fulfills requirement 7
public class Type {
    // fulfills requirement 6
    private String strongAgainst;
    private String strongWhen;
    private String weakWhen;
    private String name;

    public String getStrongAgainst() {
        return this.strongAgainst;
    }

    public String getStrongWhen() {
        return this.strongWhen;
    }

    public String getWeakWhen() {
        return this.weakWhen;
    }

    public void setStrongAgainst(String type) {
        this.strongAgainst = type;
    }

    public void setStrongWhen(String weather) {
        this.strongWhen = weather;
    }

    public void setWeakWhen(String weather) {
        this.weakWhen = weather;
    }

    public void setName(String string) {
        this.name = string;
    }

    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}
