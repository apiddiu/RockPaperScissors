package com.aldo.rockpaperscissors.gameExecution;

import com.aldo.rockpaperscissors.game.Game;
import com.aldo.rockpaperscissors.game.GameBuilder;
import com.aldo.rockpaperscissors.game.GameResultListener;
import com.aldo.rockpaperscissors.gameConfiguration.GameConfiguration;

public class GameInitializer {

    public static Game aiGameExecution(GameResultListener resultListener) {
        return GameBuilder.buildGame(GameConfiguration.weaponsCount(),
                PlayerImpl.aiPlayer(GameConfiguration.weaponsCount()),
                PlayerImpl.aiPlayer(GameConfiguration.weaponsCount()), resultListener);
    }
    
    public static Game humanGameExecution(MovePicker playerMovePicker, GameResultListener resultListener) {
        return (GameBuilder.buildGame(GameConfiguration.weaponsCount(),
                PlayerImpl.humanPlayer(playerMovePicker),
                PlayerImpl.aiPlayer(GameConfiguration.weaponsCount()), resultListener));
    }
}
