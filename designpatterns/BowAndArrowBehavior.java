package designpatterns;

/**
 * Created by Serato, JV on November 24, 2016.
 */
public class BowAndArrowBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("Thwaack… Thud");
    }
}
