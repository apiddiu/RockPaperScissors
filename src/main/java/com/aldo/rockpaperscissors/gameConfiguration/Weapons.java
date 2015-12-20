package com.aldo.rockpaperscissors.gameConfiguration;

public enum Weapons {
    ROCK(0),
    PAPER(1),
    SCISSORS(2);
    
    private Weapons(int position){
        this.position = position;
    }
    
    private final int position;
    
    public int getPosition(){
        return position;
    }
    
    public static Weapons weaponByName(String weaponName){
        return Weapons.valueOf(weaponName.toUpperCase());
    }
}
