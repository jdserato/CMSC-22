package Lab-6---RPG;

/**
 * Created by Albores, Allyssa; Serato, Jay Vince; Sotto, Wina Gen on 9/29/16.
 */
public class Monster extends RPGCharacter{
    private int attackDamage;

    public Monster(String name, int hp, int attackDamage) {
        super(name, hp, 2);
        this.attackDamage = attackDamage;
    }

    public int takeDamage(int damage) {
        super.setHp(super.getHp() - damage + super.getArmor());
        if (super.getHp() < 0){
            super.setHp(0);
        }
        return super.getHp();
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int attack() {
        return attackDamage;
    }
}
