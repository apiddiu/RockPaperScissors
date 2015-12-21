package com.aldo.rockpaperscissors.gameEngine;

import static org.mockito.Mockito.verify;

interface GameResultChecker {

    default void verifyPlayer1Wins(int w1, int w2, GameResultObserver result) {
        verify(result).player1Wins(w1, w2);
    }

    default void verifyPlayer2Wins(int w1, int w2, GameResultObserver result) {
        verify(result).player2Wins(w1, w2);
    }

    default void verifyDraw(int w1, int w2, GameResultObserver result) {
        verify(result).draw(w1, w2);
    }
}
