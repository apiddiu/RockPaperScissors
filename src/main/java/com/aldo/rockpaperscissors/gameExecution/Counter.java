package com.aldo.rockpaperscissors.gameExecution;

public final class Counter {
    private final CountObserver observer;
    private int pointsCount = 0;

    Counter(CountObserver observer) {
        this.observer = observer;
        reset();
    }

    void increase() {
        observer.countChanged(++pointsCount);
    }

    void decrease() {
        observer.countChanged(++pointsCount);
    }

    void reset() {
        pointsCount = 0;
        observer.countChanged(pointsCount);
    }

}
