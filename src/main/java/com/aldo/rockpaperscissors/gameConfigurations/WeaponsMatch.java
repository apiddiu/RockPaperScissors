package com.aldo.rockpaperscissors.gameConfigurations;

import java.util.Objects;

public class WeaponsMatch {

    private final Weapons weapon0;
    private final Weapons weapon1;

    public WeaponsMatch(Weapons w0, Weapons w1) {
        this.weapon0 = w0;
        this.weapon1 = w1;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        if(this==obj){
            return true;
        }
            
        
        if (obj instanceof WeaponsMatch) {
            WeaponsMatch other = (WeaponsMatch) obj;

            return (Objects.equals(weapon0, other.weapon0) && Objects.equals(weapon1, other.weapon1))
                    || (Objects.equals(weapon0, other.weapon1) && Objects.equals(weapon1, other.weapon0));

        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weapon0, weapon1);
    }

}
