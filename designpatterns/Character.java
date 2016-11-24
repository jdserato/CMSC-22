package designpatterns;

/**
 * Created by Serato, JV on November 24, 2016.
 */
public abstract class Character {
    WeaponBehavior weapon;

    void setWeapon(WeaponBehavior w){
        this.weapon = w;
    }

    abstract void fight();
}
