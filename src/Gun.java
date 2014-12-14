import java.awt.*;

/**
 * Created by John on 12/10/2014.
 */
public class Gun {
    public int x = 0;
    private final int vx = 8;
    public int y = Board.HEIGHT - 110;
    private int[] xPointOffsets = { 0, 60, 60, 35, 35, 30, 25, 25,  0,  0};
    private int[] yPointOffsets = {20, 20, 10, 10, 10,  0, 10, 10, 10, 20};
    private int[] currentXs = new int[xPointOffsets.length];
    private int[] currentYs = new int[yPointOffsets.length];
    private Board board;
    private final Bullet bullet;

    public Gun(Board board) {
        this.board = board;
        bullet = new Bullet(board);
    }

    public void advanceBullet() {
        bullet.move();
    }
    public void fire() {
        bullet.fire(x + 30, y);
    }
    public void reset() {
        x = 0;
    }
    public void moveRight() {
        x = x + vx;
    }
    public void moveLeft() {
        x = x - vx;
        if (x < 0) {
            x = 0;
        }
    }
    public void paint(Graphics2D g) {
        calcPoints();
        Polygon poly = new Polygon(currentXs, currentYs, xPointOffsets.length);
        g.setColor(Color.GREEN);
        g.fill(poly);
        bullet.paint(g);
    }

    private void calcPoints() {
        for (int i = 0; i < xPointOffsets.length; i++) {
           int newX = x + xPointOffsets[i];
           int newY = y + yPointOffsets[i];
           currentXs[i] = newX;
           currentYs[i] = newY;
        }
    }
}
