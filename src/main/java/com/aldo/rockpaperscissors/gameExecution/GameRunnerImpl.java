package com.aldo.rockpaperscissors.gameExecution;

import com.aldo.rockpaperscissors.gameEngine.Game;
import static java.lang.Thread.sleep;

class GameRunnerImpl implements GameRunner {

    private final Game game;
    private final long interval;
    private Thread gameThread;
    private volatile boolean running = true;

    GameRunnerImpl(Game game) {
        this(game, 1000);
    }

    GameRunnerImpl(Game game, long interval) {
        this.gameThread = new Thread(this::playGame);
        this.game = game;
        this.interval = interval;
    }
    
    @Override
    public void toggle(){
        if(gameThread!=null && gameThread.isAlive()){
            stop();
        }
        else{
            start();
        }
    }

    @Override
    public void start() {
        running = true;
        this.gameThread = new Thread(this::playGame);
        gameThread.start();
    }

    @Override
    public void stop() {
        running = false;
        if (gameThread.isAlive()) {
            try {
                gameThread.join(1000);
            } catch (InterruptedException ie) {
            }
        }
    }

    public void playGame() {
        while (running) {
            game.run();

            try {
                sleep(interval);
            } catch (InterruptedException ie) {
            }
        }
    }
}
