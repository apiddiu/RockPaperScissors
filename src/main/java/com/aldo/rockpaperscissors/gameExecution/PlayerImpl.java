package com.aldo.rockpaperscissors.gameExecution;

import com.aldo.rockpaperscissors.gameEngine.Player;

class PlayerImpl implements Player {

    private final Counter counter;
    private int currentMove;
    private final MovePicker movePicker;

    public static PlayerImpl aiPlayer(int movesCount, CountObserver observer) {
        return new PlayerImpl(new RandomMovePicker(movesCount), observer);
    }

    public static PlayerImpl humanPlayer(MovePicker movePicker, CountObserver observer) {
        return new PlayerImpl(movePicker, observer);
    }

    private PlayerImpl(MovePicker movePicker, CountObserver observer) {
        this(movePicker, new Counter(observer));
    }
    
    private PlayerImpl(MovePicker movePicker, Counter counter) {
        this.movePicker = movePicker;
        this.counter = counter;
    }

    @Override
    public void win() {
        counter.increase();
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
