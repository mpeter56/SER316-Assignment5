package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.actions.Shop;
import main.java.codeamon.CodeAMon;
import main.java.game.Game;
import main.java.game.GameMediator;
import main.java.game.Mediator;
import main.java.trainer.Trainer;
import main.java.trainer.TrainerFactory;

public class TrainerTest {
    
    public TrainerTest() {
        
    }
    
    // test the buy function and the add item function
    @Test
    public void testAddItem() {
        GameMediator gm = new GameMediator();
        Shop s = new Shop(gm);
        s.sell();
        TrainerFactory tf = new TrainerFactory();
        Trainer t = tf.makeTrainer(0, gm, 0);
        gm.addTrainer(t);
        t.setMoney(100);
        assertEquals(true, t.hasFreeItemSlot());
        assertEquals(true,t.buy("HealthPotion"));
        assertEquals(false, t.hasFreeItemSlot());
    }
    
    // test the health potion capabilities
    @Test
    public void testGiveHealthPotion() {
        GameMediator gm = new GameMediator();
        Shop s = new Shop(gm);
        s.sell();
        TrainerFactory tf = new TrainerFactory();
        Trainer t = tf.makeTrainer(0, gm, 0);
        gm.addTrainer(t);
        t.setMoney(100);
        assertEquals(true, t.hasFreeItemSlot());
        assertEquals(true,t.buy("HealthPotion"));
        assertEquals(false, t.hasFreeItemSlot());
        
        CodeAMon[] cam = t.getCam();
        cam[0].setHealth(0);
        t.setCam(cam);
        assertEquals(0, t.getCam()[0].getHealth());
        t.giveHealthPotion(0);
        assertEquals(50, t.getCam()[0].getHealth());
    }
    
    // makes sure that if we dont have a health potion the health potion is not applied
    @Test
    public void testGiveHealthPotionDontHaveIt() {
        GameMediator gm = new GameMediator();
        Shop s = new Shop(gm);
        s.sell();
        TrainerFactory tf = new TrainerFactory();
        Trainer t = tf.makeTrainer(0, gm, 0);
        gm.addTrainer(t);
        t.setMoney(99);
        assertEquals(true, t.hasFreeItemSlot());
        assertEquals(false,t.buy("HealthPotion"));
        assertEquals(true, t.hasFreeItemSlot());
        
        CodeAMon[] cam = t.getCam();
        cam[0].setHealth(0);
        t.setCam(cam);
        assertEquals(0, t.getCam()[0].getHealth());
        t.giveHealthPotion(0);
        assertEquals(00, t.getCam()[0].getHealth());
    }
}
