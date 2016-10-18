package Lab-6---RPG;

/**
 * Created by Albores, Allyssa; Serato, Jay Vince; Sotto, Wina Gen on 9/29/16.
 */
public abstract class RPGCharacter {

    private String name;
    private int hp;
    private int armor;
    public static final int MAXIMUM_ACCURACY = 4;
    private double accuracy = 3.0;

    public RPGCharacter(String name, int hp, int armor) {
        this.name = name;
        this.hp = hp;
        this.armor = armor;
    }

    // implement in subclass
    public abstract int attack();

    // checks to see if character is still alive
    public boolean isAlive() {
        return hp > 0 ? true : false;
    }

    // may be overriden in subclass, damage is dependent on hero type
    public int takeDamage(int damage) {
        hp -= damage;
        if (hp < 0){
            hp = 0;
        }
        return hp;
    }

    // getters setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public double getAccuracy(){
        return accuracy;
    }

    public void setAccuracy(double accuracy){
        this.accuracy = accuracy;
    }

    public int getMaximumAccuracy(){
        return MAXIMUM_ACCURACY;
    }

    public int getArmor(){
        return armor;
    }

    public void setArmor(int armor){
        this.armor = armor;
    }

    @Override
    public String toString() {
        
        return "RPGCharacter{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                '}';
    }
}
