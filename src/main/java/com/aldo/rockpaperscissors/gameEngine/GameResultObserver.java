package com.aldo.rockpaperscissors.gameEngine;

public interface GameResultObserver {

    public void draw(int w1, int w2);

    public void player1Wins(int w1, int w2);

    public void player2Wins(int w1, int w2);

}
