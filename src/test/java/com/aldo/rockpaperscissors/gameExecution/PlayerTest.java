package com.aldo.rockpaperscissors.gameExecution;

import com.aldo.rockpaperscissors.game.Player;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayerTest {

    private MovePicker picker;
    private PlayerObserver observer;
    private Player player;

    @Before
    public void setUp() {
        picker = mock(MovePicker.class);
        observer = mock(PlayerObserver.class);
        player = PlayerImpl.humanPlayer(picker, observer);
    }

    @Test
    public void playerExecutesThePickerMove() {
        givenMovePickerReturns(0);
        Assert.assertThat(player.getMove(), is(equalTo(0)));
    }
    
    @Test
    public void whenPlayerMovesRetrievesMoveFromPicker(){
        player.doMove();
        verify(picker).pickMove();
    }

    @Test
    public void afterAVictoryPlayerIncreasesPointsCounterAndNotifiesObserver() {
        int playerPoints = player.getPoints();
        player.win();
        int playerNewPoints = player.getPoints();

        Assert.assertThat(playerNewPoints, is(equalTo(playerPoints + 1)));
        verify(observer).pointsChanged(playerNewPoints);
    }

    public void givenMovePickerReturns(int move) {
        when(picker.pickMove()).thenReturn(move);
    }
}
