package designpatterns;

/**
 * Created by Serato, JV on November 24, 2016.
 */
public class KnifeBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("Whook");
    }
}
