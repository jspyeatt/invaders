import java.awt.*;

/**
 * Created by John on 12/10/2014.
 */
public class Bullet {

    private static final int WIDTH = 3;
    private static final int HEIGHT = 12;
    private final int vy = 3;
    public int x = 0;
    public int y = 0;
    private Board board;
    private boolean fired = false;

    public Bullet(Board b) {
        this.board = b;
    }

    public void paint(Graphics2D g) {
        if (fired) {
            g.setColor(Color.YELLOW);
            g.fillRect(x, y, WIDTH, HEIGHT);
        }
    }

    public void fire(int x, int y) {
        fired = true;
        this.x = x;
        this.y = y;
    }

    public void move() {
        if (fired) {
            y -= vy;
            if (y < 0) {
                destroyed();
            }
        }
    }
    public void destroyed() {
        fired = false;
    }
}
