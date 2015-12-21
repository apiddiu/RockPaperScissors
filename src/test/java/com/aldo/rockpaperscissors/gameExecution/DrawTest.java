package com.aldo.rockpaperscissors.gameExecution;

import com.aldo.rockpaperscissors.gameEngine.Draw;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DrawTest {

    private CountObserver observer;
    private Draw draw;

    @Before
    public void setUp() {
        observer = mock(CountObserver.class);
        draw = new DrawImpl(observer);
    }

    @Test
    public void afterADrawCountIncreasesAndObserverIsNotified() {
        verify(observer).countChanged(0);
        
        for (int drawCount = 0; drawCount < 100; drawCount++) {
            draw.draw();
            verify(observer).countChanged(drawCount);
        }
    }
}
