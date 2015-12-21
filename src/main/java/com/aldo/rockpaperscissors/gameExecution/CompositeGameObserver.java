package com.aldo.rockpaperscissors.gameExecution;

import com.aldo.rockpaperscissors.gameEngine.GameResultObserver;
import java.util.Collection;

class CompositeGameObserver implements GameResultObserver {
    private final Collection<GameResultObserver> observers;
    
    CompositeGameObserver(Collection<GameResultObserver> observers) {
        this.observers = observers;
    }

    @Override
    public void draw(int w1, int w2) {
        observers.forEach((o) -> o.draw(w1, w2));
    }

    @Override
    public void player1Wins(int w1, int w2) {
        observers.forEach((o) -> o.player1Wins(w1, w2));
    }

    @Override
    public void player2Wins(int w1, int w2) {
        observers.forEach((o) -> o.player2Wins(w1, w2));
    }

}
