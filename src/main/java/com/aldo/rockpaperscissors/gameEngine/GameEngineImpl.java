package com.aldo.rockpaperscissors.gameEngine;

class GameEngineImpl implements GameEngine {

    private final GameResultObserver gameResult;
    private final int movesCount;

    GameEngineImpl(GameResultObserver gameResultListener, int movesCount) {
        this.gameResult = gameResultListener;
        this.movesCount = movesCount;
    }

    @Override
    public void play(int w1, int w2) {
        int d = w1 - w2;

        if (d == 0) {
            gameResult.draw(w1, w2);
        } else if ((Math.floorMod(d, movesCount)) <= (movesCount / 2)) {
            gameResult.player1Wins(w1, w2);
        } else {
            gameResult.player2Wins(w1, w2);
        }
    }

}
