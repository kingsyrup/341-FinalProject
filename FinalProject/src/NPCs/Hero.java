/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NPCs;

import Interfaces.NpcInterface;

/**
 *
 * @author xg6856vd
 */
public class Hero implements NpcInterface {
    
    private int str = 3;
    private int def = 3;
    private int hp = 35;

    public Hero() {
    }
    
    public Hero(int hitPoints, int defense, int strength){
        this.str = strength;
        this.hp = hitPoints;
        this.def = defense;
    }
    
    public String name(){
        return "Hero";
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
    
}
