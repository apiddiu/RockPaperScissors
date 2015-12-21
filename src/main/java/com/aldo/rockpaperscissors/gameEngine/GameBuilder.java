package com.aldo.rockpaperscissors.gameEngine;

public class GameBuilder {  
    public static Game buildGame(int movesCount, Player p1, Player p2, GameResultObserver rL){
        GameEngine gE = new GameEngineImpl(rL, movesCount);
        
        return new GameImpl(gE, p1, p2);
    }
}
