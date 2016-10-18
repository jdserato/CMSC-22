package Lab-6---RPG.hero;

/**
 * Created by Albores, Allyssa; Serato, Jay Vince; Sotto, Wina Gen on 9/29/16.
 */
public abstract class Hero extends RPGCharacter {
    private int level;
    private int EXP;
    private int attack;
    private int specialAttack;
    public final static int EXP_LEVEL_UP = 15;

    public Hero(String name, int hp, int level, int armor, int attack, int specialAttack) {
        super(name, hp, armor);
        this.level = level;
        this.attack = attack;
        this.specialAttack = specialAttack;
    }

    public abstract String moves();

    public int attack(){
        return 0;
    }

    // getters and setters
    public void setEXP(int EXP){
        this.EXP = EXP;
    }

    public int getEXP(){
        return EXP;
    }

    public int getExpLevelUp(){
        return EXP_LEVEL_UP;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAttack() {
        return attack;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }
}
