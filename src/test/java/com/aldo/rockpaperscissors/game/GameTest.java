package com.aldo.rockpaperscissors.game;

import com.aldo.rockpaperscissors.gameConfiguration.GameConfiguration;
import com.aldo.rockpaperscissorsengine.GameEngine;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameTest {

    private Game game;
    private GameEngine engine;
    private Player player1;
    private Player player2;
    
    @Before
    public void setUp() {
        engine = mock(GameEngine.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        
        game = new Game(engine, GameConfiguration.getWeapons(), player1, player2);
    }
    
    @Test
    public void gameBehaviourTest() {
        int player1Move = 0;
        int player2Move = 1;
        
        givenPlayerPlaysWeapon(player1, player1Move);
        givenPlayerPlaysWeapon(player2, player2Move);
        
        game.run();
        
        verify(player1).doMove();
        verify(player2).doMove();
        verify(engine).play(GameConfiguration.retrieveMove(player1Move), GameConfiguration.retrieveMove(player2Move));
    }
    
    private void givenPlayerPlaysWeapon(Player p, int weapon) {
        when(p.getMove()).thenReturn(weapon);
    }
}
