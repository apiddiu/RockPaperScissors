package com.aldo.rockpaperscissors.gameExecution;

import java.util.Random;

class RandomMovePicker implements MovePicker {

    private int movesCount;
    private final Random aiEngine;

    public RandomMovePicker(int movesCount) {
        this(movesCount, new Random(System.currentTimeMillis()));
    }

    RandomMovePicker(int weaponsSize, Random aiEngine) {
        this.movesCount = weaponsSize;
        this.aiEngine = aiEngine;
    }

    @Override
    public int pickMove() {
        return aiEngine.nextInt(movesCount);
    }
}
