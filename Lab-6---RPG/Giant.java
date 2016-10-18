package Lab-6---RPG.hero;

/**
 * Created by Albores, Allyssa; Serato, Jay Vince; Sotto, Wina Gen on 9/29/16.
 */
public class Giant extends Hero {
    // INIT_HEALTH = 50;
    // because of Punch (ATTACK)
    // PUNCH = 5;
    // because of Armor
    // ARMOR = 7;
    // because of Body Slam (SPECIAL ATTACK)
    // BODY_SLAM = 7;

    public Giant(String name, int level) {
        super(name, 50, level, 7, 5, 7);
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
        return "1. Punch\n" +
                "2. Body Slam\n" +
                "3. Head Clap\n" +
                "4. Flee";

    }
}
