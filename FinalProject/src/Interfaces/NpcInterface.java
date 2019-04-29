package Interfaces;

/**
 *
 * @author xg6856vd
 */
public interface NpcInterface {
    
    //standard getters/setters
    public String getName();
    public int getStr();
    public void setStr(int str);
    public int getDef();
    public void setDef(int def);
    public int getHp();
    public void setHp(int hp);
    public int maxHp();
    
    //combat
    public int attack(NpcInterface defender);
    public void attacked(int damage);
    public boolean isKilled();
    public int diceRoll();
}
