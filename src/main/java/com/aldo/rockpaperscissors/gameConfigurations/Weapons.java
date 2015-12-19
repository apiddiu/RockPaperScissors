package com.aldo.rockpaperscissors.gameConfigurations;

public enum Weapons {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);
    
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
