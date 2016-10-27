import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Jay Vince Serato on 10/20/2016.
 */

// The Racquet class defines and creates the platform for where the ball would be caught and bounced back.
public class Racquet{
    private Game game;
    private int Y;
    int WIDTH = Game.FRAME_WIDTH / 5;
    private int HEIGHT = 10;
    int x = Game.FRAME_WIDTH / 2 - WIDTH / 2;
    private int xa = 0;
    private String player;
    Ball ball;

    public Racquet(Game game, String player, Ball ball, int Y) {
        this.game = game;
        this.player = player;
        this.ball = ball;
        this.Y = Y;
    }

    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth() - WIDTH) {
            x = x + xa;
        }
    }

    public void paint(Graphics2D g) {
        if (player.equals(game.player1)) {
            g.setColor(Color.BLUE);
        } else {
            g.setColor(Color.RED);
        }
        g.fillRect(x, Y, WIDTH, HEIGHT);
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (player.equals(game.player1)) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (game.spdExist) {
                    xa = -4;
                } else if (game.speed >= 6) {
                    xa = -8;
                } else {
                    xa = -game.speed;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (game.spdExist) {
                    xa = 4;
                } else if (game.speed >= 6) {
                    xa = 8;
                } else {
                    xa = game.speed;
                }
            }
        } else {
            if (e.getKeyCode() == KeyEvent.VK_A) {
                if (game.spdExist) {
                    xa = -4;
                } else if (game.speed >= 6) {
                    xa = -8;
                } else {
                    xa = -game.speed;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_D) {
                if (game.spdExist) {
                    xa = 4;
                } else if (game.speed >= 6) {
                    xa = 8;
                } else {
                    xa = game.speed;
                }
            }
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, Y, WIDTH, HEIGHT);
    }

    int getTopY() {
        return Y - HEIGHT;
    }

    public String toString() {
        return player;
    }
}