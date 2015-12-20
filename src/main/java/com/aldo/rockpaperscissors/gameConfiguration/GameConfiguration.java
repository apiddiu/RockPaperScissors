package com.aldo.rockpaperscissors.gameConfiguration;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Map;

public class GameConfiguration {

    private static final Map<Integer, Weapons> weapons;

    static {
        weapons = Arrays.asList(Weapons.values()).stream().collect(Collectors.toMap(w -> w.getPosition(), w -> w));
    }

    public static Map<Integer, Weapons> getWeapons() {
        return weapons;
    }
    
    public static Weapons retrieveMove(int move) {
        return weapons.get(move);
    }
    
    public static Weapons retrieveMove(String move) {
        return Weapons.weaponByName(move);
    }
    
    public static int weaponsCount(){
        return Weapons.values().length;
    }
}
