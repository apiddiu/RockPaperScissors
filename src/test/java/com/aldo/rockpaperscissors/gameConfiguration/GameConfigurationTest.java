package com.aldo.rockpaperscissors.gameConfiguration;

import junitparams.JUnitParamsRunner;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class GameConfigurationTest implements GameConfigurationTestingInterface{

    @Test
    public void gameConfigurationLoadsAllTheWeapons(){
        Assert.assertThat(GameConfiguration.weaponsCount(), is(equalTo(3)));
    }
    
    @Test
    public void givenAPlayerMoveConfigurationRetrievesTheRelativeWeapon(){
        for(Weapons w : Weapons.values()){
            Assert.assertThat(w, is(equalTo(GameConfiguration.retrieveMove(w.getPosition()))));
        }
    }
    
    @Test
    public void givenAPlayerMoveNameConfigurationRetrievesTheRelativeWeapon(){
        
        for(Weapons w : Weapons.values()){
            Assert.assertThat(w, is(equalTo(GameConfiguration.retrieveMove(w.name()))));
            Assert.assertThat(w, is(equalTo(GameConfiguration.retrieveMove(w.name().toLowerCase()))));
        }
    }
}
