package com.aldo.rockpaperscissors.gameConfigurations;

import java.util.HashMap;
import java.util.Map;

public class GameConfiguration {
    private final Map<WeaponsMatch, String> configuration;

    public GameConfiguration(){
        configuration = new HashMap<>();
        
        configuration.put(new WeaponsMatch(Weapons.ROCK, Weapons.ROCK), "Draw");
        configuration.put(new WeaponsMatch(Weapons.PAPER, Weapons.PAPER), "Draw");
        configuration.put(new WeaponsMatch(Weapons.SCISSORS, Weapons.SCISSORS), "Draw");
        configuration.put(new WeaponsMatch(Weapons.ROCK, Weapons.PAPER), "Paper covers Rock");
        configuration.put(new WeaponsMatch(Weapons.ROCK, Weapons.SCISSORS), "Rock crushes Scissors");
        configuration.put(new WeaponsMatch(Weapons.PAPER, Weapons.SCISSORS), "Scissors cut Paper");      
    }
            

    public String matchDescription(Weapons w1, Weapons w2){
        return matchDescription(new WeaponsMatch(w1, w2));
    }
    
    public String matchDescription(WeaponsMatch match){
        return configuration.get(match);
    }
}
