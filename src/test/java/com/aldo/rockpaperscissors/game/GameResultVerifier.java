package com.aldo.rockpaperscissors.game;

interface GameResultVerifier {

    void verify(int w1, int w2, GameResultObserver result);

}
