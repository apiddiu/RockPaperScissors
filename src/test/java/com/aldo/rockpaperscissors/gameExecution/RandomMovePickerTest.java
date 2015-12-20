package com.aldo.rockpaperscissors.gameExecution;

import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RandomMovePickerTest {

    private MovePicker picker;
    private static final int WEAPONS = 3;

    @Before
    public void setUp() {
        picker = new RandomMovePicker(WEAPONS);
    }

    @Test
    public void pickerPlaysAlwaysAValidMove() {
        for (int i = 0; i < 10000; i++) {
            int pickMove = picker.pickMove();
            Assert.assertThat(pickMove, is(greaterThanOrEqualTo(0)));
            Assert.assertThat(pickMove, is(Matchers.lessThan(WEAPONS)));
        }
    }
}
