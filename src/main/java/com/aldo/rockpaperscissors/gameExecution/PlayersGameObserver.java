package com.aldo.rockpaperscissors.gameExecution;

import com.aldo.rockpaperscissors.gameEngine.Draw;
import com.aldo.rockpaperscissors.gameEngine.GameResultObserver;
import com.aldo.rockpaperscissors.gameEngine.Player;

class PlayersGameObserver implements GameResultObserver {
    private final Player p1;
    private final Player p2;
    private final Draw draw;

    public PlayersGameObserver(Player p1, Player p2, Draw draw) {
        this.p1 = p1;
        this.p2 = p2;
        this.draw = draw;
    }

    @Override
    public void draw(int w1, int w2) {
        draw.draw();
    }

    @Override
    public void player1Wins(int w1, int w2) {
        p1.win();
    }

    @Override
    public void player2Wins(int w1, int w2) {
        p2.win();
    }

}
