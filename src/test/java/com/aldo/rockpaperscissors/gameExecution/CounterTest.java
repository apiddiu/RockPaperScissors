package com.aldo.rockpaperscissors.gameExecution;

import com.aldo.rockpaperscissors.gameEngine.Draw;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CounterTest {

    private CountObserver observer;
    private Counter counter;

    @Before
    public void setUp() {
        observer = mock(CountObserver.class);
        counter = new Counter(observer);
    }

    @Test
    public void counterNotifiesObserverWhenCountIncreases() {
        verify(observer).countChanged(0);

        for (int drawCount = 0; drawCount < 100; drawCount++) {
            counter.increase();
            verify(observer).countChanged(drawCount);
        }
    }

    @Test
    public void counterNotifiesObserverWhenCountDecreases() {
        verify(observer).countChanged(0);

        for (int drawCount = 1; drawCount < 100; drawCount++) {
            counter.decrease();
            verify(observer).countChanged(drawCount * -1);
        }
    }

    @Test
    public void counterNotifiesObserverWhenCountResets() {

        for (int drawCount = 1; drawCount < 100; drawCount++) {
            counter.reset();
        }
        verify(observer, Mockito.times(100)).countChanged(0);
    }
}
