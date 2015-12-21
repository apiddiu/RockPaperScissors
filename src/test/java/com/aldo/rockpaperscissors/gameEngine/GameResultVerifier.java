package com.aldo.rockpaperscissors.gameEngine;

interface GameResultVerifier {

    void verify(int w1, int w2, GameResultObserver result);

}
