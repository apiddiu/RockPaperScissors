package com.aldo.rockpaperscissors.gameEngine;

public interface Player {

    void doMove();
    
    int getMove();

    int getPoints();

    void win();
}
