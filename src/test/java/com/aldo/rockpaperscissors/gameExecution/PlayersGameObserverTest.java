package com.aldo.rockpaperscissors.gameExecution;

import com.aldo.rockpaperscissors.gameEngine.Player;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class PlayersGameObserverTest {
    private PlayersGameObserver playersGameObserver;
    private Player player1;
    private Player player2;
    
    @Before
    public void setUp(){
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        
        playersGameObserver = new PlayersGameObserver(player1, player2);
    }
    
    @Test
    public void whenGameIsADrowNoPlayerEarnsPoints(){
        playersGameObserver.draw(0, 0);
        
        verifyNoMoreInteractions(player1, player2);
    }
    
    @Test
    public void whenPlayer1WinsEarnsAPoint(){
        playersGameObserver.player1Wins(0, 1);
        
        verify(player1).win();
        verifyNoMoreInteractions(player1, player2);
    }
    
    @Test
    public void whenPlayer2WinsEarnsAPoint(){
        playersGameObserver.player2Wins(1, 0);
        
        verify(player2).win();
        verifyNoMoreInteractions(player1, player2);
    }
}
