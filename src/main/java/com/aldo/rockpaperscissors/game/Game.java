package com.aldo.rockpaperscissors.game;

import com.aldo.rockpaperscissors.gameConfiguration.GameConfiguration;
import com.aldo.rockpaperscissorsengine.GameEngine;
import com.aldo.rockpaperscissorsengine.Weapon;
import java.util.Map;

public class Game {

    private final Map<Integer, Weapon> weapons;
    private final GameEngine gameEngine;
    private final Player player1;
    private final Player player2;

    public Game(GameEngine gameEngine, Map<Integer, Weapon> weapons, Player player1, Player player2) {
        this.gameEngine = gameEngine;
        this.weapons = weapons;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void run() {
        player1.doMove();
        player2.doMove();
        
        Weapon player1Move = GameConfiguration.retrieveMove(player1.getMove());
        Weapon player2Move = GameConfiguration.retrieveMove(player2.getMove());
        
        gameEngine.play(player1Move, player2Move);
    }
}
