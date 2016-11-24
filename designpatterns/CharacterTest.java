package designpatterns;

/**
 * Created by Serato, JV on November 24, 2016.
 */
public class CharacterTest {

    public static void main(String[] args) {
        // initialize
        Character queen = new Queen();
        // set up the strategies
        queen.setWeapon(new AxeBehavior());
        // test
        queen.fight();

        // initialize
        Character king = new King();
        // set up the strategies
        king.setWeapon(new BowAndArrowBehavior());
        // test
        king.fight();
    }

}