package com.aldo.rockpaperscissors.gameExecution;

import com.aldo.rockpaperscissors.gameEngine.Draw;

public class DrawImpl implements Draw {

    private final Counter counter;

    DrawImpl(CountObserver observer) {
        this(new Counter(observer));
    }
    
    private DrawImpl(Counter counter){
        this.counter = counter;
    }

    @Override
    public void draw() {
        counter.increase();
    }

}
