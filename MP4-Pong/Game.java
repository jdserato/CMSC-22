import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.*;

/**
 * Created by Jay Vince Serato on October 25, 2016.
 */

// The Game class is the main class for which all game implementations are made.
@SuppressWarnings("serial")
public class Game extends JPanel {
    static final int MAX_SPEED = 7;
    private Random rand = new Random();

    Ball ball = new Ball(this);

    PowerUp pow;
    Lengthen leng1;
    SlowDown spd1;
    boolean lengUsed = false, spdUsed = false;
    boolean lengExist = false, spdExist = false;
    private int lenX = randInt(0, FRAME_WIDTH - 50);
    private int lenY = randInt(70, FRAME_HEIGHT - 130);
    private int lenX2 = randInt(0, FRAME_WIDTH - 50);
    private int lenY2 = randInt(70, FRAME_HEIGHT - 130);
    private Color req = Color.GRAY;

    int speed = 1;
    static final int FRAME_WIDTH = 500;
    static final int FRAME_HEIGHT = 675;

    String player1 = JOptionPane.showInputDialog("Enter name of Player 1: (uses the controls 'LEFT' and 'RIGHT' button)");
    Racquet racquet1 = new Racquet(this, player1, ball, FRAME_HEIGHT - 100);
    private int P1Score;
    String player2 = JOptionPane.showInputDialog("Enter name of Player 2: (uses the controls 'A' and 'D' button)");
    Racquet racquet2 = new Racquet(this, player2, ball, 40);
    private int P2Score;

    public int randInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Mini Tennis");
        Game game = new Game();
        frame.add(game);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(9);
        }
    }

    public Game() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet1.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                racquet1.keyPressed(e);
            }
        });

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet2.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                racquet2.keyPressed(e);
            }
        });
        setFocusable(true);
    }

    private void move() {
        if (leng1 != null && pow == spd1) {
            if (leng1.gainPower()) {
                if (ball.ya < 0) {
                    leng1.benef = racquet1;
                } else {
                    leng1.benef = racquet2;
                }
                leng1.effects();
                leng1.used = true;
                lengUsed = true;
            }
        }
        if (pow != null && pow.gainPower() && !(pow.used)) {
            if (ball.ya < 0) {
                pow.benef = racquet1;
            } else {
                pow.benef = racquet2;
            }
            pow.effects();
            pow.used = true;
            if (pow instanceof Lengthen) {
                lengUsed = true;
            } else {
                spdUsed = true;
            }
        }

        if (speed == 2) {
            req = Color.PINK;
        } else if (speed == 4) {
            req = Color.orange;
        } else if (speed == 6){
            req = Color.RED;
        }

        ball.move();
        racquet1.move();
        racquet2.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        racquet1.paint(g2d);
        racquet2.paint(g2d);
        ball.paint(g2d);

        if ((speed >= 2) && !(lengUsed)) {
            if (!(lengExist)) {
                lenX = randInt(0, FRAME_WIDTH - 50);
                lenY = randInt(70, FRAME_WIDTH - 50);
                lengExist = true;
            }
            leng1 = new Lengthen(this, lenX, lenY);
            leng1.paint(g2d);
            pow = leng1;
        }
        if ((speed >= 6) && !(spdUsed)) {
            if (!(spdExist)) {
                lenX2 = randInt(0, FRAME_WIDTH - 50);
                lenY2 = randInt(70, FRAME_WIDTH - 50);
                spdExist = true;
            }
            spd1 = new SlowDown(this, lenX2, lenY2);
            spd1.paint(g2d);
            pow = spd1;
        }

        g2d.setColor(req);
        g2d.setFont(new Font("Verdana", Font.BOLD, 30));
        g2d.drawString(player1 + " = " + P1Score, 10, FRAME_HEIGHT - 50);
        g2d.drawString(player2 + " = " + P2Score, 10, 30);
    }

    void gameOver(Racquet winner) {
        Sound.BACK.stop();
        Sound.GAMEOVER.play();

        if (winner.toString().equals(player1)) {
            P1Score++;
        } else if (winner.toString().equals(player2)) {
            P2Score++;
        }

        JOptionPane.showMessageDialog(this, "The winner is " + winner + "!", winner + " wins!", JOptionPane.YES_NO_OPTION);
        ball = new Ball(this);
        racquet1 = new Racquet(this, player1, ball, FRAME_HEIGHT - 100);
        racquet2 = new Racquet(this, player2, ball, 40);
        lenX = randInt(0, FRAME_WIDTH - 50);
        lenY = randInt(70, FRAME_HEIGHT - 130);
        lenX2 = randInt(0, FRAME_WIDTH - 50);
        lenY2 = randInt(70, FRAME_HEIGHT - 130);
        leng1 = null;
        spd1 = null;
        pow = null;
        lengUsed = false;
        lengExist = false;
        spdUsed = false;
        spdExist = false;
        speed = 1;
        req = Color.GRAY;

        if (P1Score == 3 || P2Score == 3) {
            JOptionPane.showMessageDialog(this, "The champion is " + winner + "!" , "CONGRATULATIONS, " + winner + "!", JOptionPane.YES_NO_OPTION);

            String choice = JOptionPane.showInputDialog(this, "Restart Game? \n 1. Yes \n 2. No", "Restart?");
            if (choice.equals("1")){
                try {
                    setVisible(false);
                    main(null);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.exit(ABORT);
            }
        }
    }
}
