package com.aldo.rockpaperscissors.gameExecution;

import com.aldo.rockpaperscissors.gameEngine.Game;
import com.aldo.rockpaperscissors.gameEngine.GameBuilder;
import com.aldo.rockpaperscissors.gameEngine.GameResultObserver;
import com.aldo.rockpaperscissors.gameEngine.Player;
import com.aldo.rockpaperscissors.gameConfiguration.GameConfiguration;
import java.util.Arrays;

public class GameInitializer {

    public static Game aiGameExecution(GameResultObserver resultObserver, PlayerObserver player1Observer,
            PlayerObserver player2Observer) {
        
        PlayerImpl aiPlayer1 = PlayerImpl.aiPlayer(GameConfiguration.weaponsCount(), player1Observer);
        
        waitToAvoidSameSeedInRandomGenerator();
        
        PlayerImpl aiPlayer2 = PlayerImpl.aiPlayer(GameConfiguration.weaponsCount(), player2Observer);
        
        return GameBuilder.buildGame(GameConfiguration.weaponsCount(), aiPlayer1, aiPlayer2, 
                createCompositeObserver(resultObserver, aiPlayer1, aiPlayer2));
    }
    
    public static Game humanGameExecution(MovePicker playerMovePicker, GameResultObserver resultObserver,
            PlayerObserver player1Observer, PlayerObserver player2Observer) {
        
        PlayerImpl humanPlayer = PlayerImpl.humanPlayer(playerMovePicker, player1Observer);
        PlayerImpl aiPlayer = PlayerImpl.aiPlayer(GameConfiguration.weaponsCount(), player2Observer);
        
        
        return (GameBuilder.buildGame(GameConfiguration.weaponsCount(), humanPlayer, aiPlayer, 
                createCompositeObserver(resultObserver, humanPlayer, aiPlayer)));
    }
    
    private static GameResultObserver createCompositeObserver(GameResultObserver rO, Player p1, Player p2){
        return new CompositeGameObserver(Arrays.asList(new GameResultObserver[]{rO, new PlayersGameObserver(p1, p2)}));
    }
    
    private static void waitToAvoidSameSeedInRandomGenerator() {
        try{
            Thread.sleep(173);
        }
        catch(InterruptedException e){}
    }
}
