package com.aldo.rockpaperscissors.gameConfiguration;

import com.aldo.rockpaperscissorsengine.Weapon;
import java.util.Map;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
import org.junit.Test;

public class GameConfigurationTest implements GameConfigurationTestingInterface{

    @Test
    public void givenAWeaponsPairConfigurationRetrievesTheGameDescription(){
        Map<Integer, Weapon> configuration = GameConfiguration.getWeapons();
        
        Assert.assertThat(configuration.size(), is(equalTo(3)));
    }
}
