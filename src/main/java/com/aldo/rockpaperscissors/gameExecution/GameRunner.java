package com.aldo.rockpaperscissors.gameExecution;

import com.aldo.rockpaperscissors.gameEngine.Game;
import static java.lang.Thread.sleep;

public class GameRunner implements Runnable {

    private final Game game;
    private volatile boolean running = true;

    public GameRunner(Game game) {
        this.game = game;
    }

    public void terminate() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            game.run();

            try {
                sleep(1000);
            } catch (InterruptedException ie) {
            }
        }
    }
}
