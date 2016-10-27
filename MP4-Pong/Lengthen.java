import java.awt.*;

/**
 * Created by Jay Vince Serato on 10/24/2016.
 */

// The Lengthen class extends the PowerUp class for it shares a IS-A relationship with the abstract class.
// Furthermore, the Lengthen class will elongate the racquet prior to the activation by 33%.
public class Lengthen extends PowerUp{
    private boolean onlyOnce = false;

    public Lengthen(Game game, int x, int y) {
        super(game, x, y, 6);
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(Color.green);
        g.fillRect(x, y, DIAMETER, DIAMETER);
    }

    @Override
    public void effects() {
        if (!(onlyOnce)) {
            benef.WIDTH *= 1.33;
            benef.x = Game.FRAME_WIDTH / 2 - benef.WIDTH / 2;
            onlyOnce = true;
        }
    }

    @Override
    public void dissolve() {
        game.racquet1.WIDTH = Game.FRAME_WIDTH / 5;
        game.racquet2.WIDTH = Game.FRAME_WIDTH / 5;
        game.lengUsed = false;
    }
}