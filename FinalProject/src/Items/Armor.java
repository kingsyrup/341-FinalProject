/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items;

import Interfaces.ItemInterface;

/**
 *
 * @author xg6856vd
 */
public class Armor implements ItemInterface {
    
    private final int strModifier;
    private final int defModifier;
    private final int hpModifier;
    private final String name;
    private final int tier;
    private final String type = "Armor";

    public Armor(int strModifier, int defModifier, int hpModifier, String name, int tier) {
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
    
    @Override
    public String getType(){
        return type;
    }
    
    @Override
    public int getTier(){
        return tier;
    }
}
