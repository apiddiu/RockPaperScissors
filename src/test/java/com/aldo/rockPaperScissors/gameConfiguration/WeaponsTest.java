package com.aldo.rockPaperScissors.gameConfiguration;

import com.aldo.rockpaperscissors.gameConfigurations.Weapons;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class WeaponsTest {

    public WeaponsTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    @Parameters
    public void givenAnExistingWeaponNameNoMatterTheCaseWeaponByNameReturnsTheWeaponTest(String name, Weapons weapon){
        assertThat(weapon, is(equalTo(Weapons.weaponByName(name))));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void givenAWrongWeaponNameWeaponByNameThrowsExceptionTest(){
        Weapons.weaponByName("UnexistingWeapon");
    }
    
    public Object[] parametersForGivenAnExistingWeaponNameNoMatterTheCaseWeaponByNameReturnsTheWeaponTest(){
        return new Object[]{
            new Object[]{"ROCK", Weapons.ROCK},
            new Object[]{"rock", Weapons.ROCK},
            new Object[]{"RoCk", Weapons.ROCK},
            new Object[]{"PAPER", Weapons.PAPER},
            new Object[]{"paper", Weapons.PAPER},
            new Object[]{"pApEr", Weapons.PAPER},
            new Object[]{"SCISSORS", Weapons.SCISSORS},
            new Object[]{"scissors", Weapons.SCISSORS},
            new Object[]{"sCiSSoRs", Weapons.SCISSORS},
        };
    }

}