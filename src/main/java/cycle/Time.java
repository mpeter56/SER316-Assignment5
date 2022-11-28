package main.java.cycle;

import main.java.game.Subject;

public class Time implements Observer {
    private int time;
    private int cycleNum;
    private Cycle cycle;
    private static final int hoursInCycle = 12;
    private Subject gameMediator;

    /**
     * constructor for the time observer.
     * @param gameMediator the game mediator.
     */
    public Time(Subject gameMediator) {
        this.gameMediator = gameMediator;
        this.cycleNum = 1;
        this.cycle = new Day();
        updateCycle();
    }

    @Override
    public void update(int newTime, int level) {
        this.time = newTime;
        if (checkNewCycle()) {
            newCycle();
            updateCycle();
        }
    }

    private boolean checkNewCycle() {
        double newCycleNum = time / (double) hoursInCycle;
        if (newCycleNum >= cycleNum) {
            return true;
        } else {
            return false;
        }
    }

    private void newCycle() {
        int newCycleNum = (int) (time / hoursInCycle);
        if (newCycleNum % 2 == 0) {
            cycleNum = newCycleNum;
            cycle = new Day();
        } else {
            cycleNum = newCycleNum;
            cycle = new Night();
        }
    }

    public void updateCycle() {
        System.out.println("Cycle: " + cycleNum);
        gameMediator.updateCycle(cycle);
    }

}
