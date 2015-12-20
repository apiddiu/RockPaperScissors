package com.aldo.rockpaperscissors.gameConfiguration;

import java.util.Arrays;
import java.util.stream.Collectors;
import com.aldo.rockpaperscissorsengine.Weapon;
import java.util.Map;

public class GameConfiguration {

    private static final Map<Integer, Weapon> weapons;

    static {
        weapons = Arrays.asList(Weapons.values()).stream().map(
                w -> new Weapon(w.getPosition(), w.name())).collect(Collectors.toMap(w -> w.getPosition(), w -> w));
    }

    public static Map<Integer, Weapon> getWeapons() {
        return weapons;
    }
    
    public static Weapon retrieveMove(int move) {
        return weapons.get(move);
    }
}
