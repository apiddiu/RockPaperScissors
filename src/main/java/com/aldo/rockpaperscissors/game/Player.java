package com.aldo.rockpaperscissors.game;

public interface Player {

    void doMove();
    
    int getMove();

    int getPlayerPoints();

    void win();
}
