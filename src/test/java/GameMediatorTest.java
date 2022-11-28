package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.actions.Shop;
import main.java.game.GameMediator;

public class GameMediatorTest {
    public GameMediatorTest() {
        
    }
    
    // this test is to make sure that the shop sell function is properly calling the gameMediator
    // function and the items are being added to the itemsForSale
    // shop starts out with 5 items and if you sell again it will add a new 5 to the gm.
    @Test
    public void testSell() {
        GameMediator gm = new GameMediator();
        Shop s = new Shop(gm);
        s.sell();
        assertEquals(5, gm.getItemsForSale());
        s.sell();
        
        assertEquals(10, gm.getItemsForSale());
    }
}
