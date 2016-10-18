package Lab-6---RPG.hero;

/**
 * Created by Albores, Allyssa; Serato, Jay Vince; Sotto, Wina Gen on 9/29/16.
 */
public class Archer extends Hero {
    // INIT_HEALTH = 25;
    // because of Arrow Hit (ATTACK)
    // Arrow Hit = 5;
    // because of Armor
    // ARMOR = 3;
    // because of Bull's Eye (SPECIAL ATTACK)
    // BULLS_EYE = 12;
    

    public Archer(String name, int level) {
        super(name, 25, level, 3, 5, 12);
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

    public int attack() {
        return super.getAttack() + getLevel();
    }

    public int specialAttack() {
        return super.getSpecialAttack() + getLevel();
    }

    public String moves(){
        return "1. Arrow Hit\n" +
                "2. Bull's Eye\n" +
                "3. Dust Bow\n" +
                "4. Flee";
    }
}
