package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.trainer.Trainer;
import main.java.trainer.TrainerFactory;

public class TrainerFactoryTest {
    public TrainerFactoryTest() {
        
    }
    
    // test creation of intermediate trainer
    @Test
    public void testIntTrainer() {
        TrainerFactory tf = new TrainerFactory();
        Trainer t = tf.makeTrainer(0.333, null, 0);
        assertEquals(10,t.getLevel());
        assertEquals(6,t.getCam()[0].getLevel());
    }
    
    // test creation of experienced trainer
    @Test
    public void testExperiencedTrainer() {
        TrainerFactory tf = new TrainerFactory();
        Trainer t = tf.makeTrainer(0.5, null, 0);
        assertEquals(15,t.getLevel());
        assertEquals(9,t.getCam()[0].getLevel());
    }
    
    // test creation of expert trainer
    @Test
    public void testExpertTrainer() {
        TrainerFactory tf = new TrainerFactory();
        Trainer t = tf.makeTrainer(0.667, null, 0);
        assertEquals(20,t.getLevel());
        assertEquals(12,t.getCam()[0].getLevel());
    }
    
    // test creation of master trainer
    @Test
    public void testMasterTrainer() {
        TrainerFactory tf = new TrainerFactory();
        Trainer t = tf.makeTrainer(0.833, null, 0);
        assertEquals(25,t.getLevel());
        assertEquals(15,t.getCam()[0].getLevel());
    }
    
    //tests the setName() function;
    @Test
    public void testSetName() {
        TrainerFactory tf = new TrainerFactory();
        Trainer t = tf.makeTrainer(0.833, null, 0);
        t.setName("Belle");
        assertEquals("Belle",t.getName());
    }
    


}
