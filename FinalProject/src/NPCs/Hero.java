package NPCs;

import Interfaces.*;
import java.util.*;

/**
 * The player's character.
 * @author Ajay Basnyat, Erik Bjorngaard
 */
public class Hero implements NpcInterface {
    
    /**
     * The hero's name.
     */
    public String name;
    
    //data members
    private int str = 6;
    private int def = 5;
    private int hp = 45;
    private int maxHp = 45;
    private boolean isKilled = false;
    private boolean isArmorEquipped = false;
    private boolean isWeaponEquipped = false;
    private ItemInterface equippedArmor;
    private ItemInterface equippedWeapon;
    private int strAdjustment;
    private int defAdjustment;
    private int hpAdjustment; 

    /**
     * An array list of items that the hero has in their inventory.
     */
    public ArrayList<ItemInterface> inventory = new ArrayList();

    /**
     * The default hero constructor.  Creates a hero object with the default values.
     */
    public Hero() {
    }
    
    /**
     * Creates a hero with the specified hp, defense, strength, and name.
     * @param hitPoints The amount of hp the hero has.
     * @param defense The amount of defense the hero has.  Reduces damage taken.
     * @param strength The amount of strength the hero has.  Increases damage dealt.
     * @param name The hero's name.
     */
    public Hero(int hitPoints, int defense, int strength, String name){
        this.str = strength;
        this.hp = hitPoints;
        this.def = defense;
        this.name = name;
    }
    
    @Override
    public String getName(){
        return name;
    }
    
    /**
     * Sets the hero's name to the specified value.
     * @param name The hero's name.
     * @ensure The hero's name is set as the specified string.
     */
    public void setName(String name){
        this.name = name;
    }
    
    @Override
    public int getStr() {
        return str;
    }

    @Override
    public void setStr(int str) {
        this.str = str;
    }

    @Override
    public int getDef() {
        return def;
    }

    @Override
    public void setDef(int def) {
        this.def = def;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }
    
    /**
     * Returns the armor the hero currently has equipped.
     * @return The armor that the hero currently has equipped.
     * @ensure The hero's currently equipped armor is returned.
     */
    public ItemInterface getEquippedArmor(){
        return this.equippedArmor;
    }
    
    /**
     * Returns the weapon the hero currently has equipped.
     * @return The weapon that the hero currently has equipped.
     * @ensure The hero's currently equipped weapon is returned.
     */
    public ItemInterface getEquippedWeapon(){
        return this.equippedWeapon;
    }
    
    /**
     * Equips the specified item to the hero, if a similar type of item is equipped
     * the equipped item is unequipped, then the new item is equipped in it's place.
     * @param item The item to be equipped.
     * @ensure The specified item is equipped.
     */
    public void equipItem(ItemInterface item){
        
        //item is armor
        if("Armor".equals(item.getType())){
            if(isArmorEquipped == true){
                this.unequipItem(getEquippedArmor());
            }

            this.equippedArmor = item;
            this.setDef(def + item.getDefModifier());
            this.setStr(str + item.getStrModifier());
            this.setHp(hp + item.getHpModifier());
            this.maxHp = maxHp + item.getHpModifier();

            isArmorEquipped = true;
        }
        
        //item is a weapon
        if("Weapon".equals(item.getType())){
            if(isWeaponEquipped == true){
                this.unequipItem(getEquippedWeapon());
            }

            this.equippedWeapon = item;
            this.setDef(def + item.getDefModifier());
            this.setStr(str + item.getStrModifier());
            this.setHp(hp + item.getHpModifier());
            this.maxHp = maxHp + item.getHpModifier();

            isWeaponEquipped = true;
        }
    }
    
    /**
     * Unequip the specified item from the hero.
     * @param item The item to be unequipped.
     * @ensure The specified item is unequipped.
     */
    public void unequipItem(ItemInterface item){
        
        //The specified item is currently equipped armor
        if(item.getType() == "Armor" && item.getName() == this.equippedArmor.getName()){
            strAdjustment = this.equippedArmor.getStrModifier();
            hpAdjustment = this.equippedArmor.getHpModifier();
            defAdjustment = this.equippedArmor.getDefModifier();
            this.equippedArmor = null;
            this.setDef(def - defAdjustment);
            this.setHp(hp - hpAdjustment);
            this.setStr(str - strAdjustment);
            this.maxHp = maxHp - hpAdjustment;
            isArmorEquipped = false;
        }
        
        //The specified item is currently equipped weapon
        if(item.getType() == "Weapon" && item.getName() == this.equippedWeapon.getName()){
            strAdjustment = this.equippedWeapon.getStrModifier();
            hpAdjustment = this.equippedWeapon.getHpModifier();
            defAdjustment = this.equippedWeapon.getDefModifier();
            this.equippedWeapon = null;
            this.setDef(def - defAdjustment);
            this.setHp(hp - hpAdjustment);
            this.setStr(str - strAdjustment);
            this.maxHp = maxHp - hpAdjustment;
            isWeaponEquipped = false;
        }
    }
    
    /**
     * Adds an item to the hero's inventory.
     * @param item The item to be added to the hero's inventory.
     * @ensure The specified item is added to the hero's inventory.
     */
    public void addToInventory(ItemInterface item){
        inventory.add(item);
    }
    
    @Override
    public int attack(NpcInterface defender){
        int attack = this.getStr() * diceRoll();
        int defend = defender.getDef();
        
        int damage = attack - defend;
        if(damage < 0){
            damage = 0;
        }

        defender.attacked(damage);
        
        return damage;
    }
    
    @Override
    public void attacked(int damage){
        if(damage > 0){
            this.hp -= damage;
            if(this.hp <= 0){
                this.isKilled = true;
            }
        }
    }
    
    //dice roll to randomize attack damage, modifiers are 1-3
    @Override
    public int diceRoll(){
        Random rng = new Random();
        int modifier = (rng.nextInt(3) + 1);
        return modifier;
    }
    
    @Override
    public boolean isKilled(){
        return isKilled;
    }
    
    @Override
    public int maxHp(){
        return maxHp;
    }
    
    /**
     * Determines whether a weapon is currently equipped.
     * @return True if a weapon is equipped, false if no weapon is equipped.
     * @ensure A boolean value is returned dependent on whether a weapon is equipped.
     */
    public boolean weaponEquipped() {
        return isWeaponEquipped;
    }
    
    /**
     * Determines whether armor is currently equipped.
     * @return True if armor is equipped, false if no armor is equipped.
     * @ensure A boolean value is returned dependent on whether armor is equipped.
     */
    public boolean armorEquipped() {
        return isArmorEquipped;
    }
}
