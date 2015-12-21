package com.aldo.rockpaperscissors.gameEngine;

class GameImpl implements Game {

    private final GameEngine gameEngine;
    private final Player player1;
    private final Player player2;

    GameImpl(GameEngine gameEngine, Player player1, Player player2) {
        this.gameEngine = gameEngine;
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public void run() {
        player1.doMove();
        player2.doMove();
        
        gameEngine.play(player1.getMove(), player2.getMove());
    }
    
}
