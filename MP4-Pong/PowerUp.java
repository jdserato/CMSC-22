import java.awt.*;

/**
 * Created by Jay Vince Serato on 10/24/2016.
 */

// The PowerUp class as an abstract class such that certain classes would be implementing the abstract methods.
public abstract class PowerUp {

    Game game;
    boolean used = false;
    int x;
    int y;
    int expiry;
    static final int DIAMETER = 50;
    Racquet benef;

    public PowerUp(Game game, int x, int y, int expiry) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.expiry = expiry;
    }

    private Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }

    public boolean gainPower() {
        return game.ball.getBounds().intersects(getBounds());
    }

    public abstract void paint(Graphics2D g);

    public abstract void effects();

    public abstract void dissolve();
}
