package com.aldo.rockpaperscissors.gameExecution;

import com.aldo.rockpaperscissors.gameEngine.Player;
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
    private CountObserver observer; 
    private Player player;

    @Before
    public void setUp() {
        picker = mock(MovePicker.class);
        observer = mock(CountObserver.class);
        player = PlayerImpl.humanPlayer(picker, observer);
    }

    @Test
    public void playerExecutesThePickerMove() {
        givenMovePickerReturns(0);
        Assert.assertThat(player.getMove(), is(equalTo(0)));
    }

    @Test
    public void whenPlayerMovesRetrievesMoveFromPicker() {
        player.doMove();
        verify(picker).pickMove();
    }

    @Test
    public void afterAVictoryPlayerIncreasesPointsCounterAndNotifiesObserver() {
        verify(observer).countChanged(0);
        for (int winCount = 1; winCount < 100; winCount++) {
            player.win();
            verify(observer).countChanged(winCount);
        }
    }

    public void givenMovePickerReturns(int move) {
        when(picker.pickMove()).thenReturn(move);
    }
}
