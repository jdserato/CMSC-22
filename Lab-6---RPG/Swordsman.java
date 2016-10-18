package Lab-6---RPG.hero;

/**
 * Created by Albores, Allyssa; Serato, Jay Vince; Sotto, Wina Gen on 9/29/16.
 */
public class Swordsman extends Hero {
    // INIT_HEALTH = 35;
    // because of Stab (ATTACK)
    // STAB = 5;
    // because of Armor
    // ARMOR = 4;
    // special attack: Sword Toss
    // SWORD_TOSS = 10;

    public Swordsman(String name, int level) {
        super(name, 35, level, 4, 5, 10);
    }

    public int attack() {
        return super.getAttack() + getLevel();
    }

    public int specialAttack() {
        return super.getSpecialAttack() + getLevel();
    }

    public int takeDamage(int damage) {
        // reduce damage because of armor!!! oh yeah!
        damage -= super.getArmor();
        if (super.getHp() < 0){
            super.setHp(0);
        }
        // set new hp
        return super.takeDamage(damage);
    }

    public String moves(){
        return "1. Stab\n" +
                "2. Sword Toss\n" +
                "3. Eye Slash\n" +
                "4. Flee";

    }
}
