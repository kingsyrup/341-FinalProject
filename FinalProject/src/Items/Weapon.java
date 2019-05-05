package Items;

import Interfaces.ItemInterface;
import java.io.Serializable;

/**
 *
 * @author xg6856vd
 */
public class Weapon implements ItemInterface, Serializable {
    
    private final int strModifier;
    private final int defModifier;
    private final int hpModifier;
    private final String name;
    private final int tier;
    private final String type = "Weapon";

    public Weapon(int strModifier, int defModifier, int hpModifier, String name, int tier) {
        this.strModifier = strModifier;
        this.defModifier = defModifier;
        this.hpModifier = hpModifier;
        this.name = name;
        this.tier = tier;
    }

    @Override
    public String getName(){
        return name;
    }
    
    @Override
    public int getStrModifier() {
        return strModifier;
    }

    @Override
    public int getHpModifier() {
        return hpModifier;
    }

    @Override
    public int getDefModifier() {
        return defModifier;
    }
    
    public String getType(){
        return type;
    }
    
    public int getTier(){
        return tier;
    }
    
}