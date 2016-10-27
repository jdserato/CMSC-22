import java.awt.*;

/**
 * Created by Jay Vince Serato on October 25, 2016.
 */

// The SlowDown class extends the PowerUp class for it shares a IS-A relationship with the abstract class.
// Furthermore, the SlowDown class will set the speed back to 2.
public class SlowDown extends PowerUp {
    private boolean onlyOnce = false;

    public SlowDown(Game game, int x, int y) {
        super(game, x, y, 2);
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, DIAMETER, DIAMETER);
    }

    @Override
    public void effects() {
        if (!(onlyOnce)){
            game.speed = 2;
            onlyOnce = true;
        }
    }

    @Override
    public void dissolve() {
        game.spdUsed = false;
    }
}
