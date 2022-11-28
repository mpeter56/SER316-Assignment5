package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.actions.Bed;
import main.java.codeamon.CodeAMon;
import main.java.codeamon.CodeAMonFactory;
import main.java.cycle.Time;
import main.java.game.GameMediator;
import main.java.trainer.NewTrainer;
import main.java.trainer.Trainer;

public class CodeAMonTest {
    public CodeAMonTest() {
        
    }
    
    // this tests the evolve capability!
    // code a mon evolve at night while resting
    // code a mon get an evolution every 10 levels
    @Test
    public void testEvolve() {
        CodeAMonFactory cf = new CodeAMonFactory();
        CodeAMon c = cf.makeCaM(1, 0);
        c.setExperience(200000);
        c.levelUpBelow16();
        GameMediator gm = new GameMediator();
        Bed bed = new Bed(gm);
        Time time = new Time(gm);
        gm.register(time);
        Trainer t = new NewTrainer(null, gm, 0);
        gm.addTrainer(t);
        CodeAMon[] cam = t.getCam();
        cam[0] = c;
        t.setCam(cam);
        assertEquals(0,c.getEvolutions().size());
        t.wait12Hour();
        t.rest();
        t.wait12Hour();
        t.rest();
        t.wait12Hour();
        t.rest();
        t.wait12Hour();
        t.rest();
        t.wait12Hour();
        t.rest();
        t.wait12Hour();
        t.rest();
        t.wait12Hour();
        t.rest();
        t.wait12Hour();
        t.rest();
        t.wait12Hour();
        t.rest();
        c = t.getCam()[0];
        if(c.getName().contains("Bunny")) {
            assertEquals(83, c.getLevel());
            assertEquals(8,c.getEvolutions().size());
        }else if(c.getName().contains("Cat")){
            assertEquals(78, c.getLevel());
            assertEquals(7,c.getEvolutions().size());
        }else {
            assertEquals(80, c.getLevel());
            assertEquals(8,c.getEvolutions().size());
        }
        
    }
}
