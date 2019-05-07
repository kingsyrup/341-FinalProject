package NPCs;

import Interfaces.*;
import java.io.Serializable;
import java.util.*;
/**
 *
 * @author xg6856vd
 */
public class Hero implements NpcInterface, Serializable {
    
    //data members
    private int str = 6;
    private int def = 5;
    private int hp = 45;
    private int maxHp = 45;
    public String name;
    private boolean isKilled = false;
    private boolean isArmorEquipped = false;
    private boolean isWeaponEquipped = false;
    private ItemInterface equippedArmor;
    private ItemInterface equippedWeapon;
    private int strAdjustment;
    private int defAdjustment;
    private int hpAdjustment; 
    public ArrayList<ItemInterface> inventory = new ArrayList();

    //default constructor
    public Hero() {
    }
    
    //init constructor
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
    
    public ItemInterface getEquippedArmor(){
        return this.equippedArmor;
    }
    
    public ItemInterface getEquippedWeapon(){
        return this.equippedWeapon;
    }
    
    public void equipItem(ItemInterface item){
        
        if(item.getType() == "Armor"){
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
        
        if(item.getType() == "Weapon"){
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
    
    public void unequipItem(ItemInterface item){
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
    
    //dice roll to randomize attack damage, modifiers are 1-3, might add crit chance
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
    
    public boolean weaponEquipped() {
        return isWeaponEquipped;
    }
    
    public boolean armorEquipped() {
        return isArmorEquipped;
    }
}
