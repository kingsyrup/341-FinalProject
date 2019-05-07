package NPCs;
import Interfaces.NpcInterface;
import java.util.Random;

/**
 * An enemy that the player fights.
 * @author Ajay Basnyat, Erik Bjorngaard
 */
public class Enemy implements NpcInterface {

    private int str;
    private int def;
    private int hp;
    private int maxHp;
    private String name;
    private boolean isKilled = false;
    
    /**
     * Generate an enemy with the specified hp, defense, strength, and name.
     * @param hitPoints The amount of hp the enemy has.
     * @param defense The amount of defense the enemy has.  Reduces damage taken.
     * @param strength The amount of strength the enemy has.  Increases damage dealt.
     * @param name The enemy's name.
     */
    public Enemy(int hitPoints, int defense, int strength, String name){
        this.str = strength;
        this.hp = hitPoints;
        this.def = defense;
        this.name = name;
        this.maxHp = hitPoints;
    }
    
    @Override
    public String getName(){
        return name;
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
                this.hp = 0;
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
}
