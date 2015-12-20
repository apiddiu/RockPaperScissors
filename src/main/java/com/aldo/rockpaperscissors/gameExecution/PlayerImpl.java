package com.aldo.rockpaperscissors.gameExecution;

import com.aldo.rockpaperscissors.game.Player;

class PlayerImpl implements Player {

    private int playerPoints;
    private int currentMove;
    private final MovePicker movePicker;
    
    public static PlayerImpl aiPlayer(int movesCount){
        return new PlayerImpl(new RandomMovePicker(movesCount));
    }
    
    public static PlayerImpl humanPlayer(MovePicker movePicker){
        return new PlayerImpl(movePicker);
    }

    private PlayerImpl(MovePicker movePicker) {
        this.movePicker = movePicker;
        this.playerPoints = 0;
    }

    @Override
    public void win() {
        ++playerPoints;
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
