import java.awt.*;
import java.util.Random;

/**
 * Created by Jay Vince Serato on 10/20/2016.
 */

// The Ball class defines and created the ball as the ping pong of the game.
public class Ball {
    private Random rand = new Random();

    private static final int DIAMETER = 30;

    // coordinates of the ball
    // the ball will be initially placed in the upper half for the player would not have a hard time catching it
    int x = rand.nextInt(Game.FRAME_WIDTH - 40) + 1;
    int y = rand.nextInt((Game.FRAME_HEIGHT/4 - 40) + 1) + 40;

    // next coordinate of the ball
    int xa = 1;
    int ya = 1;

    private Game game;

    public Ball(Game game) {
        this.game = game;
    }

    void move() {

        boolean changeDirection = true;

        if (x + xa < 0) {
            xa = game.speed;
        }
        else if (x + xa > game.getWidth() - DIAMETER) {
            xa = -game.speed;
        }
        // if the ball touches the upper or lower bound of the game, then the game is over.
        else if (y + ya < 0) {
            game.gameOver(game.racquet1);
        }
        else if (y + ya > game.getHeight() - DIAMETER) {
            game.gameOver(game.racquet2);
        }

        else if (collision1() || collision2()) {
            if (game.pow != null && game.pow.used) {
                game.pow.effects();
                if (game.leng1 != null) {
                    game.leng1.expiry--;
                    if (game.leng1.expiry == 0) {
                        game.leng1.dissolve();
                        game.leng1 = null;
                        game.lengExist = false;
                    }
                }
                if (game.spd1 != null) {
                    game.spd1.expiry--;
                    if (game.spd1.expiry == 0) {
                        game.spd1.dissolve();
                        game.spd1 = null;
                        game.spdExist = false;
                    }
                }
            }

            ya = -game.speed;
            if (collision1()) {
                y = game.racquet1.getTopY() - DIAMETER;
            } else {
                y = (game.racquet2.getTopY() + DIAMETER);
                ya *= -1;

                if (game.speed < Game.MAX_SPEED) {
                    game.speed++;
                }
            }
        } else {
            changeDirection = false;
        }

        if (changeDirection) {
            Sound.BALL.play();
        }
        x = x + xa;
        y = y + ya;
    }

    private boolean collision1() {
        return game.racquet1.getBounds().intersects(getBounds());
    }

    private boolean collision2() {
        return game.racquet2.getBounds().intersects(getBounds());
    }

    void paint(Graphics2D g) {
        g.setColor(Color.MAGENTA);
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}