package com.aldo.rockpaperscissors.game;

import com.aldo.rockpaperscissors.gameConfiguration.GameConfiguration;
import com.aldo.rockpaperscissors.gameConfiguration.Weapons;
import com.aldo.rockpaperscissorsengine.GameEngine;
import com.aldo.rockpaperscissorsengine.GameEngineFactory;
import com.aldo.rockpaperscissorsengine.GameResult;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(JUnitParamsRunner.class)
public class EngineIntegrationTest {

    private Game game;
    private GameEngine engine;
    private GameResult result;
    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        result = mock(GameResult.class);
        engine = new GameEngineFactory().create(result, GameConfiguration.getWeapons().size());

        game = new Game(engine, GameConfiguration.getWeapons(), player1, player2);
    }

    @Test
    @Parameters
    public void givenPlayer1PlaysWinningMovePlayer1Wins(Weapons player1Weapon, Weapons player2Weapon) {
        givenPlayerPlaysWeapon(player1, player1Weapon);
        givenPlayerPlaysWeapon(player2, player2Weapon);

        whenGameRuns();
        
        expectPlayer1Wins();
    }
    
    @Test
    @Parameters
    public void givenPlayer2PlaysWinningMovePlayer2Wins(Weapons player1Weapon, Weapons player2Weapon) {
        givenPlayerPlaysWeapon(player1, player1Weapon);
        givenPlayerPlaysWeapon(player2, player2Weapon);

        whenGameRuns();
        
        expectPlayer2Wins();
    }
    
    @Test
    @Parameters
    public void givenPlayersPlaySameMoveGameIsDraw(Weapons player1Weapon, Weapons player2Weapon) {
        givenPlayerPlaysWeapon(player1, player1Weapon);
        givenPlayerPlaysWeapon(player2, player2Weapon);

        whenGameRuns();
        
        expectDraw();
    }
    
    public Object[] parametersForGivenPlayer1PlaysWinningMovePlayer1Wins(){
        return new Object[]{
            new Object[]{Weapons.ROCK, Weapons.SCISSORS},
            new Object[]{Weapons.SCISSORS, Weapons.PAPER},
            new Object[]{Weapons.PAPER, Weapons.ROCK},
        };
    }
    
    public Object[] parametersForGivenPlayer2PlaysWinningMovePlayer2Wins(){
        return new Object[]{
            new Object[]{Weapons.ROCK, Weapons.PAPER},
            new Object[]{Weapons.SCISSORS, Weapons.ROCK},
            new Object[]{Weapons.PAPER, Weapons.SCISSORS},
        };
    }
    
    public Object[] parametersForGivenPlayersPlaySameMoveGameIsDraw(){
        return new Object[]{
            new Object[]{Weapons.ROCK, Weapons.ROCK},
            new Object[]{Weapons.SCISSORS, Weapons.SCISSORS},
            new Object[]{Weapons.PAPER, Weapons.PAPER},
        };
    }

    private void whenGameRuns() {
        game.run();
    }

    private void givenPlayerPlaysWeapon(Player p, Weapons w) {
        when(p.getMove()).thenReturn(w.getPosition());
    }

    private void expectPlayer1Wins() {
        verify(result).player1Wins();
    }

    private void expectPlayer2Wins() {
        verify(result).player2Wins();
    }

    private void expectDraw() {
        verify(result).draw();
    }
}
