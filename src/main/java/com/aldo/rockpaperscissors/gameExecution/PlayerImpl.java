package com.aldo.rockpaperscissors.gameExecution;

import com.aldo.rockpaperscissors.game.Player;

class PlayerImpl implements Player {

    private int playerPoints;
    private int currentMove;
    private final MovePicker movePicker;
    private final PlayerObserver observer;
    
    public static PlayerImpl aiPlayer(int movesCount, PlayerObserver observer){
        return new PlayerImpl(new RandomMovePicker(movesCount), observer);
    }
    
    public static PlayerImpl humanPlayer(MovePicker movePicker, PlayerObserver observer){
        return new PlayerImpl(movePicker, observer);
    }

    private PlayerImpl(MovePicker movePicker, PlayerObserver observer) {
        this.movePicker = movePicker;
        this.playerPoints = 0;
        this.observer = observer;
        observer.pointsChanged(0);
    }

    @Override
    public void win() {
        ++playerPoints;
        observer.pointsChanged(playerPoints);
    }

    @Override
    public int getPoints() {
        return playerPoints;
    }

    @Override
    public int getMove() {
        return currentMove;
    }

    @Override
    public void doMove() {
        currentMove = movePicker.pickMove();
    }
}
