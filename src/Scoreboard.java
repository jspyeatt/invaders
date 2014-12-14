import java.awt.*;

/**
 * Created by John on 12/10/2014.
 */
public class Scoreboard {
    private int pointTotal = 0;
    public void paint(Graphics2D g) {

        g.setColor(Color.WHITE);
        g.setFont(new Font("Verdana", Font.BOLD, 30));
        g.drawString(String.valueOf(pointTotal), Board.WIDTH - 100, Board.HEIGHT - 30);
    }
    public void incrementTotal(int newPoints) {
        pointTotal += newPoints;
    }
    public void incrementTotal(Alien alien) {
        incrementTotal(alien.points);
    }
    public void reset() {
        pointTotal = 0;
    }
}
