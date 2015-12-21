package com.aldo.rockpaperscissors.gameExecution;

import com.aldo.rockpaperscissors.game.GameResultObserver;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CompositeGameObserverTest {

    private CompositeGameObserver observer;
    private GameResultObserver observer1;
    private GameResultObserver observer2;
    private GameResultObserver observer3;
    private static final int player2Move = 1;
    private static final int player1Move = 0;

    @Before
    public void setUp() {
        observer1 = mock(GameResultObserver.class);
        observer2 = mock(GameResultObserver.class);
        observer3 = mock(GameResultObserver.class);

        observer = new CompositeGameObserver(Arrays.asList(new GameResultObserver[]{observer1, observer2, observer3}));
    }
    
    @Test
    public void observerNotifiesDrawToAllObservers(){
        observer.draw(player1Move, player2Move);
        
        verify(observer1).draw(player1Move, player2Move);
        verify(observer2).draw(player1Move, player2Move);
        verify(observer3).draw(player1Move, player2Move);
    }
    
    @Test
    public void observerNotifiesPlayer1WinsToAllObservers(){
        observer.player1Wins(player1Move, player2Move);
        
        verify(observer1).player1Wins(player1Move, player2Move);
        verify(observer2).player1Wins(player1Move, player2Move);
        verify(observer3).player1Wins(player1Move, player2Move);
    }
    
    @Test
    public void observerNotifiesPlayer2WinsToAllObservers(){
        observer.player2Wins(player1Move, player2Move);
        
        verify(observer1).player2Wins(player1Move, player2Move);
        verify(observer2).player2Wins(player1Move, player2Move);
        verify(observer3).player2Wins(player1Move, player2Move);
    }
}
