package com.aldo.rockpaperscissors.game;

import junitparams.JUnitParamsRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(JUnitParamsRunner.class)
public class GameEngineRockPaperScissorsTest implements GameResultChecker {

    private GameEngineImpl engine;
    private GameResultObserver result;
    private final int weapons = 3;

    @Before
    public void setUp() {
        result = Mockito.mock(GameResultObserver.class);
        engine = new GameEngineImpl(result, weapons);
    }

    @Test
    public void rockVsRockIsADrawTest() {
        runTest(rock(), rock(), this::verifyDraw);
    }

    @Test
    public void paperVsPaperIsADrawTest() {
        runTest(paper(), paper(), this::verifyDraw);
    }

    @Test
    public void scissorsVsScissorsIsADrawTest() {
        runTest(scissors(), scissors(), this::verifyDraw);
    }

    @Test
    public void rockBeatsScissorsTest() {
        runTest(rock(), scissors(), this::verifyPlayer1Wins);
    }

    @Test
    public void rockIsBeatenByPaperTest() {
        runTest(rock(), paper(), this::verifyPlayer2Wins);
    }

    @Test
    public void paperBeatsRockTest() {
        runTest(paper(), rock(), this::verifyPlayer1Wins);
    }

    @Test
    public void paperIsBeatenByScissorsTest() {
        runTest(paper(), scissors(), this::verifyPlayer2Wins);
    }

    @Test
    public void scissorsBeatsPaperTest() {
        runTest(scissors(), paper(), this::verifyPlayer1Wins);
    }

    @Test
    public void scissorsIsBeatenByRockTest() {
        runTest(scissors(), rock(), this::verifyPlayer2Wins);
    }

    public void runTest(int w1, int w2, GameResultVerifier verifyResult) {
        engine.play(w1, w2);
        verifyResult.verify(w1, w2, result);
        verifyNoMoreInteractions(result);
    }

    private int rock() {
        return 0;
    }

    private int paper() {
        return 1;
    }

    private int scissors() {
        return 2;
    }

}
