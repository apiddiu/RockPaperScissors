package com.aldo.rockpaperscissors.game;

public abstract class PlayerBase implements Player {

    private int playerPoints;
    private int currentMove;

    public PlayerBase() {
        this.playerPoints = 0;
    }

    @Override
    public void win() {
        ++playerPoints;
    }

    @Override
    public int getPlayerPoints() {
        return playerPoints;
    }
    
    @Override
    public int getMove() {
        return currentMove;
    }
    
    protected void setMove(int move){
        this.currentMove = move;
    }
}
