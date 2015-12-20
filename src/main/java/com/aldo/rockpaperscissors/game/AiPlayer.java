package com.aldo.rockpaperscissors.game;

import java.util.Random;

public class AiPlayer extends PlayerBase implements Player{

    private Random aiEngine;
    private int weaponsSize;

    public AiPlayer(int weaponsSize) {
        this(weaponsSize, new Random(System.currentTimeMillis()));
    }

    AiPlayer(int weaponsSize, Random aiEngine) {
        this.weaponsSize = weaponsSize;
        this.aiEngine = aiEngine;
    }

    @Override
    public void doMove() {
        setMove(aiEngine.nextInt(weaponsSize));
    }
}
