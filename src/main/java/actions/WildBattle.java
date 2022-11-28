package main.java.actions;

// fulfills requirement 8
import main.java.codeamon.CodeAMon;
import main.java.game.GameMediator;
import main.java.game.Mediator;
import main.java.trainer.Trainer;

public class WildBattle {
    String weather;

    public WildBattle(String weather) {
        setWeather(weather);
    }

    private void setWeather(String weather) {
        this.weather = weather;
    }

    /**
     * a battle between a trainer and a wild codeamon.
     * @param trainer the battling trainer
     * @param cam the battleing codeamon
     * @return the updated trainer
     */
    public Trainer wildBattle(Trainer trainer, CodeAMon cam) {
        System.out.println("A wild " + cam.getName() + " Appeared");
        System.out.println("Battle:");
        System.out.println("---------------------------------------------");
        CodeAMon[] tcam = trainer.getCam();
        int camLeft = tcam.length;
        int camIdx = 0;
        CamBattle battle = new CamBattle();
        CodeAMon winner = cam;
        while (camLeft > 0 && winner.getTrainerId() == cam.getTrainerId()) {
            if (tcam[camIdx] == null) {
                camLeft--;
                camIdx++;
            } else {
                System.out.println(trainer.getName() + ":" + tcam[camIdx].getName() 
                        + ", I choose you!");
                winner = battle.battle(tcam[camIdx], cam, weather);
                if (winner.getTrainerId() == cam.getTrainerId()) {
                    camIdx++;
                    camLeft--;
                }
            }
        }
        if (camLeft > 0) {

            System.out.println(trainer.getName() + "'s CodeAMon: " + tcam[camIdx].getName() 
                    + " defeated the wild "
                    + cam.getName());
            if (tcam.length > trainer.getNumOfCam()) {
                int idx = -1;
                for (int i = 0; i < tcam.length; i++) {
                    if (tcam[i] == null) {
                        System.out.println(trainer.getName() + " captured " + cam.getName());
                        idx = i;
                    }
                }
                trainer.setNumOfCam(trainer.getNumOfCam() + 1);
                cam.setTrainerId(0);
                tcam[idx] = cam;
                trainer.setCam(tcam);
            }
            trainer.setExperience(trainer.getExperience() + 50);
        } else {
            System.out.println(trainer.getName() + " was defeated by the wild " + cam.getName());
        }
        System.out.println("---------------------------------------------");
        trainer.levelUp();
        return trainer;
    }

}
