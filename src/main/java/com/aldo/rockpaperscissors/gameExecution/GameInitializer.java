package com.aldo.rockpaperscissors.gameExecution;

import com.aldo.rockpaperscissors.gameEngine.Game;
import com.aldo.rockpaperscissors.gameEngine.GameBuilder;
import com.aldo.rockpaperscissors.gameEngine.GameResultObserver;
import com.aldo.rockpaperscissors.gameEngine.Player;
import com.aldo.rockpaperscissors.gameConfiguration.GameConfiguration;
import com.aldo.rockpaperscissors.gameEngine.Draw;
import java.util.Arrays;

public class GameInitializer {

    public static GameRunner aiGameExecution(GameResultObserver resultObserver, CountObserver player1Observer,
            CountObserver player2Observer, CountObserver drawObserver) {
        
        Player aiPlayer1 = PlayerImpl.aiPlayer(GameConfiguration.weaponsCount(), player1Observer);
        
        waitToAvoidSameSeedInRandomGenerator();
        
        Player aiPlayer2 = PlayerImpl.aiPlayer(GameConfiguration.weaponsCount(), player2Observer);
        Draw draw = new DrawImpl(drawObserver);
        
        return GameRunnerImpl.createInstance(GameBuilder.buildGame(GameConfiguration.weaponsCount(), aiPlayer1, aiPlayer2, 
                createCompositeObserver(resultObserver, aiPlayer1, aiPlayer2, draw)));
    }
    
    public static Game humanGameExecution(MovePicker playerMovePicker, GameResultObserver resultObserver,
            CountObserver player1Observer, CountObserver player2Observer, CountObserver drawObserver) {
        
        Player humanPlayer = PlayerImpl.humanPlayer(playerMovePicker, player1Observer);
        Player aiPlayer = PlayerImpl.aiPlayer(GameConfiguration.weaponsCount(), player2Observer);
        Draw draw = new DrawImpl(drawObserver);
        
        return (GameBuilder.buildGame(GameConfiguration.weaponsCount(), humanPlayer, aiPlayer, 
                createCompositeObserver(resultObserver, humanPlayer, aiPlayer, draw)));
    }
    
    private static GameResultObserver createCompositeObserver(GameResultObserver rO, Player p1, Player p2, Draw draw){
        return new CompositeGameObserver(Arrays.asList(new GameResultObserver[]{rO, new PlayersGameObserver(p1, p2, draw)}));
    }
    
    private static void waitToAvoidSameSeedInRandomGenerator() {
        try{
            Thread.sleep(173);
        }
        catch(InterruptedException e){}
    }
}
