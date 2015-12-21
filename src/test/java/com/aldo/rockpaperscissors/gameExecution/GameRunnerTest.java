package com.aldo.rockpaperscissors.gameExecution;

import com.aldo.rockpaperscissors.gameEngine.Game;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;

public class GameRunnerTest {

    private GameRunnerImpl runner;
    private Game game;

    @Before
    public void setUp() {
        game = mock(Game.class);
        runner = new GameRunnerImpl(game, 100);
    }

    @Test
    public void gameRunnerExecutionTest() throws InterruptedException {
            runner.toggle();
            Thread.sleep(1500);
            runner.toggle();
            
            runner.toggle();
            Thread.sleep(1500);
            runner.toggle();

          Mockito.verify(game, Mockito.times(30)).run();
    }
}
