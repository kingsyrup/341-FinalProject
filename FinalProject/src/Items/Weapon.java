package Items;

import Interfaces.ItemInterface;

/**
 *
 * @author xg6856vd
 */
public class Weapon implements ItemInterface {
    
    private final int strModifier;
    private final int defModifier;
    private final int hpModifier;
    private final String name;
    private final int tier;

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
        return "Weapon";
    }
    
    public int getTier(){
        return tier;
    }
}