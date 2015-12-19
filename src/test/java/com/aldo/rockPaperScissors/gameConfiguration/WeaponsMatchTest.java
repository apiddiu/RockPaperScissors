package com.aldo.rockPaperScissors.gameConfiguration;

import com.aldo.rockpaperscissors.gameConfigurations.Weapons;
import com.aldo.rockpaperscissors.gameConfigurations.WeaponsMatch;
import java.util.Objects;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class WeaponsMatchTest {
    
    @Test
    @Parameters
    public void givenAPairOfWeaponsResultingWeaponsMatchIsEquivalentNoMatterTheWeaponsOrder(Weapons w0, Weapons w1){
        Assert.assertThat(Objects.equals(new WeaponsMatch(w0, w1), new WeaponsMatch(w1, w0)), is(true));
    }
    
    public Object[] parametersForGivenAPairOfWeaponsResultingWeaponsMatchIsEquivalentNoMatterTheWeaponsOrder(){
        return new Object[]{
            new Object[]{Weapons.ROCK, Weapons.ROCK},
            new Object[]{Weapons.ROCK, Weapons.PAPER},
            new Object[]{Weapons.ROCK, Weapons.SCISSORS},
            
            new Object[]{Weapons.SCISSORS, Weapons.SCISSORS},
            new Object[]{Weapons.SCISSORS, Weapons.ROCK},
            new Object[]{Weapons.SCISSORS, Weapons.PAPER},
            
            new Object[]{Weapons.PAPER, Weapons.PAPER},
            new Object[]{Weapons.PAPER, Weapons.ROCK},
            new Object[]{Weapons.PAPER, Weapons.SCISSORS},
        };
    }
}
