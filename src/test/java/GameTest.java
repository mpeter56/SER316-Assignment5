package test.java;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.game.Game;

public class GameTest {
    
    public GameTest() {
        
    }
    // make sure the game is won when it is auto played
    @Test
    public void test() {
        Game game = new Game();
        assertEquals(true, game.playAutomated());
    }
}
