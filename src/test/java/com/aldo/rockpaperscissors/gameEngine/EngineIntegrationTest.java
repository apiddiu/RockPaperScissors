package com.aldo.rockpaperscissors.gameEngine;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(JUnitParamsRunner.class)
public class EngineIntegrationTest implements GameResultChecker{

    private GameImpl game;
    private GameEngine engine;
    private GameResultObserver result;
    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        result = mock(GameResultObserver.class);
        engine = new GameEngineImpl(result, 3);

        game = new GameImpl(engine, player1, player2);
    }

    @Test
    @Parameters
    public void givenPlayer1PlaysWinningMovePlayer1Wins(int player1Weapon, int player2Weapon) {
        givenPlayerPlaysWeapon(player1, player1Weapon);
        givenPlayerPlaysWeapon(player2, player2Weapon);

        whenGameRuns();

        verifyPlayer1Wins(player1Weapon, player2Weapon, result);
    }

    @Test
    @Parameters
    public void givenPlayer2PlaysWinningMovePlayer2Wins(int player1Weapon, int player2Weapon) {
        givenPlayerPlaysWeapon(player1, player1Weapon);
        givenPlayerPlaysWeapon(player2, player2Weapon);

        whenGameRuns();

        verifyPlayer2Wins(player1Weapon, player2Weapon, result);
    }

    @Test
    @Parameters
    public void givenPlayersPlaySameMoveGameIsDraw(int player1Weapon, int player2Weapon) {
        givenPlayerPlaysWeapon(player1, player1Weapon);
        givenPlayerPlaysWeapon(player2, player2Weapon);

        whenGameRuns();

        verifyDraw(player1Weapon, player2Weapon, result);
    }

    public Object[] parametersForGivenPlayer1PlaysWinningMovePlayer1Wins() {
        return new Object[]{
            new Object[]{0, 2},
            new Object[]{2, 1},
            new Object[]{1, 0},};
    }

    public Object[] parametersForGivenPlayer2PlaysWinningMovePlayer2Wins() {
        return new Object[]{
            new Object[]{0, 1},
            new Object[]{2, 0},
            new Object[]{1, 2},};
    }

    public Object[] parametersForGivenPlayersPlaySameMoveGameIsDraw() {
        return new Object[]{
            new Object[]{0, 0},
            new Object[]{2, 2},
            new Object[]{1, 1},};
    }

    private void whenGameRuns() {
        game.run();
    }

    private void givenPlayerPlaysWeapon(Player p, int w) {
        when(p.getMove()).thenReturn(w);
    }
}
