package com.aldo.rockpaperscissors.game;

import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AiPlayerTest {
    private AiPlayer player;
    private static final int WEAPONS = 3;
    
    @Before
    public void setUp(){
        player = new AiPlayer(WEAPONS);
    }
    
    @Test
    public void playerPlaysAlwaysAValidMove(){
        for(int i=0;i<10000;i++){
            player.doMove();
            Assert.assertThat(player.getMove(), is(greaterThanOrEqualTo(0)));
            Assert.assertThat(player.getMove(), is(Matchers.lessThan(WEAPONS)));
        }
    }

    @Test
    public void afterAVictoryPlayerIncreasesPointsCounter(){
        int playerPoints = player.getPlayerPoints();
        player.win();
        int playerNewPoints = player.getPlayerPoints();
        
        Assert.assertThat(playerNewPoints, is(greaterThan(playerPoints)));
    }
}
