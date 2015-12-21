package com.aldo.rockpaperscissors.gameConfiguration;

public enum Weapons {
    ROCK(0, "images/Rock.png"),
    PAPER(1, "images/Paper.png"),
    SCISSORS(2, "images/Scissors.png");
    
    private Weapons(int position, String imageUrl){
        this.position = position;
        this.imageUrl = imageUrl;
    }
    
    private final int position;
    private final String imageUrl;
    
    public int getPosition(){
        return position;
    }
    
    public String getImageUrl(){
        return imageUrl;
    }
    
    public static Weapons weaponByName(String weaponName){
        return Weapons.valueOf(weaponName.toUpperCase());
    }
}
